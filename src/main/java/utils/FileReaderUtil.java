package utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileReaderUtil {

    public static String readFile(String fileName) {
        try {
            InputStream inStream = new FileInputStream(fileName);
            return IOUtils.toString(inStream, StandardCharsets.UTF_8.name()).replace("\n ", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
