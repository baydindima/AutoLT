package com.egor69.lt.ui;

import com.egor69.lt.finder.Template;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class TemplatesDialog extends DialogWrapper {
    private List<Template> templates;

    protected TemplatesDialog(@Nullable Project project) {
        super(project);

        setTitle("Templates in " + project.getName());
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return null;
    }
}
