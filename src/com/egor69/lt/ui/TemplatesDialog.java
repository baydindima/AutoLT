package com.egor69.lt.ui;

import com.egor69.lt.finder.Template;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBTextField;
import com.intellij.ui.components.panels.HorizontalLayout;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TemplatesDialog extends DialogWrapper {
    private Project project;
    private List<Template> templates;
    private int currentIndex;
    private JButton prevButton;
    private JButton nextButton;
    private JLabel numberLabel;
    private JLabel occurrencesLabel;
    private JTextField abbreviationTextField;
    private JTextField descriptionTextField;
    private EditorTextField textField;

    public TemplatesDialog(Project project, List<Template> templates) {
        super(project);

        this.project = project;
        this.templates = templates;
        currentIndex = 0;

        setTitle("Templates in " + project.getName());
        init();

        refreshComponents();
    }

    private void refreshComponents() {
        prevButton.setEnabled(currentIndex != 0);
        nextButton.setEnabled(currentIndex != templates.size() - 1);
        numberLabel.setText(currentIndex + 1 + "/" + templates.size());
        occurrencesLabel.setText(templates.get(currentIndex).getOccurrences() + " occurrences");
        textField.setFileType(templates.get(currentIndex).getFileType());
        textField.setText(templates.get(currentIndex).getBody());
    }

    private void saveCurrentTemplate() {
        //TODO: save current template
        //TODO: remove added template from list
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel jPanel = new JBPanel<>(new BorderLayout());
        jPanel.setMinimumSize(new Dimension(750, 450));

        JPanel leftPanel = new JBPanel<>(new HorizontalLayout(0, SwingConstants.CENTER));
        prevButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("png/arrow_left.png")));
        prevButton.addActionListener(e -> {
            --currentIndex;
            refreshComponents();
        });
        leftPanel.add(prevButton);
        jPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = new JBPanel<>(new HorizontalLayout(0, SwingConstants.CENTER));
        nextButton = new JButton(new ImageIcon(getClass().getClassLoader().getResource("png/arrow_right.png")));
        nextButton.addActionListener(e -> {
            ++currentIndex;
            refreshComponents();
        });
        rightPanel.add(nextButton);
        jPanel.add(rightPanel, BorderLayout.EAST);

        JPanel centerPanel = new JBPanel<>(new BorderLayout());

        JPanel topPanel = new JBPanel<>(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.;
        JLabel headerLabel = new JBLabel("Template:");
        topPanel.add(headerLabel, constraints);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 1;
        constraints.gridy = 0;
        numberLabel = new JBLabel();
        topPanel.add(numberLabel, constraints);
        constraints.gridy = 1;
        occurrencesLabel = new JBLabel();
        topPanel.add(occurrencesLabel, constraints);
        centerPanel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JBPanel<>(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel abbreviationLabel = new JBLabel("Abbreviation: ");
        bottomPanel.add(abbreviationLabel, constraints);
        constraints.gridx = 1;
        abbreviationTextField = new JBTextField(10);
        bottomPanel.add(abbreviationTextField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel descriptionLabel = new JBLabel("Description: ");
        bottomPanel.add(descriptionLabel, constraints);
        constraints.gridx = 1;
        constraints.weightx = 1.;
        descriptionTextField = new JBTextField(30);
        bottomPanel.add(descriptionTextField, constraints);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0.;
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> saveCurrentTemplate());
        bottomPanel.add(addButton, constraints);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        textField = new EditorTextField(EditorFactory.getInstance().createDocument(""), project, FileTypes.UNKNOWN, false, false);
        centerPanel.add(textField, BorderLayout.CENTER);

        jPanel.add(centerPanel, BorderLayout.CENTER);

        return jPanel;
    }
}
