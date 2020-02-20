package pl.arusoftware.temperaturetestserver.controllers.weather.data.requests;

import pl.arusoftware.temperaturetestserver.controllers.weather.data.WeatherDevice;

public class WeatherInfoRequest {
    private WeatherDevice device;

    public WeatherInfoRequest() {}

    public WeatherDevice getDevice() {
        return device;
    }

    public void setDevice(WeatherDevice device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "WeatherInfoRequest{" +
                "device=" + device +
                '}';
    }
}
