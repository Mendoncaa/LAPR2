package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for employees.
 */
public class EmployeeRepository {
    private List<Employee> employees;

    /**
     * Constructs a new employee repository.
     */
    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    /**
     * Adds a new employee to the repository.
     *
     * @param employee The employee to be added.
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Returns a list of all employees in the repository.
     *
     * @return A list of employees.
     */
    public List<Employee> listEmployees() {
        return new ArrayList<>(employees);
    }

    /**
     * Checks if an email belongs to an employee in the repository.
     *
     * @param email The email to be checked.
     * @return true if an employee with the given email exists, false otherwise.
     */
    public boolean emailExists(String email) {
        for (Employee employee : employees) {
            if (employee.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(String email) {
        for (Employee employee : employees) {
            if (employee.getEmail().equalsIgnoreCase(email)) {
                return employee;
            }
        }
        throw new IllegalArgumentException("Employee not found in this organization with the e-mail: " + email);
    }
}

