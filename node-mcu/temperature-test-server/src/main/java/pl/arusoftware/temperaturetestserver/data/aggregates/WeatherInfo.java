package pl.arusoftware.temperaturetestserver.data.aggregates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.dao.DeviceDAO;

@Service
public class WeatherInfo {
    private DeviceDAO deviceDAO;

    @Autowired
    public WeatherInfo(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    public void storeSensorInfo() {
        deviceDAO.persist(null);
    }
}
