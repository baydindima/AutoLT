package ru.egor69.lt.extensions.ep;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.fileTypes.FileType;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface FileTypeTemplateFilter {
    ExtensionPointName<FileTypeTemplateFilter> EP_NAME = ExtensionPointName.create("ru.egor69.lt.fileTypeTemplateFilter");

    @NotNull FileType fileType();

    @NotNull Collection<String> keywordsNotAnalyze();

    @NotNull Collection<String> keywordsNotShow();
}
