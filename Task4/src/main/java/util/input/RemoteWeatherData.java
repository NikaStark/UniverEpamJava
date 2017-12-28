package util.input;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Alex Volochai
 */
public class RemoteWeatherData {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static final String WEATHER_PARAM = "q=Kiev&mode=json&units=metric";

    public static final String APP_KEY = "appid=e3c1e17d058e1ae6ac053c9487b1c355";

    public static String getRemoteWeather() {
        int bufferSize = 256;
        char[] buffer = new char[bufferSize];
        StringBuilder result = new StringBuilder();
        try {
            URLConnection connection = new URL(BASE_URL + "?" + WEATHER_PARAM + "&" + APP_KEY).openConnection();
            try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
                for (int count; (count = reader.read(buffer)) != -1; result.append(buffer, 0, count)) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
