package pt.ipp.isep.dei.esoft.project.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    void testCreateVehicle() {
        Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                50000, "2022-01-01", "2022-01-01", 10000);

        assertEquals("AB123CD", vehicle.getPlateID());
        assertEquals("Toyota", vehicle.getBrand());
        assertEquals("Corolla", vehicle.getModel());
        assertEquals("Sedan", vehicle.getType());
        assertEquals(1200, vehicle.getTare());
        assertEquals(1500, vehicle.getGrossWeight());
        assertEquals(50000, vehicle.getCurrentKms());
        assertEquals("2022-01-01", vehicle.getRegisterString());
        assertEquals("2022-01-01", vehicle.getAcquisitionString());
        assertEquals(10000, vehicle.getCheckUpFrequencyInKms());
    }

    @Test
    public void testCreateVehicleWithNullValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            Vehicle vehicle = new Vehicle(null, null, null, null, 0, 0, 0, null, null, 0);
        });
    }

    @Test
    public void testCreateVehicleWithShortPlateID() {
        assertThrows(IllegalArgumentException.class, () -> {
            Vehicle vehicle = new Vehicle("Ab1", "Toyota", "Corolla", "Sedan", 1200, 1500,
                    50000, "2022-01-01", "2022-01-01", 10000);
        });
    }


    @Test
    public void testCreateVehicleWithInvalidRegisterDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                    50000, null, "2022-01-01", 10000);
        });
    }

}
