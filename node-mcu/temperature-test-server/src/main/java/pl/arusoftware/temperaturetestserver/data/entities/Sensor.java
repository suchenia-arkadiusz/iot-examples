package pl.arusoftware.temperaturetestserver.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Sensor {
    @Id
    private String id;
    private String displayName;
    @ManyToOne
    @JoinColumn(name = "DEVICE_ID", nullable = false)
    private Device device;

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
