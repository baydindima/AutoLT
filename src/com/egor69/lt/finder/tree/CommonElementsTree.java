package com.egor69.lt.finder.tree;

import com.egor69.lt.util.StringOps;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElementsTree {
    private int occurrences;
    private boolean isPlaceholder;
    private boolean isWhitespace;
    private IElementType type;
    private String text;
    private Map<Integer, List<CommonElementsTree>> childrenTreesMap;

    public CommonElementsTree() {
        occurrences = 0;
        isPlaceholder = false;
        isWhitespace = false;
        type = null;
        text = null;
        childrenTreesMap = new HashMap<>();
    }

    public void add(ASTNode node) {
        if (isPlaceholder) return;
        ++occurrences;
        ASTNode[] children = node.getChildren(null);
        if (children.length != 0) {
            if (type != null) {
                if (type.equals(node.getElementType())) {
                    List<CommonElementsTree> childrenTrees = childrenTreesMap.get(children.length);
                    if (childrenTrees == null) {
                        childrenTrees = new ArrayList<>();
                        for (int i = 0; i < children.length; i++) {
                            CommonElementsTree childTree = new CommonElementsTree();
                            childrenTrees.add(childTree);
                        }
                        childrenTreesMap.put(children.length, childrenTrees);
                    }
                    for (int i = 0; i < children.length; ++i) {
                        childrenTrees.get(i).add(children[i]);
                    }
                } else {
                    isPlaceholder = true;
                }
            } else {
                type = node.getElementType();
                List<CommonElementsTree> childrenTrees = new ArrayList<>();
                for (ASTNode child : children) {
                    CommonElementsTree childTree = new CommonElementsTree();
                    childTree.add(child);
                    childrenTrees.add(childTree);
                }
                childrenTreesMap.put(children.length, childrenTrees);
            }
        } else {
            if (text != null) {
                String nodeText = node.getText();
                if (!(isWhitespace && nodeText.matches("\\s+") || text.equals(nodeText))) {
                    isPlaceholder = true;
                }
            } else {
                text = node.getText();
                if (text.matches("\\s+")) isWhitespace = true;
            }
        }
    }

    public String get() {
        Set<String> res = new HashSet<>();
        if (isPlaceholder || occurrences < 30) return "_";
        if (childrenTreesMap.isEmpty()) return text;
        Set<String> ss = new HashSet<>();
        childrenTreesMap.values().forEach(childrenTrees -> {
            ss.add(childrenTrees.stream().map(CommonElementsTree::get).reduce("", (s1, s2) -> (s1 + s2).replaceAll("_(_|\\s)*_", "_")));
            /*List<Set<String>> parts = childrenTrees.stream().map(CommonElementsTree::get).collect(Collectors.toList());
            res.addAll(StringOps.product(parts));*/
        });
        return ss.stream().reduce("", (s1, s2) -> s1.length() > s2.length() ? s1 : s2);
    }
}
