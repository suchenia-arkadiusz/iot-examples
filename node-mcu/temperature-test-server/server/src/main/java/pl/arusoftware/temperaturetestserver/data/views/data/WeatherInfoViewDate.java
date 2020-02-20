package pl.arusoftware.temperaturetestserver.data.views.data;

public class WeatherInfoViewDate {
    public interface ActualWeatherInfo {
        float getTemperature();
        float getAttitude();
        float getPressure();
        float getHumidity();
    }
}
