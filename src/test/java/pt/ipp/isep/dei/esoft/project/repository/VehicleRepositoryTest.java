import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class VehicleRepositoryTest {

    @Test
    void testAddVehicleAndGetVehicleByPlateId() {
        VehicleRepository repository = new VehicleRepository();
        Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                50000, "2022-01-01", "2022-01-01", 10000);
        repository.addVehicle(vehicle);

        assertEquals(vehicle, repository.getVehicleByPlateId("AB123CD"));
    }

    @Test
    void testGetVehicleByPlateIdNotFound() {
        VehicleRepository repository = new VehicleRepository();
        Vehicle vehicle = repository.getVehicleByPlateId("AB123CD");

        assertNull(vehicle);
    }

    @Test
    void testGetVehicles() {
        VehicleRepository repository = new VehicleRepository();
        Vehicle vehicle1 = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                50000, "2022-01-01", "2022-01-01", 10000);
        Vehicle vehicle2 = new Vehicle("XY987ZW", "Ford", "Focus", "Hatchback", 1100, 1400,
                60000, "2021-12-01", "2022-02-01", 12000);
        repository.addVehicle(vehicle1);
        repository.addVehicle(vehicle2);

        List<Vehicle> vehicles = repository.getVehicles();
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(vehicle1));
        assertTrue(vehicles.contains(vehicle2));
    }





}
