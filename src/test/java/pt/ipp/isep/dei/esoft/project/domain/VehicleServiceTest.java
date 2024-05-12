package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.service.VehicleService;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

public class VehicleServiceTest {

    @Test
    public void ensureVehiclesNotNeedingCheckUpAreNotListed() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);


        vehicleRepository.add(new Vehicle("789-GHI", "Ford", "Fiesta", 5000, 15000, 0));
        vehicleRepository.add(new Vehicle("012-JKL", "Nissan", "Leaf", 10000, 20000, 0));


        List<Vehicle> vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();


        assertTrue(vehiclesNeedingCheckup.isEmpty());
    }

}


