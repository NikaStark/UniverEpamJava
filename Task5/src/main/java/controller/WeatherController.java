package controller;

import model.impl.WeatherData;
import model.impl.WeatherStation;
import util.generators.ChangerWeatherData;

/**
 * @author Alex Volochai
 */
public class WeatherController implements Runnable {

    private WeatherStation weatherStation;

    private WeatherData remoteWeatherData;

    private Thread consoleThreadObserver;

    public WeatherController(WeatherStation weatherStation, WeatherData remoteWeatherData, Thread consoleThreadObserver) {
        this.weatherStation = weatherStation;
        this.remoteWeatherData = remoteWeatherData;
        this.consoleThreadObserver = consoleThreadObserver;
    }

    @Override
    public void run() {
        do {
            weatherStation.setWeatherData(ChangerWeatherData.getChanges(remoteWeatherData));
            System.out.println(" 2.5 seconds later");
            try {
                Thread.sleep(2_500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (consoleThreadObserver.isAlive());
    }

}
