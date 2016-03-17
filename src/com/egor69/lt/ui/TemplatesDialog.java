package com.egor69.lt.ui;

import com.egor69.lt.finder.simple.SimpleTemplate;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBScrollPane;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class TemplatesDialog extends DialogWrapper {
    private List<String> templatesList;

    protected TemplatesDialog(@Nullable Project project, List<SimpleTemplate> templatesList) {
        super(project);
        this.templatesList = templatesList.parallelStream()
                .map(st -> "<html>------"
                        + st.getOccurrencesNumber()
                        + "-----<br>"
                        + st.getBody().replaceAll("<", "&lt;").replaceAll("<", "&gt;").replaceAll(" ", "&nbsp;").replaceAll("\n", "<br>")
                        + "<br>-----------</html>")
                .collect(Collectors.toList());
        setTitle("Templates in " + project.getName());
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JList<String> jList = new JBList(templatesList);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane = new JBScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(500, 500));
        return jScrollPane;
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
    }

    public static void showDialog(Project project, List<SimpleTemplate> templatesList) {
        TemplatesDialog templatesDialog = new TemplatesDialog(project, templatesList);
        templatesDialog.show();
    }
}
