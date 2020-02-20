package pl.arusoftware.temperaturetestserver.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arusoftware.temperaturetestserver.data.entities.Device;

@Repository
public interface DeviceJPARepository extends JpaRepository<Device, String> {
}
