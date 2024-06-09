package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.service.VehicleService;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleServiceTest {

    @Test
    public void ensureVehiclesNeedingCheckUpAreListed() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService();

        Vehicle vehicle1 = new Vehicle("789-GHI", "Ford", "Fiesta", "Sedan", 5000, 15000, 4000, LocalDate.of(2022,01,01), LocalDate.of(2021,01,01), 5000);
        Vehicle vehicle2 = new Vehicle("012-JKL", "Nissan", "Leaf", "Electric", 10000, 20000, 9000, LocalDate.of(2023,02,01), LocalDate.of(2022,02,01), 10000);

        vehicleRepository.addVehicle(vehicle1);
        vehicleRepository.addVehicle(vehicle2);


        List<Vehicle> vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();

        assertFalse(vehiclesNeedingCheckup.isEmpty());
        assertTrue(vehiclesNeedingCheckup.contains(vehicle1));
        assertTrue(vehiclesNeedingCheckup.contains(vehicle2));
    }


    @Test
    public void ensureVehiclesNotNeedingCheckUpAreNotListed() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService();


        Vehicle vehicle1 = new Vehicle("789-GHI", "Ford", "Fiesta", "Sedan", 5000, 15000, 0, LocalDate.of(2022,01,01), LocalDate.of(2021,01,01), 5000);
        Vehicle vehicle2 = new Vehicle("012-JKL", "Nissan", "Leaf", "Electric", 10000, 20000, 0, LocalDate.of(2023,02,01), LocalDate.of(2022,02,01), 10000);

        List<Vehicle> vehiclesNeedingCheckup = new ArrayList<>();
        vehiclesNeedingCheckup.add(vehicle1);
        vehiclesNeedingCheckup.add(vehicle2);

        vehiclesNeedingCheckup = vehicleService.listVehiclesNeedingCheckUp();


        assertTrue(vehiclesNeedingCheckup.isEmpty());
    }

}


