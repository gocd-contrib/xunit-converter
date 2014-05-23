package com.thoughtworks.xunit.exception;

import java.io.File;
import java.util.List;

public class NoFileToConvertException extends Exception {
    public NoFileToConvertException(File inputDirectory, List<String> testReportFilePattern) {
        super("No files matched given pattern: " + testReportFilePattern + " in input directory: " + inputDirectory.getAbsolutePath());
    }
}
