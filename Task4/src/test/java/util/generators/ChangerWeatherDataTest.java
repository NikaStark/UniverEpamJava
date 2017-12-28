package util.generators;

import model.impl.WeatherData;
import model.impl.WeatherDataBuilder;
import model.impl.WeatherStation;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class ChangerWeatherDataTest {

    @Test
    public void testGetChanges() throws Exception {
        WeatherData changeWeatherData;
        WeatherData weatherData = new WeatherDataBuilder()
                .setTemperature(1.0)
                .setPressure(1200)
                .setHumidity(55)
                .setWindSpeed(5)
                .setWindDegrees(180)
                .build();

        for (int i = 0; i < 10; i++) {
            changeWeatherData = ChangerWeatherData.getChanges(weatherData);
            assertFalse(Math.abs(weatherData.getTemperature() - changeWeatherData.getTemperature()) > 2 * WeatherStation.DELTA_TEMPERATURE ||
                    Math.abs(weatherData.getPressure() - changeWeatherData.getPressure()) > 2 * WeatherStation.DELTA_PRESSURE ||
                    Math.abs(weatherData.getHumidity() - changeWeatherData.getHumidity()) > 2 * WeatherStation.DELTA_HUMIDITY ||
                    Math.abs(weatherData.getWindSpeed() - changeWeatherData.getWindSpeed()) > 2 * WeatherStation.DELTA_WIND_SPEED ||
                    Math.abs(weatherData.getWindDegrees() - changeWeatherData.getWindDegrees()) > 2 * WeatherStation.DELTA_WIND_DEGREES);
        }
    }

}