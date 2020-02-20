package pl.arusoftware.temperaturetestserver.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.entities.Sensor;
import pl.arusoftware.temperaturetestserver.data.repositories.SensorJPSRepository;
import pl.arusoftware.temperaturetestserver.data.valueobjects.WeatherSensorValue;

@Service
public class SensorDAO {
    private SensorJPSRepository repository;

    @Autowired
    public SensorDAO(SensorJPSRepository repository) {
        this.repository = repository;
    }

    public void persist(Sensor sensor) {
        repository.save(sensor);
    }

    public Sensor getSensor(String id) {
        return repository.findById(id).orElse(null);
    }

    public WeatherSensorValue getActualWeatherInfoForSensor(String sensorId) {
        return repository.getActualWeatherInfoForSensor(sensorId);
    }
}
