package controller;

import entities.StatisticsWords;
import entities.URLReader;

import java.net.URL;
import java.util.*;

/**
 * @author Alex Volochai
 */
public class URLController {

    URL baseUrl;
    URL urls[];
    Map<String, Map<Integer, List<String>>> wordsSortedByFrequency;
    List<StatisticsWords> statisticsWordses;

    public URLController(URL baseUrl) {
        this.baseUrl = baseUrl;
        this.urls = URLReader.parseURLPage(URLReader.getURLPage(baseUrl));
        this.wordsSortedByFrequency = new TreeMap<>();
        this.statisticsWordses = new ArrayList<>();
        for (URL url : urls) {
            System.out.println(url);
            StatisticsWords statisticsWords = new StatisticsWords(url);
            wordsSortedByFrequency.put(statisticsWords.getUrl().toString(), statisticsWords.getStatisticsByUrl());
            statisticsWordses.add(statisticsWords);
        }
    }

    public Map<String, Map<Integer, List<String>>> getWordsSortedByFrequency() {
        return wordsSortedByFrequency;
    }

    public Map<String, Integer> getUrlsByWords(String word) {
        Map<String, Integer> urlsContainWord = new TreeMap<>();
        statisticsWordses.stream().filter(statisticsPage ->
                statisticsPage.hasUrlsByWord(word)).forEach(statisticsPage ->
                urlsContainWord.put(
                        statisticsPage.getUrl().toString(),
                        statisticsPage.getWordsMap().get(word)
                )
        );
        return urlsContainWord;
    }

}
