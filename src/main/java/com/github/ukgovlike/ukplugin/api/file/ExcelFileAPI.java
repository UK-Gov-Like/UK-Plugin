package com.github.ukgovlike.ukplugin.api.file;

import java.io.File;
import java.io.IOException;

/**
 * @author Plugner
 * @see com.github.ukgovlike.ukplugin.api.ExcelAPI
 * @since 06/10/2020
 */
public class ExcelFileAPI {
    public static final String FILE_NAME = "superdatabase";
    public static final String EXTENSION = ".xlsx";
    public static final File file = new File(FILE_NAME + EXTENSION);

    /**
     * @author Plugner
     * @since 06/10/2020
     * @return If file exists
     */

    public static boolean existsFile() {
        return file.exists();
    }

    /**
     * @author Plugner
     * @since 06/10/2020
     * @return Result of file creation
     */

    public static boolean createFile()
            throws IOException {
        return file.createNewFile();
    }
}
