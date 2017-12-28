package model.impl;

/**
 * @author Alex Volochai
 */
public class WeatherDataBuilder {

    private double temperature;

    private long pressure;

    private long humidity;

    private long windSpeed;

    private long windDegrees;

    public WeatherDataBuilder() {
    }

    public WeatherDataBuilder setTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherDataBuilder setPressure(long pressure) {
        this.pressure = pressure;
        return this;
    }

    public WeatherDataBuilder setHumidity(long humidity) {
        this.humidity = humidity;
        return this;
    }

    public WeatherDataBuilder setWindSpeed(long windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public WeatherDataBuilder setWindDegrees(long windDegrees) {
        this.windDegrees = windDegrees;
        return this;
    }

    public WeatherData build() {
        return new WeatherData(temperature, pressure, humidity, windSpeed, windDegrees);
    }

}
