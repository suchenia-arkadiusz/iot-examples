package pl.arusoftware.temperaturetestserver.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.arusoftware.temperaturetestserver.data.entities.Device;

@Repository
public interface DeviceJPARepository extends CrudRepository<Device, String> {
}
