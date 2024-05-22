package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.util.*;

public class Organization {
    private final String vatNumber;
    private String name;
    private String website;
    private String phone;
    private String email;
    private JobRepository jobRepository;
    private EmployeeRepository employeeRepository;

    /**
     * This method is the constructor of the organization.
     *
     * @param vatNumber The vat number of the organization. This is the identity of the organization, therefore it
     *                  cannot be changed.
     */
    public Organization(String vatNumber) {
        this.vatNumber = vatNumber;
        this.jobRepository = new JobRepository();
        this.employeeRepository = new EmployeeRepository();
    }

    public Employee createEmployee(String name, Date birthdate, Date admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) {
        Employee employee = new Employee(name, birthdate, admissionDate, street, city, zipCode, phone, email, idDocType, idDocNumber, taxpayerId, job);
        return employee;
    }

    public void addEmployee(Employee employee) {
        // Check if the employee already exists in the repository
        if (employeeRepository.emailExists(employee.getEmail())) {
            throw new IllegalArgumentException("Employee with the same email already exists");
        }

        for (Employee emp : employeeRepository.listEmployees()) {
            if (emp.getTaxpayerId().compareTo(employee.getTaxpayerId()) == 0) {
                throw new IllegalArgumentException("Employee with the same taxpayer ID already exists");
            }
        }

        employeeRepository.addEmployee(employee);
    }

    public List<Employee> listAllEmployees() {
        return employeeRepository.listEmployees();
    }

    public boolean isEmailExists(String email) {
        return employeeRepository.emailExists(email);
    }

    /**
     * Creates a new job.
     * @param jobName The name of the job.
     * @return The created Job object.
     * @throws IllegalArgumentException If the job name does not meet the specified criteria.
     */
    public Job createJob(String jobName) throws IllegalArgumentException {
        return new Job(jobName);
    }

    /**
     * Adds a job to the repository after checking for duplicates.
     * @param job The job to add.
     * @throws IllegalArgumentException If a job with the same name already exists.
     */
    public void addJob(Job job) throws IllegalArgumentException {
        for (Job existingJob : jobRepository.listAllJobs()) {
            if (existingJob.compareTo(job) == 0) {
                throw new IllegalArgumentException("A job with the same name already exists: " + job.getJobName());
            }
        }
        jobRepository.addJob(job);
    }
    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.vatNumber);
        clone.name = (this.name);
        clone.website = (this.website);
        clone.phone = (this.phone);
        clone.email = (this.email);
        clone.jobRepository = (this.jobRepository);
        clone.employeeRepository = (this.employeeRepository);
        return clone;
    }
}