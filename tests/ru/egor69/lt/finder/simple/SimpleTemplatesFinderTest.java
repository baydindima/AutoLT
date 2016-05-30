package ru.egor69.lt.finder.simple;

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

    /*private List<String> getBodies(List<SimpleTemplate> simpleTemplates) {
        return simpleTemplates
                .parallelStream()
                .map(simpleTemplate -> simpleTemplate.getBody().replaceAll("\\s+", " "))
                .collect(Collectors.toList());
    }

    public void test1() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T1");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int _ = _; _ < _; ++_) { " +
                        "int sq = _ * _; " +
                        "System.out.println(sq); " +
                        "}"
        );
    }

    public void test1WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T1n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int _ = _; _ < _; ++_) { " +
                        "int sq = _ * _; " +
                        "System.out.println(sq); " +
                        "}"
        );
    }

    public void test2() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T2");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "while (System.currentTimeMillis() < _) { " +
                        "SimpleDateFormat _ = new SimpleDateFormat(_); " +
                        "System.out.println(_.format(System.currentTimeMillis())); " +
                        "}"
        );
    }

    public void test2WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T2n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "while (System.currentTimeMillis() < _) { " +
                        "SimpleDateFormat _ = new SimpleDateFormat(_); " +
                        "System.out.println(_.format(System.currentTimeMillis())); " +
                        "}"
        );
    }

    public void test3() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T3");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "try (Scanner _ = new Scanner(_)) { " +
                        "while (_.hasNext()) { " +
                        "_ " +
                        "} " +
                        "} catch (IOException e) { " +
                        "_ " +
                        "}"
        );
    }

    public void test4() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T4");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "Rectangle _ = new Rectangle(0, 0, _, _);"
        );
    }

    public void test4WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T4n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "Rectangle _ = new Rectangle(0, 0, _, _);"
        );
    }

    public void test5() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T5");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "new Thread(new Runnable() { " +
                        "@Override " +
                        "public void run() { " +
                        "f(_); " +
                        "} " +
                        "}).start();"
        );
    }

    public void test5WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T5n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "new Thread(new Runnable() { " +
                        "@Override " +
                        "public void run() { " +
                        "f(_); " +
                        "} " +
                        "}).start();"
        );
    }

    public void test6() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T6");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "_ = _ " +
                ".filter(_ -> _) " +
                        ".map(_ -> _) " +
                        ".filter(_ -> _) " +
                        ".collect(Collectors._());"
        );
    }

    public void test7() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T7");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "if (_) { " +
                        "_ " +
                        "} else { " +
                        "throw new _(_); " +
                        "}"
        );
    }

    public void test8() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T8");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "try { " +
                        "List<String> _ = Files.readAllLines(Paths.get(_)); " +
                        "_ " +
                        "} catch (IOException e) { " +
                        "_ " +
                        "}"
        );
    }

    public void test9() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T9");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int i = 0; i < _; ++i) { " +
                        "for (int j = 0; j < _; ++j) { " +
                        "_ " +
                        "_[i][j] = _; " +
                        "} " +
                        "}"
        );
    }

    public void test10() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T10");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "switch (_) { " +
                        "case N: " +
                        "_ " +
                        "break; " +
                        "case S: " +
                        "_ " +
                        "break; " +
                        "case W: " +
                        "_ " +
                        "break; " +
                        "case E: " +
                        "_ " +
                        "break; " +
                        "}"
        );
    }

    public void test11() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T11");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "Calendar _ = new Calendar.Builder().setLocale(Locale._).setDate(_, _, _).setTimeOfDay(_, _, _).build();"
        );
    }

    public void test11WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T11n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "Calendar _ = new Calendar.Builder().setLocale(Locale._).setDate(_, _, _).setTimeOfDay(_, _, _).build();"
        );
    }

    public void test12() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T12");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "int _ = (_) ? _ : 0;"
        );
    }

    public void test12WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T12n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "int _ = (_) ? _ : 0;"
        );
    }

    public void test13() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T13");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "do { " +
                        "Random random = new Random(); " +
                        "int _ = random.nextInt() * _; " +
                        "System.out.println(_); " +
                        "} while (_.test(_));"
        );
    }

    public void test13WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T13n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "do { " +
                        "Random random = new Random(); " +
                        "int _ = random.nextInt() * _; " +
                        "System.out.println(_); " +
                        "} while (_.test(_));"
        );
    }

    public void test14() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T14");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "BiFunction<Integer, Integer, Integer> _ = (i1, i2) -> (_) ? _ : _;"
        );
    }

    public void test14WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T14n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "BiFunction<Integer, Integer, Integer> _ = (i1, i2) -> (_) ? _ : _;"
        );
    }

    public void test15() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T15");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int i = 0; i < _; i++) _(i);"
        );
    }

    public void test15WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T15n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int i = 0; i < _; i++) _(i);"
        );
    }

    public void test16() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T16");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "double _ = _ / Math.sqrt(2.0 * Math.PI) * Math.max(_, Math.cos(_ + 1)) - (Math.sin(_) + 1.0) / Math.min(_ - Math.E, Math.abs(_));"
        );
    }

    public void test17() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T17");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "int _ = ((1 + 2 * (_ + 1)) * (35 * _ - 18 * (2 * _ + 690) - 49) + 24) * 69 + 34;"
        );
    }

    public void test17WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T17n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "int _ = ((1 + 2 * (_ + 1)) * (35 * _ - 18 * (2 * _ + 690) - 49) + 24) * 69 + 34;"
        );
    }

    public void test18() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T18");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(2, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "static { " +
                        "_ = new HashMap<>(); " +
                        "_.put(\"default\", 0); " +
                        "}",
                "static Map<String, Integer> _;"
        );
    }

    public void test18WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T18n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(2, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "static { " +
                        "_ = new HashMap<>(); " +
                        "_.put(\"default\", 0); " +
                        "}",
                "static Map<String, Integer> _;"
        );
    }

    public void test19() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T19");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (Iterator<String> iterator = _.iterator(); iterator.hasNext(); ) { " +
                        "String s = iterator.next(); " +
                        "_ " +
                        "}"
        );
    }

    public void test20() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T20");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (String s : _) { " +
                        "if (!s.isEmpty()) { " +
                        "_ " +
                        "} " +
                        "}"
        );
    }

    public void test21() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T21");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "_.forEach(s -> { " +
                        "if (!s.isEmpty()) { " +
                        "_ " +
                        "} " +
                        "});"
        );
    }

    public void test22() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T22");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(2, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "_.stream().filter(_ -> !_.isEmpty()).forEach(StringOps::_);",
                "static void _(String s) {}"
        );
    }

    public void test22WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T22n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(2, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "_.stream().filter(_ -> !_.isEmpty()).forEach(StringOps::_);",
                "static void _(String s) {}"
        );
    }

    public void test23() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T23");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "Map<String, _> _ = new HashMap<>(69, .69f);"
        );
    }

    public void test23WithNoise() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T23n");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "Map<String, _> _ = new HashMap<>(69, .69f);"
        );
    }

    public void testMultiple1() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T1", "T15");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(2, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int _ = _; _ < _; ++_) { " +
                        "int sq = _ * _; " +
                        "System.out.println(sq); " +
                        "}",
                "for (int i = 0; i < _; i++) _(i);"
        );
    }

    public void testMultiple2() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T12", "T17");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(2, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "int _ = (_) ? _ : 0;",
                "int _ = ((1 + 2 * (_ + 1)) * (35 * _ - 18 * (2 * _ + 690) - 49) + 24) * 69 + 34;"
        );
    }

    public void testMultiple3() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("T2", "T4", "T5", "T11", "T13", "T23");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(6, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "while (System.currentTimeMillis() < _) { " +
                        "SimpleDateFormat _ = new SimpleDateFormat(_); " +
                        "System.out.println(_.format(System.currentTimeMillis())); " +
                        "}",
                "Rectangle _ = new Rectangle(0, 0, _, _);",
                "new Thread(new Runnable() { " +
                        "@Override " +
                        "public void run() { " +
                        "f(_); " +
                        "} " +
                        "}).start();",
                "Calendar _ = new Calendar.Builder().setLocale(Locale._).setDate(_, _, _).setTimeOfDay(_, _, _).build();",
                "do { " +
                        "Random random = new Random(); " +
                        "int _ = random.nextInt() * _; " +
                        "System.out.println(_); " +
                        "} while (_.test(_));",
                "Map<String, _> _ = new HashMap<>(69, .69f);"
        );
    }

    public void testSingleTemplateMultipleFiles() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("Tstmf1", "Tstmf2", "Tstmf3");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(1, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "do { " +
                        "Random random = new Random(); " +
                        "int _ = random.nextInt() * _; " +
                        "System.out.println(_); " +
                        "} while (_.test(_));"
        );
    }

    public void testMultipleTemplatesSingleFile() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("Tmtsf");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(6, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "while (System.currentTimeMillis() < _) { " +
                        "SimpleDateFormat _ = new SimpleDateFormat(_); " +
                        "System.out.println(_.format(System.currentTimeMillis())); " +
                        "}",
                "Rectangle _ = new Rectangle(0, 0, _, _);",
                "new Thread(new Runnable() { " +
                        "@Override " +
                        "public void run() { " +
                        "f(_); " +
                        "} " +
                        "}).start();",
                "for (int i = 0; i < _; i++) _(i);",
                "int _ = ((1 + 2 * (_ + 1)) * (35 * _ - 18 * (2 * _ + 690) - 49) + 24) * 69 + 34;",
                "Map<String, _> _ = new HashMap<>(69, .69f);"
        );
    }

    public void testMultipleTemplatesMultipleFiles() throws Exception {
        List<PsiFile> psiFiles = getPsiFiles("Tmtmf1", "Tmtmf2", "Tmtmf3");
        Parameters parameters = new Parameters();
        List<SimpleTemplate> templatesList = new SimpleTemplatesFinder(psiFiles, parameters).analyze();
        assertEquals(4, templatesList.size());
        List<String> bodiesList = getBodies(templatesList);
        assertContainsElements(
                bodiesList,
                "for (int _ = _; _ < _; ++_) { " +
                        "int sq = _ * _; " +
                        "System.out.println(sq); " +
                        "}",
                "Calendar _ = new Calendar.Builder().setLocale(Locale._).setDate(_, _, _).setTimeOfDay(_, _, _).build();",
                "int _ = (_) ? _ : 0;",
                "do { " +
                        "Random random = new Random(); " +
                        "int _ = random.nextInt() * _; " +
                        "System.out.println(_); " +
                        "} while (_.test(_));"
        );
    }*/
}