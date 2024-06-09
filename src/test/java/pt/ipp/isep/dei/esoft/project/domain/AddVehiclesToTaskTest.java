package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.AddVehiclesToTaskController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddVehiclesToTaskTest {

    Bootstrap bootstrap = new Bootstrap();
    AuthenticationController authController = new AuthenticationController();
    AddVehiclesToTaskController controller = new AddVehiclesToTaskController();

    public AddVehiclesToTaskTest() {
        bootstrap.run();
    }


    @Test
    void updateTaskVehicles_ValidTaskAndVehicles_ReturnsTrue() {
        GreenSpace greenSpace = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000));
        vehicles.add(new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000));

        authController.doLogin("gsm@this.app", "gsm");

        // Act
        boolean result = controller.updateTaskVehicles(task, vehicles);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void updateTaskVehicles_NullTask_ThrowsIllegalArgumentException() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000));
        vehicles.add(new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000));

        authController.doLogin("gsm@this.app", "gsm");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.updateTaskVehicles(null, vehicles);
        });

        assertEquals("Task cannot be null", exception.getMessage());
    }

    @Test
    void updateTaskVehicles_NullVehicles_ThrowsIllegalArgumentException() {
        GreenSpace greenSpace = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");

        authController.doLogin("gsm@this.app", "gsm");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.updateTaskVehicles(task, null);
        });

        assertEquals("Vehicle list cannot be null or empty", exception.getMessage());
    }
}





