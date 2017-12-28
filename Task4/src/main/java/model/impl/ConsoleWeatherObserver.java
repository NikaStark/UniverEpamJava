package model.impl;

import model.Observable;
import model.Observer;
import view.ConsolePrint;

/**
 * @author Alex Volochai
 */
public class ConsoleWeatherObserver implements Observer {

    @Override
    public void onUpdate(Observable observable) {
        ConsolePrint.printLine(((WeatherStation) observable).getWeatherData().toStringWeather());
    }

}
