package pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization;



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


        if (vehicleRepository.getVehicleByPlateId(plateID) == null) {
            return false;
        }

        CheckUp newCheckUp = new CheckUp(plateID, scheduleDate, currentKms);


        return true;
    }
}
