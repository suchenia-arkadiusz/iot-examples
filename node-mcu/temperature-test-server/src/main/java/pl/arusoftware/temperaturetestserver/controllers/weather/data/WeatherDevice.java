package pl.arusoftware.temperaturetestserver.controllers.weather.data;

import java.util.HashSet;
import java.util.Set;

public class WeatherDevice {
    private String id;
    private Set<WeatherSensor> sensors = new HashSet<>();

    public WeatherDevice() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<WeatherSensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<WeatherSensor> sensors) {
        this.sensors = sensors;
    }
}
