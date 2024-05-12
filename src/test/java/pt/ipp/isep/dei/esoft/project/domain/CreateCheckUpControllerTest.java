package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization.CreateCheckUpController;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

public class CreateCheckUpControllerTest {

    @Test
    void testCreateCheckUpController() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        CreateCheckUpController controller = new CreateCheckUpController(vehicleRepository);
    }

    @Test
    void testCreateCheckUpWithNegativeCurrentKms() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        CreateCheckUpController controller = new CreateCheckUpController(vehicleRepository);

        String plateID = "AB123CD";
        String scheduleDate = "2022-05-20";
        int currentKms = -1000;

        boolean result = controller.createCheckUp(plateID, scheduleDate, currentKms);

        assertFalse(result);
    }

    @Test
    void testCreateCheckUpWithNonExistingVehicle() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        CreateCheckUpController controller = new CreateCheckUpController(vehicleRepository);

        // Assuming "XYZ789" does not exist in the repository
        String plateID = "XYZ789";
        String scheduleDate = "2022-05-20";
        int currentKms = 50000;

        boolean result = controller.createCheckUp(plateID, scheduleDate, currentKms);

        assertFalse(result);
    }

}
