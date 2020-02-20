package pl.arusoftware.temperaturetestserver.data.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arusoftware.temperaturetestserver.data.dao.SensorDAO;
import pl.arusoftware.temperaturetestserver.data.views.data.WeatherInfoViewDate;

@Service
public class WeatherInfoView {

    private SensorDAO sensorDAO;

    @Autowired
    public WeatherInfoView(SensorDAO sensorDAO) {
        this.sensorDAO = sensorDAO;
    }

    public WeatherInfoViewDate.ActualWeatherInfo getActualWeatherInfoForSensor(String sensorId) {
        return sensorDAO.getActualWeatherInfoForSensor(sensorId);
    }
}
