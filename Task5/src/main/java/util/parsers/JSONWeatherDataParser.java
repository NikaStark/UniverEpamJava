package util.parsers;

import model.impl.WeatherData;
import model.impl.WeatherDataBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Alex Volochai
 */
public class JSONWeatherDataParser {

    public static final String MAIN_KEYWORD = "main";

    public static final String TEMPERATURE_KEYWORD = "temp";

    public static final String PRESSURE_KEYWORD = "pressure";

    public static final String HUMIDITY_KEYWORD = "humidity";

    public static final String WIND_KEYWORD = "wind";

    public static final String WIND_SPEED_KEYWORD = "speed";

    public static final String WIND_DEGREES_KEYWORD = "deg";

    public static WeatherData parseWeatherData(String jsonResponse) {
        WeatherDataBuilder weatherData = new WeatherDataBuilder();
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonResponse);
            weatherData.setTemperature((double) (((JSONObject) jsonObject.get(MAIN_KEYWORD)).get(TEMPERATURE_KEYWORD)) + 0.0);
            weatherData.setPressure((long) (((JSONObject) jsonObject.get(MAIN_KEYWORD)).get(PRESSURE_KEYWORD)));
            weatherData.setHumidity((long) (((JSONObject) jsonObject.get(MAIN_KEYWORD)).get(HUMIDITY_KEYWORD)));
            weatherData.setWindSpeed((long) (((JSONObject) jsonObject.get(WIND_KEYWORD)).get(WIND_SPEED_KEYWORD)));
            weatherData.setWindDegrees((long) (((JSONObject) jsonObject.get(WIND_KEYWORD)).get(WIND_DEGREES_KEYWORD)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return weatherData.build();
    }


}
