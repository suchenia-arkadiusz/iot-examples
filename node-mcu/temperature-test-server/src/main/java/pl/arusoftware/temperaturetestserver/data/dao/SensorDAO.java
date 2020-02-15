package pl.arusoftware.temperaturetestserver.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.entities.Sensor;
import pl.arusoftware.temperaturetestserver.data.repositories.SensorJPSRepository;

@Service
public class SensorDAO {
    private SensorJPSRepository repository;

    @Autowired
    public SensorDAO(SensorJPSRepository repository) {
        this.repository = repository;
    }

    public void persist(Sensor sensor) {

    }
}
