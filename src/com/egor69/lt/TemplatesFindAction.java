package com.egor69.lt;

import com.egor69.lt.finder.simple.SimpleTemplatesFinder;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TemplatesFindAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) return;

        Collection<VirtualFile> sourceFiles = FileBasedIndex.getInstance()
                .getContainingFiles(
                        FileTypeIndex.NAME,
                        JavaFileType.INSTANCE,
                        GlobalSearchScope.projectScope(project));

        PsiManager psiManager = PsiManager.getInstance(project);

        List<PsiFile> psiFiles = sourceFiles.stream().map(virtualFile ->
            psiManager.findFile(virtualFile)
        ).collect(Collectors.toList());

        new SimpleTemplatesFinder(psiFiles).run();
    }
}
