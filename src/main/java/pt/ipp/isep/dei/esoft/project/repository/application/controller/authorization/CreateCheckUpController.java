package pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization;

package pt.ipp.isep.dei.esoft.project.repository.application.controller.checkup;

import pt.ipp.isep.dei.esoft.project.domain.CheckUp;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

public class CreateCheckUpController {
    private VehicleRepository vehicleRepository;

    public CreateCheckUpController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public boolean createCheckUp(String plateID, String scheduleDate, int currentKms) {
        if (plateID == null || scheduleDate == null) {
            return false;
        }

        if (currentKms < 0) {
            return false;
        }

        // Check if the vehicle exists
        if (vehicleRepository.getVehicleByPlateId(plateID) == null) {
            return false;
        }

        CheckUp newCheckUp = new CheckUp(plateID, scheduleDate, currentKms);
        // Logic to add the check-up to the vehicle

        return true; // Assuming check-up creation is always successful for simplicity
    }
}
