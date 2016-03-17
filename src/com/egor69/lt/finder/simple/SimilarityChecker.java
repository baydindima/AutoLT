package com.egor69.lt.finder.simple;

import com.egor69.lt.util.Direction;
import com.intellij.lang.ASTNode;

import java.util.*;
import java.util.stream.Collectors;

public class SimilarityChecker {
    private static final int MATCHES_THRESHOLD = 10;

    private SimilarityTree similarityTree;

    public SimilarityChecker(ASTNode astNode) {
        similarityTree = new SimilarityTree(astNode);
    }

    public void add(ASTNode astNode) {
        similarityTree.add(astNode);
    }

    public void addAll(Collection<ASTNode> astNodes) {
        astNodes.forEach(this::add);
    }

    public SimpleTemplate getTemplate(int matchesBound) {
        int needfulMatches = Math.max(matchesBound, MATCHES_THRESHOLD);
        if (!similarityTree.checkMatchesBound(needfulMatches)) return null;
        return new SimpleTemplate(
                similarityTree.getMinMatches(needfulMatches),
                similarityTree.getTemplate(needfulMatches).replaceAll("(##)+", "_")
        );
    }

    private class SimilarityTree {
        //private ASTNode astNodeT;
        private String nodeText;
        private int matches;
        //private Map<String, Integer> textVariants;
        private List<SimilarityTree> childrenTrees;

        public SimilarityTree(ASTNode astNode) {
            //astNodeT = astNode;
            nodeText = astNode.getText();
            matches = 0;
            //textVariants = new HashMap<>();
            childrenTrees = Arrays.stream(astNode.getChildren(null))
                    .map(SimilarityTree::new)
                    .collect(Collectors.toList());
        }

        public void add(ASTNode astNode) {
            String astNodeText = astNode.getText();
            if (nodeText.equals(astNodeText)) ++matches;
            //textVariants.put(astNodeText, textVariants.getOrDefault(astNodeText, 0) + 1);
            ASTNode[] astNodeChildren = astNode.getChildren(null);
            if (childrenTrees.size() == astNodeChildren.length) {
                for (int i = 0; i < childrenTrees.size(); ++i) {
                    childrenTrees.get(i).add(astNodeChildren[i]);
                }
            } /*else {
                int[][] lcs = new int[childrenTrees.size() + 1][astNodeChildren.length + 1];
                Direction[][] lcsDirs = new Direction[childrenTrees.size() + 1][astNodeChildren.length + 1];
                for (int i = 0; i < childrenTrees.size(); ++i) {
                    for (int j = 0; j < astNodeChildren.length; ++j) {
                        if (childrenTrees.get(i).nodeText.equals(astNodeChildren[j].getText())) {
                            lcs[i + 1][j + 1] = lcs[i][j] + 1;
                            lcsDirs[i + 1][j + 1] = Direction.NW;
                        } else {
                            if (lcs[i][j + 1] > lcs[i + 1][j]) {
                                lcs[i + 1][j + 1] = lcs[i][j + 1];
                                lcsDirs[i + 1][j + 1] = Direction.N;
                            } else {
                                lcs[i + 1][j + 1] = lcs[i + 1][j];
                                lcsDirs[i + 1][j + 1] = Direction.W;
                            }
                        }
                    }
                }
                int i = childrenTrees.size();
                int j = astNodeChildren.length;
                while (i * j != 0) {
                    switch (lcsDirs[i][j]) {
                        case NW:
                            --i;
                            --j;
                            ++childrenTrees.get(i).matches;
                            break;
                        case N:
                            --i;
                            break;
                        case W:
                            --j;
                            break;
                    }
                }
            }*/
        }

        public boolean checkMatchesBound(int matchesBound) {
            if (matches >= matchesBound) return true;
            for (SimilarityTree similarityTree : childrenTrees)
                if (similarityTree.checkMatchesBound(matchesBound))
                    return true;
            return false;
        }

        public int getMinMatches(int matchesBound) {
            if (matches >= matchesBound) return matches;
            return childrenTrees.stream()
                    .map(child -> child.getMinMatches(matchesBound))
                    .min(Comparator.naturalOrder())
                    .orElse(Integer.MAX_VALUE);
        }

        public String getTemplate(int matchesBound) {
            if (matches >= matchesBound) return nodeText;
            if (childrenTrees.size() == 0) return "##";
            return childrenTrees.stream()
                    .map(child -> child.getTemplate(matchesBound))
                    .collect(Collectors.joining());
        }
    }
}