package model.impl;

import model.Observable;
import model.Observer;
import view.ConsolePrint;

public class ConsoleWindObserver implements Observer {

    @Override
    public void onUpdate(Observable observable) {
        ConsolePrint.printLine(((WeatherStation) observable).getWeatherData().toStringWind());
    }

}
