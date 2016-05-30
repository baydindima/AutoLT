package ru.egor69.lt.ui;

import ru.egor69.lt.util.Parameters;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.util.Pair;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBPanel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class ParametersDialog extends DialogWrapper {
    private Parameters parameters;

    protected ParametersDialog(Project project, Parameters parameters) {
        super(project);
        this.parameters = parameters;
        setTitle("Parameters");
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel parametersPanel = new JBPanel<>(new GridBagLayout());
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.gridx = 0;
        labelConstraints.weightx = 0.;
        labelConstraints.anchor = GridBagConstraints.WEST;
        GridBagConstraints spinnerConstraints = new GridBagConstraints();
        spinnerConstraints.gridx = 1;
        spinnerConstraints.weightx = 1.;
        spinnerConstraints.fill = GridBagConstraints.HORIZONTAL;
        for (Parameters.Name name : Parameters.Name.values()) {
            JLabel jLabel = new JBLabel(Parameters.getText(name) + ":   ");
            parametersPanel.add(jLabel, labelConstraints);
            Pair<Integer, Integer> bounds = Parameters.getBounds(name);
            JSpinner jSpinner = new JSpinner(
                    new SpinnerNumberModel(
                            Parameters.getDefault(name),
                            bounds.first.intValue(),
                            bounds.second.intValue(),
                            1
                    )
            );
            jSpinner.addChangeListener(e -> parameters.setParameter(name, (Integer) jSpinner.getValue()));
            parametersPanel.add(jSpinner, spinnerConstraints);
        }
        JPanel centerPanel = new JBPanel<>(new BorderLayout());
        centerPanel.add(parametersPanel, BorderLayout.NORTH);
        return centerPanel;
    }

    public static Parameters showDialogAndGetParameters(Project project) {
        Parameters parameters = new Parameters();
        ParametersDialog parametersDialog = new ParametersDialog(project, parameters);
        parametersDialog.show();
        if (parametersDialog.getExitCode() == DialogWrapper.OK_EXIT_CODE) return parameters;
        return null;
    }
}
