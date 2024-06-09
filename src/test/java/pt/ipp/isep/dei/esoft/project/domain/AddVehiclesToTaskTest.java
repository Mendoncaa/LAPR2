package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.AddVehiclesToTaskController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddVehiclesToTaskTest {

    @Test
    void listVehiclesNotAssignedByDateOfTasks_ValidTaskAndVehicles_ReturnsFilteredVehicles() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        Job job1 = new Job("Green Space Manager");
        jobRepository.addJob(job1);
        /*Employee gsm = organization.createEmployee(
                "Zé",
                LocalDate.of(1991, 1, 1),
                LocalDate.of(2020, 12, 31),
                "Rua da Morada 01",
                "Porto",
                "4000-050",
                "987654322",
                "gsm@this.app",
                "CC",
                "12345677",
                "987654321",
                job1 );

        employeeRepository.addEmployee(gsm);*/


        GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");
        Vehicle vehicle1 = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000);
        Vehicle vehicle2 = new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000);
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);
        List<Vehicle> expectedVehicles = new ArrayList<>();
        expectedVehicles.add(vehicle1);
        task.setVehicles(allVehicles);
        task.planTaskInAgenda(LocalDate.of(2024, 6, 1));
        AddVehiclesToTaskController controller = new AddVehiclesToTaskController();

        // Act
        List<Vehicle> result = controller.listVehiclesNotAssignedByDateOfTasks(task);

        // Assert
        assertEquals(expectedVehicles, result);
    }

    @Test
    void updateTaskVehicles_ValidTaskAndVehicles_ReturnsTrue() {
        // Arrange
        GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000));
        vehicles.add(new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000));
        AddVehiclesToTaskController controller = new AddVehiclesToTaskController();

        // Act
        boolean result = controller.updateTaskVehicles(task, vehicles);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void updateTaskVehicles_NullTask_ThrowsIllegalArgumentException() {
        // Arrange
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000));
        vehicles.add(new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000));
        AddVehiclesToTaskController controller = new AddVehiclesToTaskController();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.updateTaskVehicles(null, vehicles);
        });

        // Assert
        assertEquals("Task cannot be null", exception.getMessage());
    }

    @Test
    void updateTaskVehicles_NullVehicles_ThrowsIllegalArgumentException() {
        // Arrange
        GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");
        AddVehiclesToTaskController controller = new AddVehiclesToTaskController();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.updateTaskVehicles(task, null);
        });

        // Assert
        assertEquals("Vehicle list cannot be null or empty", exception.getMessage());
    }
}



