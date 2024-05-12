package pt.ipp.isep.dei.esoft.project.repository.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;


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

}