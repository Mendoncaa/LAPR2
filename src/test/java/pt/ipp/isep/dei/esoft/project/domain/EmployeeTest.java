package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void ensureEmployeeConstructorWorks() {
        // Arrange
        String name = "John Doe";
        LocalDate birthdate = LocalDate.of(1990, 5, 15);
        LocalDate admissionDate = LocalDate.of(2020, 10, 1);
        String street = "123 Main St";
        String city = "Anytown";
        String zipCode = "12345-678";
        String phone = "123456789";
        String email = "john.doe@example.com";
        String idDocType = "CC";
        String idDocNumber = "12345678";
        String taxpayerId = "123456789";
        Job job = new Job("Manager");

        // Act
        Employee employee = new Employee(name, birthdate, admissionDate, street, city, zipCode, phone, email, idDocType, idDocNumber, taxpayerId, job);

        // Assert
        assertNotNull(employee);
        assertEquals(name, employee.getName());
        assertEquals(birthdate, employee.getBirthdate());
        assertEquals(admissionDate, employee.getAdmissionDate());
        assertEquals(street, employee.getStreet());
        assertEquals(city, employee.getCity());
        assertEquals(zipCode, employee.getZipCode());
        assertEquals(phone, employee.getPhone());
        assertEquals(email, employee.getEmail());
        assertEquals(idDocType, employee.getIdDocType());
        assertEquals(idDocNumber, employee.getIdDocNumber());
        assertEquals(taxpayerId, employee.getTaxpayerId());
        assertEquals(job, employee.getJob());
    }

    @Test
    void ensureCloneWorks() {
        // Arrange
        String name = "John Doe";
        LocalDate birthdate = LocalDate.of(1990, 5, 15);
        LocalDate admissionDate = LocalDate.of(2020, 10, 1);
        String street = "123 Main St";
        String city = "Anytown";
        String zipCode = "12345-678";
        String phone = "123456789";
        String email = "john.doe@example.com";
        String idDocType = "CC";
        String idDocNumber = "12345678";
        String taxpayerId = "123456789";
        Job job = new Job("Manager");
        Employee originalEmployee = new Employee(name, birthdate, admissionDate, street, city, zipCode, phone, email, idDocType, idDocNumber, taxpayerId, job);

        // Act
        Employee clonedEmployee = originalEmployee.clone();

        // Assert
        assertNotNull(clonedEmployee);
        assertNotSame(originalEmployee, clonedEmployee);
        assertEquals(originalEmployee.getName(), clonedEmployee.getName());
        assertEquals(originalEmployee.getBirthdate(), clonedEmployee.getBirthdate());
        assertEquals(originalEmployee.getAdmissionDate(), clonedEmployee.getAdmissionDate());
        assertEquals(originalEmployee.getStreet(), clonedEmployee.getStreet());
        assertEquals(originalEmployee.getCity(), clonedEmployee.getCity());
        assertEquals(originalEmployee.getZipCode(), clonedEmployee.getZipCode());
        assertEquals(originalEmployee.getPhone(), clonedEmployee.getPhone());
        assertEquals(originalEmployee.getEmail(), clonedEmployee.getEmail());
        assertEquals(originalEmployee.getIdDocType(), clonedEmployee.getIdDocType());
        assertEquals(originalEmployee.getIdDocNumber(), clonedEmployee.getIdDocNumber());
        assertEquals(originalEmployee.getTaxpayerId(), clonedEmployee.getTaxpayerId());
        assertEquals(originalEmployee.getJob(), clonedEmployee.getJob());
    }

    @Test
    void ensureCompareToWorks() {
        // Arrange
        Employee employee1 = new Employee("John Doe", LocalDate.of(1990, 5, 15), LocalDate.of(2020, 10, 1), "123 Main St", "Anytown", "12345-678", "123456789", "john.doe@example.com", "CC", "12345678", "123456789", new Job("Manager"));
        Employee employee2 = new Employee("Jane Doe", LocalDate.of(1995, 8, 20), LocalDate.of(2021, 3, 15), "456 Oak St", "Othertown", "98765-432", "987654321", "jane.doe@example.com", "BI", "87654321", "987654321", new Job("Developer"));

        // Act
        int result1 = employee1.compareTo(employee2);
        int result2 = employee2.compareTo(employee1);

        // Assert
        assertTrue(result1 < 0);
        assertTrue(result2 > 0);
    }

    @Test
    void ensureHasThisEmailWorksForMatchingEmail() {
        // Arrange
        String email = "john.doe@example.com";
        Employee employee = new Employee("John Doe", LocalDate.of(1990, 5, 15), LocalDate.of(2020, 10, 1), "123 Main St", "Anytown", "12345-678", "123456789", email, "CC", "12345678", "123456789", new Job("Manager"));
    }
}
