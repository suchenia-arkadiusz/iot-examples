package pl.arusoftware.temperaturetestserver.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.arusoftware.temperaturetestserver.data.entities.Sensor;
import pl.arusoftware.temperaturetestserver.data.views.data.SensorInfo;
import pl.arusoftware.temperaturetestserver.data.views.data.WeatherInfoViewDate;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface SensorJPSRepository extends JpaRepository<Sensor, String> {

    @Query(value = "select temperature, attitude, pressure, humidity from sensor_value where " +
            "sensor_id = ?1 order by date desc limit 1", nativeQuery = true)
    WeatherInfoViewDate.ActualWeatherInfo getActualWeatherInfoForSensor(String sensorId);

    @Transactional
    @Modifying
    @Query(value = "insert into sensor_value (\"date\", temperature, humidity, pressure, attitude, sensor_id) " +
            "values (?1, ?2, ?3, ?4, ?5, ?6) ", nativeQuery = true)
    void updateWeatherInfo(Date date, float temperature, float humidity, float pressure, float altitude, String sensorId);

    @Query(value = "select id, display_name, device_id from sensor where id = ?1", nativeQuery = true)
    SensorInfo getSensorInfo(String sensorId);
}
