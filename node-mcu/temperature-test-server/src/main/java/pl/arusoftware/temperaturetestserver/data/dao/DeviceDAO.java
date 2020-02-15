package pl.arusoftware.temperaturetestserver.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.entities.Device;
import pl.arusoftware.temperaturetestserver.data.repositories.DeviceJPARepository;

@Service
public class DeviceDAO {
    private DeviceJPARepository repository;

    @Autowired
    public DeviceDAO(DeviceJPARepository repository) {
        this.repository = repository;
    }

    public void persist(Device device) {
        System.out.println("Test");
    }
}
