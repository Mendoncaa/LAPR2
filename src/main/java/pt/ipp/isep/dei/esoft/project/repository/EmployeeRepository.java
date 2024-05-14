package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositório de funcionários.
 */
public class EmployeeRepository {
    private List<Employee> employees;

    /**
     * Constrói um novo repositório de funcionários.
     */
    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    /**
     * Adiciona um novo funcionário ao repositório.
     *
     * @param employee O funcionário a ser adicionado.
     * @throws IllegalArgumentException Se o funcionário já existe no repositório (com o mesmo email ou número de identificação fiscal).
     */
    public void addEmployee(Employee employee) {
        // Verifica se o funcionário já existe no repositório
        for (Employee emp : employees) {
            if (emp.getEmail().equals(employee.getEmail())) {
                throw new IllegalArgumentException("Employee with the same email already exists");
            }
            if (emp.getTaxpayerId().equals(employee.getTaxpayerId())) {
                throw new IllegalArgumentException("Employee with the same taxpayer ID already exists");
            }
        }
        employees.add(employee);
    }

    /**
     * Retorna uma lista de todos os funcionários no repositório.
     *
     * @return Uma lista de funcionários.
     */
    public List<Employee> listEmployees() {
        return new ArrayList<>(employees);
    }
}
