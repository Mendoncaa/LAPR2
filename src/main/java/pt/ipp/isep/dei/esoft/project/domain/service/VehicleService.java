package pt.ipp.isep.dei.esoft.project.domain.service;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService() {
        this.vehicleRepository = Repositories.getInstance().getVehicleRepository();
    }
    public List<Vehicle> listVehiclesNeedingCheckUp() {

        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<Vehicle> vehicleNeedingCheckup = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.calculateNextCheckup() <= 0)  { // if <= 0 needs to do checkup

                vehicleNeedingCheckup.add(vehicle);

            }

        }

        return vehicleNeedingCheckup;

    }
}

