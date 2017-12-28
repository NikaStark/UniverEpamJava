package model.impl;

import model.Observable;
import model.Observer;
import view.ConsolePrint;

/**
 * @author Alex Volodhai
 */
public class ConsoleWindObserver implements Observer {

    @Override
    public void onUpdate(Observable observable) {
        ConsolePrint.printLine(((WeatherStation) observable).getWeatherData().toStringWind());
    }

}
