package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.*;

public class Organization {
    private final String vatNumber;
    private String name;
    private String website;
    private String phone;
    private String email;
    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private JobRepository jobRepository = Repositories.getInstance().getJobRepository();
    private VehicleRepository vehicleRepository = Repositories.getInstance().getVehicleRepository();
    /**
     * This method is the constructor of the organization.
     *
     * @param vatNumber The vat number of the organization. This is the identity of the organization, therefore it
     *                  cannot be changed.
     */
    public Organization(String vatNumber, EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.vatNumber = vatNumber;
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    public Employee createEmployee(String name, LocalDate birthdate, LocalDate admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job selectedJob) {
        Employee employee = new Employee(name, birthdate, admissionDate, street, city, zipCode, phone, email, idDocType, idDocNumber, taxpayerId, selectedJob);
        return employee.clone();
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


    public void addVehicle(Vehicle vehicle) {
        // Check if the employee already exists in the repository
        if (vehicleRepository.plateIDExists(vehicle.getPlateID())) {
            throw new IllegalArgumentException("Vehicle with the same plate already exists");
        }

        vehicleRepository.addVehicle(vehicle);
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


    public Skill createSkill(String skillName) throws IllegalArgumentException {
        return new Skill(skillName);
    }


    /**
     * Adds a job to the repository after checking for duplicates.
     *
     * @param job           The job to add.
     * @param jobRepository
     * @throws IllegalArgumentException If a job with the same name already exists.
     */
    public void addJob(Job job, JobRepository jobRepository) throws IllegalArgumentException {

        for (Job existingJob : jobRepository.listAllJobs()) {
            if (existingJob.compareTo(job) == 0) {
                throw new IllegalArgumentException("A job with the same name already exists: " + job.getJobName());
            }
        }
        jobRepository.addJob(job);
    }

    public void addSkill(Skill skill, SkillRepository skillRepository) throws IllegalArgumentException {

        for (Skill existingskill : skillRepository.listAllSkills()) {
            if (existingskill.compareTo(skill) == 0) {
                throw new IllegalArgumentException("A skill with the same name already exists: " + skill.getName());
            }
        }
        skillRepository.addSkill(skill);
    }

    public String getName() {
        return name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.vatNumber,this.employeeRepository,this.jobRepository);
        clone.name = (this.name);
        clone.website = (this.website);
        clone.phone = (this.phone);
        clone.email = (this.email);
        return clone;
    }
}