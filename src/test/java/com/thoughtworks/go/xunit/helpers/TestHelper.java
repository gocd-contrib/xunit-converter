package com.thoughtworks.go.xunit.helpers;

import java.io.File;

public class TestHelper {
    public static File resource(String filePath) {
        return new File(TestHelper.class.getResource(filePath).getFile());
    }
}
