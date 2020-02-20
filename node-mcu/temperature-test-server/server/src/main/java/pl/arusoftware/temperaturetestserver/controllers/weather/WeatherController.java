package pl.arusoftware.temperaturetestserver.controllers.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.arusoftware.temperaturetestserver.controllers.weather.data.WeatherSensor;
import pl.arusoftware.temperaturetestserver.controllers.weather.data.requests.WeatherInfoRequest;
import pl.arusoftware.temperaturetestserver.controllers.weather.data.responses.DeviceInfoResponse;
import pl.arusoftware.temperaturetestserver.controllers.weather.data.responses.WeatherInfoResponse;
import pl.arusoftware.temperaturetestserver.data.aggregates.WeatherInfo;
import pl.arusoftware.temperaturetestserver.data.dao.DeviceDAO;
import pl.arusoftware.temperaturetestserver.data.valueobjects.WeatherSensorValue;
import pl.arusoftware.temperaturetestserver.data.views.WeatherInfoView;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    private WeatherInfo weatherInfo;
    private DeviceDAO deviceDAO;
    private WeatherInfoView weatherInfoView;

    @Autowired
    public WeatherController(WeatherInfo weatherInfo, DeviceDAO deviceDAO, WeatherInfoView weatherInfoView) {
        this.weatherInfo = weatherInfo;
        this.deviceDAO = deviceDAO;
        this.weatherInfoView = weatherInfoView;
    }

    @PostMapping("/weatherinfo")
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

    @GetMapping("/devices")
    public Set<DeviceInfoResponse> getDevices() {
        LOGGER.debug("Get all devices");

        return deviceDAO.getDevices().stream()
                .map(device -> new DeviceInfoResponse(device.getId(), device.getDisplayName()))
                .collect(Collectors.toSet());
    }

    @GetMapping("/weatherInfo/newest/{sensorId}")
    public WeatherInfoResponse getActualWeather(@PathVariable("sensorId") String sensorId) {
        LOGGER.debug("Get actual weather info");

        return mapWeatherSensorValueToWeatherInfoResponse(weatherInfoView.getActualWeatherInfoForSensor(sensorId));
    }

    private WeatherInfoResponse mapWeatherSensorValueToWeatherInfoResponse(WeatherSensorValue value) {
        WeatherInfoResponse response = new WeatherInfoResponse();
        response.setAltitude(value.getAttitude());
        response.setHumidity(value.getHumidity());
        response.setPressure(value.getPressure());
        response.setTemperature(value.getTemperature());
        return response;
    }
}
