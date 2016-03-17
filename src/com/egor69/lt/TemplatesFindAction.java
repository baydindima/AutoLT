package com.egor69.lt;

import com.egor69.lt.finder.simple.SimpleTemplate;
import com.egor69.lt.finder.simple.SimpleTemplatesFinder;
import com.egor69.lt.ui.TemplatesDialog;
import com.egor69.lt.util.Recursive;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class TemplatesFindAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) return;

        ProjectRootManager projectRootManager = ProjectRootManager.getInstance(project);
        VirtualFile[] sourceRoots = projectRootManager.getContentSourceRoots();

        List<PsiFile> psiFiles = new LinkedList<>();

        Recursive<Consumer<PsiDirectory>> psiDirectoryConsumer = new Recursive<>();
        psiDirectoryConsumer.function = psiDirectory -> {
            for (PsiFile file : psiDirectory.getFiles()) psiFiles.add(file);
            for (PsiDirectory subdirectory : psiDirectory.getSubdirectories())
                psiDirectoryConsumer.function.accept(subdirectory);
        };

        PsiManager psiManager = PsiManager.getInstance(project);
        Arrays.stream(sourceRoots)
                .map(psiManager::findDirectory)
                .forEach(psiDirectoryConsumer.function::accept);

        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles).analyze();

        TemplatesDialog.showDialog(project, templatesList);
    }

}
