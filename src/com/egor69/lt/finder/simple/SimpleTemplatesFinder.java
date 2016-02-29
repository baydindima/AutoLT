package com.egor69.lt.finder.simple;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SimpleTemplatesFinder {
    private static double MATCHES_PERCENTAGE = 0.69;
    private List<PsiFile> psiFiles;

    public SimpleTemplatesFinder(List<PsiFile> psiFiles) {
        this.psiFiles = psiFiles;
    }

    public void run() {
        Map<IElementType, List<ASTNode>> nodeTypeMap = new HashMap<>();
        Consumer<PsiElement> psiElementConsumer = element -> {
            ASTNode astNode = element.getNode();
            IElementType elementType = astNode.getElementType();
            if (!nodeTypeMap.containsKey(elementType)) nodeTypeMap.put(elementType, new LinkedList<>());
            nodeTypeMap.get(elementType).add(astNode);
        };
        psiFiles.forEach(psiFile -> psiFile.accept(new PsiRecursiveElementWalkingVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                psiElementConsumer.accept(element);
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

        Map<IElementType, Set<String>> templatesMap = new HashMap<>();
        checkersMap.forEach((elementType, similarityCheckers) -> {
            templatesMap.put(elementType, new HashSet<>());
            int matchesBound = (int) (MATCHES_PERCENTAGE * similarityCheckers.size());
            similarityCheckers.forEach(similarityChecker -> {
                String template = similarityChecker.getTemplate(matchesBound);
                if (template != null) templatesMap.get(elementType).add(template);
            });
        });

        templatesMap.forEach((elementType, templatesSet) -> {
            System.out.print("\n" + elementType.toString() + ":\n");
            templatesSet.forEach(template -> System.out.print("-------\n" + template + "\n"));
        });
    }
}
