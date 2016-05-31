package ru.egor69.lt.extensions;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.fileTypes.FileType;
import org.jetbrains.annotations.NotNull;
import ru.egor69.lt.extensions.ep.FileTypeTemplateFilter;

import java.util.Arrays;
import java.util.Collection;

public class JavaFileTypeTemplateFilter implements FileTypeTemplateFilter {
    @NotNull
    @Override
    public FileType fileType() {
        return JavaFileType.INSTANCE;
    }

    @NotNull
    @Override
    public Collection<String> keywordsNotAnalyze() {
        return Arrays.asList("package", "import", "@Test");
    }

    @NotNull
    @Override
    public Collection<String> keywordsNotShow() {
        return Arrays.asList("@Override", "/**");
    }
}
