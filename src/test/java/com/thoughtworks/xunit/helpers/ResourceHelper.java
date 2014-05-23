package com.thoughtworks.xunit.helpers;

import java.io.File;

public class ResourceHelper {
    public static File resource(String filePath) {
        return new File(ResourceHelper.class.getResource(filePath).getFile());
    }
}
