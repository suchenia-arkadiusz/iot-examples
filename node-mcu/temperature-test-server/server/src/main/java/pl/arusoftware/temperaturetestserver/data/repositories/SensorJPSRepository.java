package pl.arusoftware.temperaturetestserver.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arusoftware.temperaturetestserver.data.entities.Sensor;
import pl.arusoftware.temperaturetestserver.data.valueobjects.WeatherSensorValue;

@Repository
public interface SensorJPSRepository extends JpaRepository<Sensor, String> {

    @Query("select date, temperature, attitude, pressure, humidity from sensor_value sv where sv.sensor_id = ?1 order" +
            " by date desc limit 1")
    WeatherSensorValue getActualWeatherInfoForSensor(String sensorId);
}
