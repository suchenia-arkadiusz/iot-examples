package pl.arusoftware.temperaturetestserver.data.entities;

import pl.arusoftware.temperaturetestserver.data.valueobjects.WeatherSensorValue;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Sensor {
    @Id
    private String id;
    private String displayName;
    @ManyToOne
    @JoinColumn(name = "DEVICE_ID", nullable = false)
    private Device device;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "SENSOR_VALUE")
    private Set<WeatherSensorValue> values = new HashSet<>();

    public Sensor() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return id.equals(sensor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Device getDevice() {
        return device;
    }

    public Set<WeatherSensorValue> getValues() {
        return values;
    }

    public void addValue(WeatherSensorValue value) {
        values.add(value);
    }

    private Sensor(SensorBuilder builder) {
        this.id = builder.id;
        this.displayName = builder.displayName;
        this.device = builder.device;
    }

    public static class SensorBuilder {
        private String id;
        private String displayName;
        private Device device;

        public SensorBuilder(String id) {
            this.id = id;
            this.displayName = id;
        }

        public SensorBuilder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public SensorBuilder withDevice(Device device) {
            this.device = device;
            return this;
        }

        public Sensor build() {
            return new Sensor(this);
        }
    }
}
