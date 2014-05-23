package com.tw.xunit.converter;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("usage: java -jar xunit-converter-1.0.one-jar.jar <converter-id> <input-directory> <output-directory>");
            System.out.println("sample: java -jar xunit-converter-1.0.one-jar.jar jsunit /tmp/input /tmp/output");
            System.exit(0);
        }

        String converterId = args[0];
        String inputDirectoryPath = args[1];
        String outputDirectoryPath = args[2];

        System.out.println("starting conversion...");

        new TestReportConverter().convert(converterId, new File(inputDirectoryPath), new File(outputDirectoryPath));

        System.out.println("done.");
    }
}