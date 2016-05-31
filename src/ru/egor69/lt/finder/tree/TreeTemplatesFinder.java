package ru.egor69.lt.finder.tree;

import static ru.egor69.lt.util.Parameters.Name.*;
import static ru.egor69.lt.util.ASTNodeOps.*;

import ru.egor69.lt.extensions.ep.FileTypeTemplateFilter;
import ru.egor69.lt.finder.Template;
import ru.egor69.lt.util.ListOps;
import ru.egor69.lt.util.Parameters;
import ru.egor69.lt.util.Recursive;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.apache.commons.lang.StringUtils;
import ru.egor69.lt.util.StringOps;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        FileTypeTemplateFilter[] filters =  FileTypeTemplateFilter.EP_NAME.getExtensions();
        Predicate<String> defaultPredicate = s -> false;
        Map<FileType, Predicate<String>> notAnalyzePredicates = new HashMap<>();
        Map<FileType, Predicate<String>> notShowPredicates = new HashMap<>();
        for (FileTypeTemplateFilter filter :
                filters) {
            notAnalyzePredicates.put(filter.fileType(), StringOps.containsAnyPredicate(filter.keywordsNotAnalyze()));
            notShowPredicates.put(filter.fileType(), StringOps.containsAnyPredicate(filter.keywordsNotShow()));
        }

        SimilarityTree similarityTree = new SimilarityTree();

        final FileType[] currentFileType = {null};

        Predicate<ASTNode> possibleTemplatePredicate = node ->
                node.getTextLength() >= lengthMinimum &&
                nodes(node) >= nodesMinimum &&
                depth(node) >= depthMinimum;

        Recursive<Consumer<ASTNode>> recursiveAddConsumer = new Recursive<>();
        recursiveAddConsumer.function = node -> {
            if (node.getTextLength() >= lengthMaximum) {
                for (ASTNode child : node.getChildren(null)) recursiveAddConsumer.function.accept(child);
            } else if (possibleTemplatePredicate.test(node) &&
                    !notAnalyzePredicates.getOrDefault(currentFileType[0], defaultPredicate).test(node.getText())) {
                similarityTree.add(node);
                for (ASTNode child : node.getChildren(null)) recursiveAddConsumer.function.accept(child);
            }
        };

        final double[] i = {0};
        psiFiles.forEach(psiFile -> {
            currentFileType[0] = psiFile.getFileType();
            for (PsiElement element : psiFile.getChildren()) recursiveAddConsumer.function.accept(element.getNode());
            if (++i[0] % 10 == 0) System.out.println("Add: " + i[0] / psiFiles.size());
        });

        Set<Template> templates = new HashSet<>();

        Predicate<Template> templatePredicate = template ->
                template.getOccurrences() != Integer.MAX_VALUE &&
                template.getBody().length() >= lengthMinimum &&
                template.getTokens().size() >= nodesMinimum &&
                StringUtils.countMatches(template.getBody(), "#_#") <= placeholdersMaximum;

        Recursive<Consumer<ASTNode>> recursiveGetConsumer = new Recursive<>();
        recursiveGetConsumer.function = node -> {
            if (node.getTextLength() >= lengthMaximum) {
                for (ASTNode child : node.getChildren(null)) recursiveGetConsumer.function.accept(child);
            } else if (possibleTemplatePredicate.test(node) &&
                    !notAnalyzePredicates.getOrDefault(currentFileType[0], defaultPredicate).test(node.getText())) {
                Template template = similarityTree.getTemplate(node, matchesMinimum);
                if (templatePredicate.test(template) &&
                        !notShowPredicates.getOrDefault(currentFileType[0], defaultPredicate).test(template.getBody())) {
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
        Collections.sort(templatesList, (o1, o2) -> Integer.compare(o2.getBody().length(), o1.getBody().length()));

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
