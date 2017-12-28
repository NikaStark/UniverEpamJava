package entities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alex Volochai
 */
public class URLReader {

    public static final int COUNT_URLS_FIND = 15;

    public static String getURLPage(URL url) {
        int bufferSize = 256;
        char[] buffer = new char[bufferSize];
        StringBuilder result = new StringBuilder();
        try {
            URLConnection connection = url.openConnection();
            try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
                for (int count; (count = reader.read(buffer)) != -1; result.append(buffer, 0, count)) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static URL[] parseURLPage(String htmlPage) {
        URL[] urls = new URL[COUNT_URLS_FIND];
        int i = 0;
        Document document = Jsoup.parse(htmlPage);
        Elements anchors = document.body().getElementsByTag("a");
        for (Element anchor : anchors) {
            String probableURL = anchor.attr("href");
            if (validateURL(probableURL)) {
                try {
                    urls[i++] = new URL(probableURL);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            if (i == COUNT_URLS_FIND) break;
        }
        return urls;
    }

    public static boolean validateURL(String url) {
        Pattern pattern = Pattern.compile("http(s?)?://(-\\.)?([^\\s/?\\.#-]+\\.?)+(/[^\\s]*)?$");
        Matcher matcher = pattern.matcher(url);
        return matcher.find();
    }

}
