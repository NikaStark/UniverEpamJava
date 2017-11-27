package model.impl;

import model.Observer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class WeatherStationTest {

    private WeatherData weatherData;

    private WeatherStation weatherStation;

    @Before
    public void setUp() throws Exception {
        weatherData = new WeatherDataBuilder()
                .setTemperature(1.0)
                .setPressure(1200)
                .setHumidity(55)
                .setWindSpeed(5)
                .setWindDegrees(180)
                .build();
        weatherStation = new WeatherStation(weatherData);
    }

    @After
    public void tearDown() throws Exception {
        weatherStation = null;
    }

    @Test
    public void testIsChangesBigWhenTrue() throws Exception {
        WeatherData changeWeatherData = new WeatherDataBuilder()
                .setTemperature(weatherData.getTemperature() + 2 * WeatherStation.DELTA_TEMPERATURE)
                .setPressure(weatherData.getPressure())
                .setHumidity(weatherData.getHumidity() - 2 * WeatherStation.DELTA_HUMIDITY)
                .setWindSpeed(weatherData.getWindSpeed())
                .setWindDegrees(weatherData.getWindDegrees())
                .build();

        assertTrue(weatherStation.isChangesBig(changeWeatherData));
    }

    @Test
    public void testIsChangesBigWhenFalse() throws Exception {
        WeatherData changeWeatherData = new WeatherDataBuilder()
                .setTemperature(weatherData.getTemperature())
                .setPressure(weatherData.getPressure() + WeatherStation.DELTA_PRESSURE / 2)
                .setHumidity(weatherData.getHumidity())
                .setWindSpeed(weatherData.getWindSpeed())
                .setWindDegrees(weatherData.getWindDegrees() - WeatherStation.DELTA_WIND_DEGREES / 2)
                .build();

        assertFalse(weatherStation.isChangesBig(changeWeatherData));
    }

    @Test
    public void testSetWeatherDataWhenChangeBig() throws Exception {
        WeatherStation weatherStationMock = spy(new WeatherStation(weatherData));
        WeatherData changeWeatherData = new WeatherDataBuilder()
                .setTemperature(weatherData.getTemperature() + 2 * WeatherStation.DELTA_TEMPERATURE)
                .setPressure(weatherData.getPressure())
                .setHumidity(weatherData.getHumidity() - 2 * WeatherStation.DELTA_HUMIDITY)
                .setWindSpeed(weatherData.getWindSpeed())
                .setWindDegrees(weatherData.getWindDegrees())
                .build();
        when(weatherStationMock.isChangesBig(changeWeatherData)).thenReturn(true);

        weatherStationMock.setWeatherData(changeWeatherData);

        verify(weatherStationMock).setWeatherData(changeWeatherData);
        verify(weatherStationMock, times(1)).notifyObservers();
        assertEquals(changeWeatherData, weatherStationMock.getWeatherData());
    }

    @Test
    public void testSetWeatherDataWhenChangeNotBig() throws Exception {
        WeatherStation weatherStationMock = spy( new WeatherStation(weatherData));
        when(weatherStationMock.isChangesBig(weatherData)).thenReturn(false);

        weatherStationMock.setWeatherData(weatherData);

        verify(weatherStationMock).setWeatherData(weatherData);
        verify(weatherStationMock, never()).notifyObservers();
    }

    @Test
    public void testOnUpdateWhenChangeBig() throws Exception {
        Observer mockObserver = mock(Observer.class);
        WeatherStation weatherStation = new WeatherStation(weatherData);
        weatherStation.addObserver(mockObserver);
        WeatherData changeWeatherData = new WeatherDataBuilder()
                .setTemperature(weatherData.getTemperature() + 2 * WeatherStation.DELTA_TEMPERATURE)
                .setPressure(weatherData.getPressure())
                .setHumidity(weatherData.getHumidity() - 2 * WeatherStation.DELTA_HUMIDITY)
                .setWindSpeed(weatherData.getWindSpeed())
                .setWindDegrees(weatherData.getWindDegrees())
                .build();

        weatherStation.setWeatherData(changeWeatherData);

        verify(mockObserver, times(1)).onUpdate(weatherStation);
    }

    @Test
    public void testOnUpdateWhenChangeNotBig() throws Exception {
        Observer mockObserver = mock(Observer.class);
        WeatherStation weatherStation = new WeatherStation(weatherData);
        weatherStation.addObserver(mockObserver);

        weatherStation.setWeatherData(weatherData);

        verify(mockObserver, never()).onUpdate(weatherStation);
    }

}