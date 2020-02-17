package pl.arusoftware.temperaturetestserver.controllers.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arusoftware.temperaturetestserver.controllers.weather.data.WeatherSensor;
import pl.arusoftware.temperaturetestserver.data.aggregates.WeatherInfo;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    private WeatherInfo weatherInfo;

    @Autowired
    public WeatherController(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    @PostMapping(value = "/weatherinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public void putDeviceInfo(@RequestBody WeatherInfoRequest request) {
        LOGGER.debug(request.toString());
        try {
            for (WeatherSensor sensor : request.getDevice().getSensors()) {
                WeatherInfo.WeatherInfoData weatherInfoData = new WeatherInfo.WeatherInfoData.WeatherInfoDataBuilder()
                        .withAttitude(sensor.getValue().getAttitude())
                        .withHumidity(sensor.getValue().getHumidity())
                        .withPressure(sensor.getValue().getPressure())
                        .withTemperature(sensor.getValue().getTemperature())
                        .withDeviceId(request.getDevice().getId())
                        .withSensorId(sensor.getId())
                        .build();
                weatherInfo.storeSensorInfo(weatherInfoData);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
