package pl.arusoftware.temperaturetestserver.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Device {
    @Id
    private String id;
    private String displayName;

    public Device() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id.equals(device.id);
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

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }

    private Device(DeviceBuilder builder) {
        this.id = builder.id;
        this.displayName = builder.displayName;
    }

    public static class DeviceBuilder {
        private String id;
        private String displayName;

        public DeviceBuilder(String id) {
            this.id = id;
            this.displayName = id;
        }

        public DeviceBuilder withDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }
}
