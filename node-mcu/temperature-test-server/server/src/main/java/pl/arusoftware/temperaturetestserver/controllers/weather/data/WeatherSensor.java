package pl.arusoftware.temperaturetestserver.controllers.weather.data;

public class WeatherSensor {
    private String id;
    private WeatherValue value;

    public WeatherSensor() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WeatherValue getValue() {
        return value;
    }

    public void setValue(WeatherValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "WeatherSensor{" +
                "id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}
