package pl.arusoftware.temperaturetestserver.controllers.weather.data;

public class WeatherValue {
    private float temperature;
    private float pressure;
    private float attitude;
    private float humidity;

    public WeatherValue() {}

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getAttitude() {
        return attitude;
    }

    public void setAttitude(float attitude) {
        this.attitude = attitude;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherValue{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", attitude=" + attitude +
                ", humidity=" + humidity +
                '}';
    }
}
