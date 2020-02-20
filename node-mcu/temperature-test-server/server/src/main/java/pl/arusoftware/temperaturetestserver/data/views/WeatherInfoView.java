package pl.arusoftware.temperaturetestserver.data.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.dao.SensorDAO;
import pl.arusoftware.temperaturetestserver.data.valueobjects.WeatherSensorValue;

@Service
public class WeatherInfoView {

    private SensorDAO sensorDAO;

    @Autowired
    public WeatherInfoView(SensorDAO sensorDAO) {
        this.sensorDAO = sensorDAO;
    }

    public WeatherSensorValue getActualWeatherInfoForSensor(String sensorId) {
        return sensorDAO.getActualWeatherInfoForSensor(sensorId);
    }
}
