package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRepositoryTest {

    @Test
    public void testAddEmployee() {
        EmployeeRepository repository = new EmployeeRepository();
        Job job = new Job("Developer");
        Employee emp1 = new Employee("John Doe", new Date(90, 0, 1), new Date(120, 0, 1), "123 Main St", "City", "12345-678", "123456789", "john@example.com", "CC", "123456789", "123456789", job);
        Employee emp2 = new Employee("Jane Doe", new Date(95, 5, 15), new Date(121, 3, 20), "456 Elm St", "Town", "98765-432", "987654321", "jane@example.com", "BI", "987654321", "987654321", job);

        repository.addEmployee(emp1);
        assertEquals(1, repository.listEmployees().size());
        assertTrue(repository.listEmployees().contains(emp1));

        repository.addEmployee(emp2);
        assertEquals(2, repository.listEmployees().size());
        assertTrue(repository.listEmployees().contains(emp2));
    }

    @Test
    public void testAddDuplicateEmployee() {
        EmployeeRepository repository = new EmployeeRepository();
        Job job = new Job("Developer");
        Employee emp1 = new Employee("John Doe", new Date(90, 0, 1), new Date(120, 0, 1), "123 Main St", "City", "12345-678", "123456789", "john@example.com", "CC", "123456789", "123456789", job);
        Employee emp2 = new Employee("John Doe", new Date(95, 5, 15), new Date(121, 3, 20), "456 Elm St", "Town", "98765-432", "987654321", "jane@example.com", "BI", "987654321", "987654321", job);

        repository.addEmployee(emp1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            repository.addEmployee(emp2);
        });

        assertEquals("Employee with the same email already exists", exception.getMessage());
        assertEquals(1, repository.listEmployees().size());
    }

    @Test
    public void testInvalidEmployeeDetails() {
        Job job = new Job("Developer");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", new Date(90, 0, 1), new Date(120, 0, 1), "123 Main St", "City", "12345-678", "123456789", "john@example.com", "CC", "123456789", "123456789", job);
        });
        assertEquals("Employee name cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Employee("John Doe", new Date(), new Date(120, 0, 1), "123 Main St", "City", "12345-678", "123456789", "john@example.com", "CC", "123456789", "123456789", job);
        });
        assertEquals("Invalid birthdate", exception.getMessage());

        // Add more tests for other invalid employee details if needed
    }
}

