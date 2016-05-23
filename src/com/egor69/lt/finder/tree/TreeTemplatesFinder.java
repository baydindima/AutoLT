package com.egor69.lt.finder.tree;

import com.egor69.lt.finder.Template;
import com.egor69.lt.util.ListOps;
import com.egor69.lt.util.Parameters;
import com.egor69.lt.util.Recursive;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.egor69.lt.util.Parameters.Name.*;
import static com.egor69.lt.util.ASTNodeOps.*;

public class TreeTemplatesFinder {
    private List<PsiFile> psiFiles;
    private int lengthMinimum;
    private int lengthMaximum;
    private int nodesMinimum;
    private int depthMinimum;
    private int matchesMinimum;
    private int placeholdersMaximum;
    private int templatesToShow;

    public TreeTemplatesFinder(List<PsiFile> psiFiles, Parameters parameters) {
        this.psiFiles = psiFiles;
        lengthMinimum = parameters.getParameter(LENGTH_MINIMUM);
        lengthMaximum = parameters.getParameter(LENGTH_MAXIMUM);
        nodesMinimum = parameters.getParameter(NODES_MINIMUM);
        depthMinimum = parameters.getParameter(DEPTH_MINIMUM);
        matchesMinimum = parameters.getParameter(MATCHES_MINIMUM);
        placeholdersMaximum = parameters.getParameter(PLACEHOLDERS_MAXIMUM);
        templatesToShow = parameters.getParameter(TEMPLATES_TO_SHOW);
    }

    public List<Template> analyze() {
        SimilarityTree similarityTree = new SimilarityTree();

        Predicate<ASTNode> possibleTemplatePredicate = node -> node.getTextLength() >= lengthMinimum &&
                nodes(node) >= nodesMinimum &&
                depth(node) >= depthMinimum &&
                !(node.getText().contains("package") || node.getText().contains("import") || node.getText().contains("@"));

        Recursive<Consumer<ASTNode>> recursiveAddConsumer = new Recursive<>();
        recursiveAddConsumer.function = node -> {
            if (node.getTextLength() >= lengthMaximum) {
                for (ASTNode child : node.getChildren(null)) recursiveAddConsumer.function.accept(child);
            } else if (possibleTemplatePredicate.test(node)) {
                similarityTree.add(node);
                for (ASTNode child : node.getChildren(null)) recursiveAddConsumer.function.accept(child);
            }
        };

        final double[] i = {0};
        psiFiles.forEach(psiFile -> {
            for (PsiElement element : psiFile.getChildren()) recursiveAddConsumer.function.accept(element.getNode());
            if (++i[0] % 10 == 0) System.out.println("Add: " + i[0] / psiFiles.size());
        });

        Set<Template> templates = new HashSet<>();

        final FileType[] currentFileType = {null};

        Predicate<Template> templatePredicate = template -> template.getOccurrences() != Integer.MAX_VALUE &&
                template.getBody().length() >= lengthMinimum &&
                template.getTokens().size() >= nodesMinimum &&
                StringUtils.countMatches(template.getBody(), "$_$") <= placeholdersMaximum;

        Recursive<Consumer<ASTNode>> recursiveGetConsumer = new Recursive<>();
        recursiveGetConsumer.function = node -> {
            if (node.getTextLength() >= lengthMaximum) {
                for (ASTNode child : node.getChildren(null)) recursiveGetConsumer.function.accept(child);
            } else if (possibleTemplatePredicate.test(node)) {
                Template template = similarityTree.getTemplate(node, matchesMinimum);
                if (templatePredicate.test(template)) {
                    template.setFileType(currentFileType[0]);
                    templates.add(template);
                } else {
                    for (ASTNode child : node.getChildren(null)) recursiveGetConsumer.function.accept(child);
                }
            }
        };

        final double[] j = {0};
        psiFiles.forEach(psiFile -> {
            currentFileType[0] = psiFile.getFileType();
            for (PsiElement element : psiFile.getChildren()) recursiveGetConsumer.function.accept(element.getNode());
            if (++j[0] % 10 == 0) System.out.println("Get: " + j[0] / psiFiles.size());
        });

        List<Template> templatesList = new ArrayList<>(templates);
        Collections.sort(templatesList, (o1, o2) -> Integer.compare(o2.getOccurrences(), o1.getOccurrences()));

        Set<Integer> toDeleteSet = new TreeSet<>(Comparator.reverseOrder());
        for (int is = 0; is < templatesList.size(); ++is) {
            for (int iss = 0; iss < templatesList.size(); ++iss) {
                if (is != iss && ListOps.hasSubSequence(templatesList.get(is).getTokens(), templatesList.get(iss).getTokens())) {
                    toDeleteSet.add(iss);
                }
            }
        }
        toDeleteSet.forEach(idx -> templatesList.remove(idx.intValue()));

        if (templatesList.size() > templatesToShow) {
            //TODO: only <TEMPLATES_TO_SHOW> templates
        }

        return templatesList;
    }
}
