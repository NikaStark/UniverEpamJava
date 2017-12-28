package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Class for reading text from file
 *
 * @author Alex Volochai
 */
public class FileReader {

    public static String readFile(File file, Charset charsetName) {
        int bufferSize = 256;
        char[] buffer = new char[bufferSize];
        StringBuilder result = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), charsetName)) {
            for (int count; (count = reader.read(buffer)) != -1; result.append(buffer, 0, count)) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
