package com.egor69.lt.finder.simple;

import com.egor69.lt.util.FilterSet;
import com.egor69.lt.util.ListOps;
import com.egor69.lt.util.Parameters;

import static com.egor69.lt.util.Parameters.Name.DEPTH_MINIMUM;
import static com.egor69.lt.util.Parameters.Name.MATCHES_PERCENTAGE_MINIMUM;
import static com.egor69.lt.util.Parameters.Name.MATCHES_MINIMUM;
import static com.egor69.lt.util.Parameters.Name.LENGTH_MINIMUM;
import static com.egor69.lt.util.Parameters.Name.NODES_MINIMUM;
import static com.egor69.lt.util.Parameters.Name.PLACEHOLDERS_LENGTH_PERCENTAGE_MAXIMUM;
import static com.egor69.lt.util.Parameters.Name.PLACEHOLDER_NODES_PERCENTAGE_MAXIMUM;
import static com.egor69.lt.util.ASTNodeOps.*;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTemplatesFinder {
    private List<PsiFile> psiFiles;
    private int depthMinimum;
    private double matchesPercentageMinimum;
    private int matchesMinimum;
    private int lengthMinimum;
    private int nodesMinimum;
    private double placeholdersLengthPercentageMaximum;
    private double placeholderNodesPercentageMaximum;

    public SimpleTemplatesFinder(List<PsiFile> psiFiles, Parameters parameters) {
        this.psiFiles = psiFiles;
        depthMinimum = parameters.getParameter(DEPTH_MINIMUM);
        matchesPercentageMinimum = 0.01 * parameters.getParameter(MATCHES_PERCENTAGE_MINIMUM);
        matchesMinimum = parameters.getParameter(MATCHES_MINIMUM);
        lengthMinimum = parameters.getParameter(LENGTH_MINIMUM);
        nodesMinimum = parameters.getParameter(NODES_MINIMUM);
        placeholdersLengthPercentageMaximum = 0.01 * parameters.getParameter(PLACEHOLDERS_LENGTH_PERCENTAGE_MAXIMUM);
        placeholderNodesPercentageMaximum = 0.01 * parameters.getParameter(PLACEHOLDER_NODES_PERCENTAGE_MAXIMUM);
    }

    public List<SimpleTemplate> analyze() {
        Stream.Builder<ASTNode> astNodeStreamBuilder = Stream.builder();
        psiFiles.forEach(psiFile -> psiFile.accept(new PsiRecursiveElementWalkingVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                astNodeStreamBuilder.accept(element.getNode());
            }
        }));

        FilterSet<ASTNode> astNodeFilterSet = new FilterSet<>();
        astNodeFilterSet.add(
                astNode -> astNode.getTextLength() >= lengthMinimum,
                astNode -> depth(astNode) >= depthMinimum,
                astNode -> nodes(astNode) >= nodesMinimum
        );
        Stream<ASTNode> astNodeStream = astNodeFilterSet.filter(astNodeStreamBuilder.build());

        Map<IElementType, List<ASTNode>> nodeTypeMap = new HashMap<>();
        Consumer<ASTNode> astNodeConsumer = astNode -> {
            IElementType elementType = astNode.getElementType();
            if (!nodeTypeMap.containsKey(elementType)) nodeTypeMap.put(elementType, new LinkedList<>());
            nodeTypeMap.get(elementType).add(astNode);
        };
        astNodeStream.forEach(astNodeConsumer);

        Map<IElementType, List<SimilarityChecker>> checkersMap = new HashMap<>();
        nodeTypeMap.forEach((elementType, astNodes) -> checkersMap.put(elementType,
                astNodes.parallelStream().map(astNode -> {
                    final SimilarityChecker[] sc = new SimilarityChecker[1];
                    ApplicationManager.getApplication().runReadAction(() -> {
                        SimilarityChecker similarityChecker = new SimilarityChecker(astNode);
                        similarityChecker.addAll(astNodes);
                        sc[0] = similarityChecker;
                    });
                    return sc[0];
                }).collect(Collectors.toList())));

        Set<SimpleTemplate> templatesSet = new HashSet<>();
        checkersMap.forEach((elementType, similarityCheckers) -> {
            int matchesBound = Math.max((int) (matchesPercentageMinimum * similarityCheckers.size()), matchesMinimum);
            similarityCheckers.forEach(similarityChecker -> {
                SimpleTemplate template = similarityChecker.getTemplate(matchesBound);
                if (template != null) templatesSet.add(template);
            });
        });

        FilterSet<SimpleTemplate> simpleTemplateFilterSet = new FilterSet<>();
        simpleTemplateFilterSet.add(
                simpleTemplate -> simpleTemplate.getBody().length() >= lengthMinimum,
                simpleTemplate -> StringUtils.countMatches(simpleTemplate.getBody(), "_")
                        <= (int) (placeholdersLengthPercentageMaximum * simpleTemplate.getBody().replaceAll("\\s+", "").length()),
                simpleTemplate -> simpleTemplate.nodes() >= nodesMinimum,
                simpleTemplate -> simpleTemplate.depth() >= depthMinimum,
                simpleTemplate -> simpleTemplate.placeholderNodes()
                        <= (int) (placeholderNodesPercentageMaximum * simpleTemplate.nodes())
        );

        List<SimpleTemplate> templatesList = simpleTemplateFilterSet.filter(templatesSet).collect(Collectors.toList());
        Collections.sort(templatesList, (o1, o2) -> Integer.compare(o2.getOccurrencesNumber(), o1.getOccurrencesNumber()));

        final List<SimpleTemplate> finalTemplatesList = templatesList;

        Set<Integer> toDeleteSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < templatesList.size(); ++i) {
            for (int j = 0; j < templatesList.size(); ++j) {
                if (i != j && templatesList.get(i).getBody().contains(templatesList.get(j).getBody())) {
                    toDeleteSet.add(j);
                }
            }
        }
        toDeleteSet.forEach(i -> finalTemplatesList.remove(i.intValue()));

        toDeleteSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < templatesList.size(); ++i) {
            for (int j = 0; j < templatesList.size(); ++j) {
                if (i != j && ListOps.hasSubSequence(templatesList.get(i).textNodes(), templatesList.get(j).textNodes())) {
                    toDeleteSet.add(j);
                }
            }
        }
        toDeleteSet.forEach(i -> finalTemplatesList.remove(i.intValue()));

        return templatesList;
    }
}
