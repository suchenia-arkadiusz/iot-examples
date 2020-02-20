package pl.arusoftware.temperaturetestserver.controllers.weather.data.responses;

public class WeatherInfoResponse {
    private float temperature;
    private float pressure;
    private float altitude;
    private float humidity;

    public WeatherInfoResponse() {}

    public WeatherInfoResponse(float temperature, float pressure, float altitude, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.altitude = altitude;
        this.humidity = humidity;
    }

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

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherInfoResponse{" +
                "temperature='" + temperature + '\'' +
                ", pressure='" + pressure + '\'' +
                ", altitude='" + altitude + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
