package model.impl;

import model.Observable;
import model.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class WeatherStation implements Observable {

    public static final double DELTA_TEMPERATURE = 0.5;
    public static final long DELTA_PRESSURE = 100;
    public static final long DELTA_HUMIDITY = 5;
    public static final long DELTA_WIND_SPEED = 1;
    public static final long DELTA_WIND_DEGREES = 10;

    private List<Observer> observers = new ArrayList<>();

    private WeatherData weatherData;

    public WeatherStation(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        if (isChangesBig(weatherData)) {
            this.weatherData = weatherData;
            notifyObservers();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.onUpdate(this);
        }
    }

    public boolean isChangesBig(WeatherData newWeatherData) {
        return Math.abs(weatherData.getTemperature() - newWeatherData.getTemperature()) > DELTA_TEMPERATURE ||
               Math.abs(weatherData.getPressure() - newWeatherData.getPressure()) > DELTA_PRESSURE ||
               Math.abs(weatherData.getHumidity() - newWeatherData.getHumidity()) > DELTA_HUMIDITY ||
               Math.abs(weatherData.getWindSpeed() - newWeatherData.getWindSpeed()) > DELTA_WIND_SPEED ||
               Math.abs(weatherData.getWindDegrees() - newWeatherData.getWindDegrees()) > DELTA_WIND_DEGREES;
    }

}
