package com.egor69.lt.finder.simple;

import com.intellij.lang.ASTNode;

import java.util.*;
import java.util.stream.Collectors;

public class SimilarityChecker {
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

    public String getTemplate(int matchesBound) {
        if (!similarityTree.checkMatchesBound(matchesBound)) return null;
        String possibleTemplate = similarityTree.getTemplate(matchesBound);
        return possibleTemplate.replaceAll("(##)+", "_");
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
            }
        }

        public boolean checkMatchesBound(int matchesBound) {
            if (matches >= matchesBound) return true;
            for (SimilarityTree similarityTree : childrenTrees)
                if (similarityTree.checkMatchesBound(matchesBound))
                    return true;
            return false;
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
