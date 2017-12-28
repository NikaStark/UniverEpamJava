import controller.ConsoleController;
import controller.WeatherController;
import model.impl.ConsoleWeatherObserver;
import model.impl.ConsoleWindObserver;
import model.impl.WeatherData;
import model.impl.WeatherStation;
import util.input.RemoteWeatherData;
import util.parsers.JSONWeatherDataParser;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) throws Exception {

        WeatherData remoteWeatherData = JSONWeatherDataParser.parseWeatherData(RemoteWeatherData.getRemoteWeather());
        WeatherStation weatherStation = new WeatherStation(remoteWeatherData);
        weatherStation.addObserver(new ConsoleWeatherObserver());
        weatherStation.addObserver(new ConsoleWindObserver());

        Thread consoleThreadObserver = new Thread(new ConsoleController());
        consoleThreadObserver.start();

        Thread consoleOutputThread = new Thread(new WeatherController(weatherStation, remoteWeatherData, consoleThreadObserver));
        consoleOutputThread.start();

    }

}
