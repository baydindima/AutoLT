package com.egor69.lt.finder.simple;

import com.egor69.lt.util.Parameters;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleTemplatesFinderTest extends LightCodeInsightFixtureTestCase {

    @Override
    protected String getTestDataPath() {
        return "testData";
    }

    private List<PsiFile> getPsiFiles(String ... names) throws Exception {
        List<PsiFile> psiFiles = new LinkedList<>();
        for (String name : names) {
            String testPath = getTestDataPath() + "/" + name + ".java";
            List<String> lines = Files.readAllLines(Paths.get(testPath));
            String text = lines.stream().collect(Collectors.joining("\n"));
            PsiFile psiFile = createLightFile(JavaFileType.INSTANCE, text);
            psiFiles.add(psiFile);
        }
        return psiFiles;
    }

    public void test1() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T1");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test2() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T2");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test3() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T3");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test4() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T4");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test5() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T5");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test6() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T6");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test7() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T7");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test8() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T8");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test9() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T9");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test10() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T10");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test11() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T11");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test12() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T12");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test13() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T13");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test14() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T14");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test15() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T15");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test16() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T16");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test17() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T17");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test18() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T18");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test19() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T19");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test20() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T20");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test21() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T21");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test22() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T22");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }

    public void test23() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T23");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertNotEmpty(templatesList);
    }
}