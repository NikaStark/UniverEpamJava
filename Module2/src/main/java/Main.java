import controller.TextController;
import util.FileReader;

import java.io.File;

import java.nio.charset.StandardCharsets;

/**
 * @author Alex Volochai
 */
public class Main {

    private static final File srcFile = new File("Module2\\src\\main\\resources\\text.txt");

    public static void main(String[] args) {
        System.out.println(TextController.findMaxPalindrome(FileReader.readFile(srcFile, StandardCharsets.UTF_8)));
    }

}
