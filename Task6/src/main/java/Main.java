import controller.URLController;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://9gag.com/");
        URLController URLController = new URLController(url);

        Map<String, Map<Integer, List<String>>> result1 = URLController.getWordsSortedByFrequency();

        Map<String, Integer> urlMap = URLController.getUrlsByWords("fun");

        System.out.println("Word \"fun\" in urls:");
        System.out.print(urlMap);
    }


}
