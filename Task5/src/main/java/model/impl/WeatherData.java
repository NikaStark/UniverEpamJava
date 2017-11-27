package model.impl;

/**
 * @author Alex Volochai
 */
public class WeatherData {

    private final double temperature;

    private final long pressure;

    private final long humidity;

    private final long windSpeed;

    private final long windDegrees;

    public WeatherData(double temperature, long pressure, long humidity, long windSpeed, long windDegrees) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
    }

    public double getTemperature() {
        return temperature;
    }

    public long getPressure() {
        return pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public long getWindSpeed() {
        return windSpeed;
    }

    public long getWindDegrees() {
        return windDegrees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (Double.compare(that.temperature, temperature) != 0) return false;
        if (pressure != that.pressure) return false;
        if (humidity != that.humidity) return false;
        if (windSpeed != that.windSpeed) return false;
        return windDegrees == that.windDegrees;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(temperature);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (pressure ^ (pressure >>> 32));
        result = 31 * result + (int) (humidity ^ (humidity >>> 32));
        result = 31 * result + (int) (windSpeed ^ (windSpeed >>> 32));
        result = 31 * result + (int) (windDegrees ^ (windDegrees >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", windDegrees=" + windDegrees +
                '}';
    }

    public String toStringWeather() {
        return "Weather{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }

    public String toStringWind() {
        return "Wind{" +
                "windSpeed=" + windSpeed +
                ", windDegrees=" + windDegrees +
                '}';
    }

}
