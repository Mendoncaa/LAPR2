package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.Organization;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.List;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addOrganization();
        addUsers();

    }


    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();

        Organization organization = new Organization("MusgoSublime", employeeRepository, jobRepository);
        Job job = new Job("Human Resources Manager");
        jobRepository.addJob(job);


        Employee hrm = organization.createEmployee(
                "Zé",
                LocalDate.of(1991, 1, 1),
                LocalDate.of(2020, 12, 31),
                "Rua da Morada 00",
                "Porto",
                "4000-050",
                "987654321",
                "hrm@this.app",
                "CC",
                "12345678",
                "123456789",
                "Human Resources Manager");

        employeeRepository.addEmployee(hrm);
        organizationRepository.add(organization);


    }




    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HRM, AuthenticationController.ROLE_HRM);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole("Hrm", "hrm@this.app", "hrm",
                AuthenticationController.ROLE_HRM);
    }
}