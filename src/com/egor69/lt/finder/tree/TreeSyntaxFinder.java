package com.egor69.lt.finder.tree;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.tree.IElementType;

import java.util.*;

public class TreeSyntaxFinder {
    private List<PsiFile> psiFiles;

    public TreeSyntaxFinder(List<PsiFile> psiFiles) {
        this.psiFiles = psiFiles;
    }

    public void analyze() {
        Map<IElementType, CommonElementsTree> typeElementsTreeMap = new HashMap<>();

        final double[] i = {0};
        psiFiles.forEach(psiFile -> {
            psiFile.acceptChildren(new PsiRecursiveElementVisitor() {
                @Override
                public void visitElement(PsiElement element) {
                    super.visitElement(element);
                    if (element.getTextLength() > 10) {
                        ASTNode node = element.getNode();
                        if (!typeElementsTreeMap.containsKey(node.getElementType())) {
                            typeElementsTreeMap.put(node.getElementType(), new CommonElementsTree());
                        }
                        typeElementsTreeMap.get(node.getElementType()).add(node);
                    }
                }
            });
            if (++i[0] % 10 == 0) System.out.println(i[0] / psiFiles.size());
        });

        i[0] = 0;
        Set<String> templates = new HashSet<>();
        typeElementsTreeMap.forEach((type, tree) -> {
            templates.add(tree.get());
            if (++i[0] % 10 == 0) System.out.println(i[0] / typeElementsTreeMap.size());
        });

        int k = 0;
    }
}
