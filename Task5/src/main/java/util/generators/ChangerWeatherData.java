package util.generators;

import model.impl.WeatherData;
import model.impl.WeatherDataBuilder;
import model.impl.WeatherStation;

/**
 * @author Alex Volochai
 */
public class ChangerWeatherData {

    /**
     * Create new weatherData on current weatherData
     *
     * @param weatherData current weatherData
     * @return new weatherData
     */
    public static WeatherData getChanges(WeatherData weatherData) {
        WeatherDataBuilder newWeatherData = new WeatherDataBuilder();
        newWeatherData.setTemperature(weatherData.getTemperature() +
                4 * Math.random() * WeatherStation.DELTA_TEMPERATURE - 2 * WeatherStation.DELTA_TEMPERATURE);
        newWeatherData.setPressure(weatherData.getPressure() +
                (long) (4 * Math.random() * WeatherStation.DELTA_PRESSURE - 2 * WeatherStation.DELTA_PRESSURE));
        newWeatherData.setHumidity(weatherData.getHumidity() +
                (long) (4 * Math.random() * WeatherStation.DELTA_HUMIDITY - 2 * WeatherStation.DELTA_HUMIDITY));
        newWeatherData.setWindSpeed(weatherData.getWindSpeed() +
                (long) (4 * Math.random() * WeatherStation.DELTA_WIND_SPEED - 2 * WeatherStation.DELTA_WIND_SPEED));
        newWeatherData.setWindDegrees(weatherData.getWindDegrees() +
                (long) (4 * Math.random() * WeatherStation.DELTA_WIND_DEGREES) - 2 * WeatherStation.DELTA_WIND_DEGREES);
        return newWeatherData.build();
    }

}
