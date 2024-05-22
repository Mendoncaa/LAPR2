package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Optional;

/**
 * Controller class for creating jobs.
 */
public class CreateJobController {

    /**
     * Creates a new job if the user is logged in with the HRM role.
     *
     * @param jobName The name of the job.
     * @return The created job, if successful.
     * @throws IllegalArgumentException If the job name does not meet the specified criteria or if the user is not authorized.
     */
    public Optional<Job> createJob(String jobName) throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Hrm")) {
            String userEmail = userSession.getUserId().toString();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().getOrganizationByEmployeeEmail(userEmail);

            if (organizationOptional.isPresent()) {
                Organization organization = organizationOptional.get();
                Job job = organization.createJob(jobName);
                organization.addJob(job);
                return Optional.of(job);
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not authorized to create a job.");
        }
    }
}


