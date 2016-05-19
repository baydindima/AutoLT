package com.egor69.lt;

import com.egor69.lt.finder.Template;
import com.egor69.lt.finder.tree.TreeTemplatesFinder;
import com.egor69.lt.util.Parameters;
import com.egor69.lt.ui.ParametersDialog;
import com.egor69.lt.ui.ResultsDialog;
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
            psiFiles.addAll(Arrays.asList(psiDirectory.getFiles()));
            for (PsiDirectory subdirectory : psiDirectory.getSubdirectories())
                psiDirectoryConsumer.function.accept(subdirectory);
        };

        PsiManager psiManager = PsiManager.getInstance(project);
        Arrays.stream(sourceRoots)
                .map(psiManager::findDirectory)
                .forEach(psiDirectoryConsumer.function::accept);

        Parameters parameters = ParametersDialog.showDialogAndGetParameters(project);
        if (parameters != null) {
            List <Template> templates = new TreeTemplatesFinder(psiFiles, parameters).analyze();
            ResultsDialog.showDialog(project, templates);
        }
    }

}
