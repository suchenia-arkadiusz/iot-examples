package pl.arusoftware.temperaturetestserver.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arusoftware.temperaturetestserver.data.entities.Sensor;
import pl.arusoftware.temperaturetestserver.data.views.data.WeatherInfoViewDate;

@Repository
public interface SensorJPSRepository extends JpaRepository<Sensor, String> {

    @Query(value = "select temperature, attitude, pressure, humidity from sensor_value where " +
            "sensor_id = ?1 order by date desc limit 1", nativeQuery = true)
    WeatherInfoViewDate.ActualWeatherInfo getActualWeatherInfoForSensor(String sensorId);
}
