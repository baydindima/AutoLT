package com.egor69.lt.finder.simple;

import com.egor69.lt.util.Recursive;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SimpleTemplatesFinder {
    private static final double MATCHES_PERCENTAGE = 0.69;
    private static final int MINIMUM_TEMPLATE_DEPTH = 3;
    private List<PsiFile> psiFiles;

    public SimpleTemplatesFinder(List<PsiFile> psiFiles) {
        this.psiFiles = psiFiles;
    }

    public List<SimpleTemplate> analyze() {
        Map<IElementType, List<ASTNode>> nodeTypeMap = new HashMap<>();
        Recursive<BiPredicate<Integer, ASTNode>> possibleTemplatePredicate = new Recursive<>();
        possibleTemplatePredicate.function = (depth, astNode) -> {
            if (depth == MINIMUM_TEMPLATE_DEPTH) return true;
            for (ASTNode childNode : astNode.getChildren(null))
                if (possibleTemplatePredicate.function.test(depth + 1, childNode))
                    return true;
            return false;
        };
        Consumer<ASTNode> astNodeConsumer = astNode -> {
            IElementType elementType = astNode.getElementType();
            if (!nodeTypeMap.containsKey(elementType)) nodeTypeMap.put(elementType, new LinkedList<>());
            nodeTypeMap.get(elementType).add(astNode);
        };
        psiFiles.forEach(psiFile -> psiFile.accept(new PsiRecursiveElementWalkingVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                ASTNode astNode = element.getNode();
                if (possibleTemplatePredicate.function.test(0, astNode)) astNodeConsumer.accept(astNode);
            }
        }));

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

        Map<IElementType, Set<SimpleTemplate>> templatesMap = new HashMap<>();
        checkersMap.forEach((elementType, similarityCheckers) -> {
            Set<SimpleTemplate> templatesSet = new HashSet<>();
            int matchesBound = (int) (MATCHES_PERCENTAGE * similarityCheckers.size());
            similarityCheckers.forEach(similarityChecker -> {
                SimpleTemplate template = similarityChecker.getTemplate(matchesBound);
                if (template != null) templatesSet.add(template);
            });
            if (templatesSet.size() > 0) templatesMap.put(elementType, templatesSet);
        });

        List<SimpleTemplate> templatesList = new LinkedList<>();
        templatesMap.values().forEach(templatesList::addAll);
        templatesList = templatesList.parallelStream()
                .filter(st -> StringUtils.countMatches(st.getBody(), "_") < (int) (0.3 * st.getBody().length()))
                .collect(Collectors.toList());

        return templatesList;
    }
}
