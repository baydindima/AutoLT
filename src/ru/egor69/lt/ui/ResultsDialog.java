package ru.egor69.lt.ui;

import ru.egor69.lt.finder.Template;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBScrollPane;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsDialog extends DialogWrapper {
    private List<String> templatesList;

    protected ResultsDialog(Project project, List<Template> templatesList) {
        super(project);
        this.templatesList = templatesList.parallelStream()
                .map(st -> "<html>------"
                        + st.getOccurrences()
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

    public static void showDialog(Project project, List<Template> templatesList) {
        ResultsDialog resultsDialog = new ResultsDialog(project, templatesList);
        resultsDialog.show();
    }
}
