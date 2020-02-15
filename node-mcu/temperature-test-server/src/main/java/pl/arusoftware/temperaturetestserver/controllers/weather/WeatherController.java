package pl.arusoftware.temperaturetestserver.controllers.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    public WeatherController() {
    }

    @GetMapping("/weatherinfo")
    public void putDeviceInfo(WeatherInfoRequest request) throws JsonProcessingException {

    }
}
