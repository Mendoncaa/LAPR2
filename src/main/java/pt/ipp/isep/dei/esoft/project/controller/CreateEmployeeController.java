package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public class CreateEmployeeController {

        private OrganizationRepository organizationRepository;
        private JobRepository jobRepository;
        private AuthenticationRepository authenticationRepository;
        private EmployeeRepository employeeRepository;

    //Repository instances are obtained from the Repositories class
    public CreateEmployeeController() {
        getOrganizationRepository();
        getAuthenticationRepository();
        //getEmployeeRepository();
        //getJobRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreateEmployeeController(OrganizationRepository organizationRepository,
                                TaskCategoryRepository jobRepository,
                                AuthenticationRepository authenticationRepository) {
        this.organizationRepository = organizationRepository;
        //this.jobRepository = jobRepository;
        this.authenticationRepository = authenticationRepository;
    }

    private OrganizationRepository getOrganizationRepository() {
        if (organizationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;
    }
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public List<Job> getAllJobs() {
        List<Job> Job = List.of();
        return Job;}

    public Optional<Employee> createEmployee(String name, Date birthdate, Date admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) {
        return null;
    }
}