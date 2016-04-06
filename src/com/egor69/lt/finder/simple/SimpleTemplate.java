package com.egor69.lt.finder.simple;

import com.intellij.psi.tree.IElementType;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTemplate {
    private int occurrencesNumber;
    private String body;
    private SimpleTemplateTree tree;

    public SimpleTemplate(int occurrencesNumber, SimilarityChecker.SimilarityTree similarityTree) {
        this.occurrencesNumber = occurrencesNumber;
        tree = createTree(similarityTree);
        body = tree.getBody().replaceAll("_(\\s|_)*_", "_");
    }

    public int getOccurrencesNumber() {
        return occurrencesNumber;
    }

    public String getBody() {
        return body;
    }

    public int depth() {
        return tree.getDepth();
    }

    public int nodes() {
        return tree.getNodes();
    }

    public int elementNodes() {
        return tree.getElementNodes();
    }

    public int placeholderNodes() {
        return tree.getPlaceholderNodes();
    }

    public List<String> textNodes() {
        return tree.getTextNodes();
    }

    private SimpleTemplateTree createTree(SimilarityChecker.SimilarityTree similarityTree) {
        if (similarityTree.getChildrenTrees().size() == 0 && similarityTree.getMatches() >= occurrencesNumber)
            return new ElementNode(similarityTree.getNodeText());
        if (similarityTree.checkMatchesBound(occurrencesNumber))
            return new IntermediateNode(similarityTree.getChildrenTrees().stream().map(this::createTree).collect(Collectors.toList()));
        return new PlaceholderNode(similarityTree.getElementType());
    }

    private interface SimpleTemplateTree {
        String getBody();
        int getDepth();
        int getNodes();
        int getElementNodes();
        int getPlaceholderNodes();
        List<String> getTextNodes();
    }

    private class PlaceholderNode implements SimpleTemplateTree {
        private String body;
        private IElementType elementType;

        public PlaceholderNode(IElementType elementType) {
            this.elementType = elementType;
            body = "_";
        }

        @Override
        public int getDepth() {
            return 1;
        }

        @Override
        public int getNodes() {
            return 1;
        }

        @Override
        public int getElementNodes() {
            return 0;
        }

        @Override
        public int getPlaceholderNodes() {
            return 1;
        }

        @Override
        public String getBody() {
            return body;
        }

        @Override
        public List<String> getTextNodes() {
            return new LinkedList<>();
        }
    }

    private class IntermediateNode implements SimpleTemplateTree {
        private List<SimpleTemplateTree> subtrees;

        public IntermediateNode(List<SimpleTemplateTree> subtrees) {
            this.subtrees = subtrees;
        }

        @Override
        public int getDepth() {
            return 1 + subtrees.parallelStream().mapToInt(SimpleTemplateTree::getDepth).max().orElse(0);
        }

        @Override
        public int getNodes() {
            return 1 + subtrees.parallelStream().mapToInt(SimpleTemplateTree::getNodes).sum();
        }

        @Override
        public int getElementNodes() {
            return subtrees.parallelStream().mapToInt(SimpleTemplateTree::getElementNodes).sum();
        }

        @Override
        public int getPlaceholderNodes() {
            return subtrees.parallelStream().mapToInt(SimpleTemplateTree::getPlaceholderNodes).sum();
        }

        @Override
        public String getBody() {
            return subtrees.parallelStream().map(SimpleTemplateTree::getBody).collect(Collectors.joining());
        }

        @Override
        public List<String> getTextNodes() {
            List<String> result = new LinkedList<>();
            subtrees.stream().map(SimpleTemplateTree::getTextNodes).forEach(result::addAll);
            return result;
        }
    }

    private class ElementNode implements SimpleTemplateTree {
        private String body;

        public ElementNode(String body) {
            this.body = body;
        }

        @Override
        public int getDepth() {
            return 1;
        }

        @Override
        public int getNodes() {
            return 1;
        }

        @Override
        public int getElementNodes() {
            return 1;
        }

        @Override
        public int getPlaceholderNodes() {
            return 0;
        }

        @Override
        public String getBody() {
            return body;
        }

        @Override
        public List<String> getTextNodes() {
            List<String> result = new LinkedList<>();
            if (!body.matches("\\s*")) result.add(body);
            return result;
        }
    }

    @Override
    public int hashCode() {
        return body.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SimpleTemplate
                && body.equals(((SimpleTemplate) obj).body);
    }
}
