package pt.ipp.isep.dei.esoft.project.domain.service;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.List;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService() {
        this.vehicleRepository = Repositories.getInstance().getVehicleRepository();
    }
    public void listVehiclesNeedingCheckUp() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();

        for (Vehicle vehicle : vehicles) {

            /*if (vehicle.calculateNextCheckup() < 0)  {
                System.out.println(vehicle);
            }*/

        }

    }
}

