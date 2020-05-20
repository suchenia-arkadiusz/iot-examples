package pl.arusoftware.temperaturetestserver.data.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class WeatherSensorValue {
    @NotNull
    @Column(nullable = false)
    private Date date;
    private float temperature;
    private float humidity;
    private float pressure;
    private float attitude;

    public WeatherSensorValue() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherSensorValue that = (WeatherSensorValue) o;
        return Float.compare(that.temperature, temperature) == 0 &&
                Float.compare(that.humidity, humidity) == 0 &&
                Float.compare(that.pressure, pressure) == 0 &&
                Float.compare(that.attitude, attitude) == 0 &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, temperature, humidity, pressure, attitude);
    }

    public Date getDate() {
        return date;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getAttitude() {
        return attitude;
    }

    @Override
    public String toString() {
        return "WeatherSensorValue{" +
                "date=" + date +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", attitude=" + attitude +
                '}';
    }

    private WeatherSensorValue(WeatherSensorValueBuilder builder) {
        this.date = builder.date;
        this.temperature = builder.temperature;
        this.humidity = builder.humidity;
        this.pressure = builder.pressure;
        this.attitude = builder.attitude;
    }

    public static class WeatherSensorValueBuilder {
        private Date date;
        private float temperature;
        private float humidity;
        private float pressure;
        private float attitude;

        public WeatherSensorValueBuilder() {
            this.date = new Date();
        }

        public WeatherSensorValueBuilder withTemperature(float temperature) {
            this.temperature = temperature;
            return this;
        }

        public WeatherSensorValueBuilder withHumodoty(float humidity) {
            this.humidity = humidity;
            return this;
        }

        public WeatherSensorValueBuilder withPressure(float pressure) {
            this.pressure = pressure;
            return this;
        }

        public WeatherSensorValueBuilder withAttitude(float attitude) {
            this.attitude = attitude;
            return this;
        }

        public WeatherSensorValue build() {
            return new WeatherSensorValue(this);
        }
    }
}
