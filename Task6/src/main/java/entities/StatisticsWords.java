package entities;

import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alex Volochai
 */
public class StatisticsWords {

    URL url;
    String urlData;
    Map<Integer, List<String>> sortedUrlsByWords;
    Map<String, Integer> statistics;

    public StatisticsWords(URL url) {
        this.url = url;
        urlData = URLReader.getURLPage(this.url);
        sortedUrlsByWords = getStatisticsByUrl();
        this.statistics = getWordsMap();
    }

    public URL getUrl() {
        return url;
    }

    public Map<String, Integer> getWordsMap() {
        Map<String, Integer> statistics = new TreeMap<>();
        String plain = this.urlData.replaceAll("<[^>]*>", " ");
        Pattern pattern = Pattern.compile("(?<!\\S)\\p{Alpha}+(?!\\S)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(plain);
        String s;
        while (matcher.find()) {
            s = matcher.group();
            Integer freq = statistics.get(s);
            statistics.put(s, (freq == null) ? 1 : freq + 1);
        }
        return statistics;
    }

    public Map<Integer, List<String>> getStatisticsByUrl() {
        statistics = getWordsMap();
        Map<Integer, List<String>> treeMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : this.statistics.entrySet()) {
            Integer freq = entry.getValue();
            if (treeMap.containsKey(freq)) {
                treeMap.get(freq).add(entry.getKey());
            } else {
                LinkedList<String> ll = new LinkedList<>();
                ll.add(entry.getKey());
                treeMap.put(entry.getValue(), ll);
            }
        }

        return treeMap;
    }

    public boolean hasUrlsByWord(String word) {
        return statistics.containsKey(word);
    }
}
