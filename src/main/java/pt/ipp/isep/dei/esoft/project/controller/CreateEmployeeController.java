package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for creating employees.
 */
public class CreateEmployeeController {

    /**
     * Creates a new job if the user is logged in with the HRM role.
     *
     * @return The created job, if successful.
     * @throws IllegalArgumentException If the job name does not meet the specified criteria or if the user is not authorized.
     */
    public Optional<Employee> createEmployee(String name, Date birthdate, Date admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Hrm")) {
            String userEmail = userSession.getUserId().toString();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().getOrganizationByEmployeeEmail(userEmail);

            if (organizationOptional.isPresent()) {
                Organization organization = organizationOptional.get();
                Employee employee = organization.createEmployee(name, birthdate, admissionDate, street, city, zipCode, phone, email, idDocType, idDocNumber, taxpayerId, job);
                organization.addEmployee(employee);
                return Optional.of(employee);
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not authorized to create a job.");
        }
    }

    public List<Job> listAllJobs() {
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();
        return jobRepository.listAllJobs();
    }
}
