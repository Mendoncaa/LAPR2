import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.checkup.CreateCheckUpController;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

public class CreateCheckUpControllerTest {

    @Test
    void testCreateCheckUpController() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        CreateCheckUpController controller = new CreateCheckUpController(vehicleRepository);
        // Perform any necessary assertions about the controller creation
    }
}
