package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

public class CreateVehicleController {
    private VehicleRepository vehicleRepository;

    public CreateVehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public boolean createVehicle(String plateID, String brand, String model, String type, int tare, int grossWeight,
                                 int currentKms, String registerDate, String  acquisitionDate, int checkUpFrequencyInKms) {

        Vehicle newVehicle = new Vehicle(plateID, brand, model, type, tare, grossWeight,
                currentKms, registerDate, acquisitionDate, checkUpFrequencyInKms);

        vehicleRepository.addVehicle(newVehicle);

        return true; // Assuming vehicle creation is always successful for simplicity
    }
}
