package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.AddVehiclesToTaskController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.AuthFacade;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddVehiclesToTaskTest {

    private AddVehiclesToTaskController controller;
    private AuthFacade authController;

    @BeforeEach
    public void setUp() {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);
        authenticationRepository.addUserWithRole("Gsm", "gsm@this.app", "gsm", AuthenticationController.ROLE_GSM);
        authController.doLogin("Gsm@this.app","gsm");

        controller = new AddVehiclesToTaskController();
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        Organization organization = new Organization("MusgoSublime", employeeRepository, jobRepository);
        organizationRepository.add(organization);
        Job job = new Job("Green Space Manager");
        jobRepository.addJob(job);
        Employee gsm = organization.createEmployee(
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
                jobRepository.getJobByName("Green Space Manager"));
        employeeRepository.addEmployee(gsm);

    }

    @Test
    public void testListVehiclesNotAssignedByDateOfTasks() {
        GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");

        Vehicle vehicle1 = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000);
        Vehicle vehicle2 = new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000);

        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);

        task.setVehicles(allVehicles);
        task.planTaskInAgenda(LocalDate.of(2024, 6, 1));

        List<Vehicle> expectedVehicles = new ArrayList<>();
        expectedVehicles.add(vehicle1);

        List<Vehicle> result = controller.listVehiclesNotAssignedByDateOfTasks(task);

        assertNotNull(result);
        assertEquals(expectedVehicles, result);
    }

    @Test
    void updateTaskVehicles_ValidTaskAndVehicles_ReturnsTrue() {
        GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000));
        vehicles.add(new Vehicle("EF456GH", "Honda", "Civic", "Sedan", 1100, 1400, 45000, LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1), 9000));

        authController.doLogin("gsm@this.app", "gsm");

        boolean result = controller.updateTaskVehicles(task, vehicles);

        assertTrue(result);
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
        GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
        Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, java.time.Duration.ofHours(2), "gsm@this.app");

        authController.doLogin("gsm@this.app", "gsm");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.updateTaskVehicles(task, null);
        });

        assertEquals("Vehicle list cannot be null or empty", exception.getMessage());
    }
}





