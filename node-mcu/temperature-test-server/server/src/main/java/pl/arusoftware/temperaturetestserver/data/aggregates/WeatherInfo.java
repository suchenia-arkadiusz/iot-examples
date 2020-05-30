package pl.arusoftware.temperaturetestserver.data.aggregates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.dao.DeviceDAO;
import pl.arusoftware.temperaturetestserver.data.dao.SensorDAO;
import pl.arusoftware.temperaturetestserver.data.entities.Device;
import pl.arusoftware.temperaturetestserver.data.entities.Sensor;
import pl.arusoftware.temperaturetestserver.data.valueobjects.WeatherSensorValue;

@Service
public class WeatherInfo {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInfo.class);

    private DeviceDAO deviceDAO;
    private SensorDAO sensorDAO;

    @Autowired
    public WeatherInfo(DeviceDAO deviceDAO, SensorDAO sensorDAO) {
        this.deviceDAO = deviceDAO;
        this.sensorDAO = sensorDAO;
    }

    public void storeSensorInfo(WeatherInfoData data) {
        Device device = deviceDAO.getDevice(data.deviceId);
        Sensor sensor = null;

        if (null == device) {
            device = new Device.DeviceBuilder(data.deviceId).build();
            LOGGER.info("Created new device entry with id: " + device.getId());
        }

        if (sensorDAO.isSensorExists(data.sensorId)) {
            updateSensorInfo(data);
            return;
        } else {
            sensor = new Sensor.SensorBuilder(data.sensorId).withDevice(device).build();
            LOGGER.info("Created new sensor entry with id: " + sensor.getId());
        }

        WeatherSensorValue value = new WeatherSensorValue.WeatherSensorValueBuilder()
                .withAttitude(data.attitude)
                .withHumodoty(data.humidity)
                .withPressure(data.pressure)
                .withTemperature(data.temperature)
                .build();
        
        sensor.addValue(value);

        deviceDAO.persist(device);
        sensorDAO.persist(sensor);
    }

    private void updateSensorInfo(WeatherInfoData data) {
        Sensor sensor = new Sensor.SensorBuilder(data.sensorId).build();

        WeatherSensorValue value = new WeatherSensorValue.WeatherSensorValueBuilder()
                .withAttitude(data.attitude)
                .withHumodoty(data.humidity)
                .withPressure(data.pressure)
                .withTemperature(data.temperature)
                .build();

        sensorDAO.addNewWeatherInfo(sensor, value);
    }

    public static class WeatherInfoData {
        private float temperature;
        private float pressure;
        private float attitude;
        private float humidity;

        private String sensorId;
        private String deviceId;

        public WeatherInfoData() {
        }

        private WeatherInfoData(WeatherInfoDataBuilder builder) {
            this.temperature = builder.temperature;
            this.pressure = builder.pressure;
            this.attitude = builder.attitude;
            this.humidity = builder.humidity;

            this.sensorId = builder.sensorId;
            this.deviceId = builder.deviceId;
        }

        public static class WeatherInfoDataBuilder {
            private float temperature;
            private float pressure;
            private float attitude;
            private float humidity;

            private String sensorId;
            private String deviceId;

            public WeatherInfoDataBuilder() {
            }

            public WeatherInfoDataBuilder withTemperature(float temperature) {
                this.temperature = temperature;
                return this;
            }

            public WeatherInfoDataBuilder withPressure(float pressure) {
                this.pressure = pressure;
                return this;
            }

            public WeatherInfoDataBuilder withAttitude(float attitude) {
                this.attitude = attitude;
                return this;
            }

            public WeatherInfoDataBuilder withHumidity(float humidity) {
                this.humidity = humidity;
                return this;
            }

            public WeatherInfoDataBuilder withSensorId(String sensorId) {
                this.sensorId = sensorId;
                return this;
            }

            public WeatherInfoDataBuilder withDeviceId(String deviceId) {
                this.deviceId = deviceId;
                return this;
            }

            public WeatherInfoData build() {
                return new WeatherInfoData(this);
            }
        }
    }
}
