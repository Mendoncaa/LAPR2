package pt.ipp.isep.dei.esoft.project.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateVehicleControllerTest {

    @Test
    void testCreateVehicle() {
        VehicleRepository mockRepository = mock(VehicleRepository.class);
        CreateVehicleController controller = new CreateVehicleController(mockRepository);

        assertTrue(controller.createVehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                50000, "2022-01-01", "2022-01-01", 10000));

        verify(mockRepository, times(1)).addVehicle(any());
    }
}
