package com.github.ukgovlike.ukplugin.api.file;

import java.io.File;
import java.io.IOException;

public class ExcelFileAPI {
    public static final String FILE_NAME = "superdatabase";
    public static final String EXTENSION = ".xlsx";
    public static final File file = new File(FILE_NAME + EXTENSION);

    public static boolean existsFile() {
        return file.exists();
    }
    public static boolean createFile()
            throws IOException {
        return file.createNewFile();
    }
}
