package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.VfmUI;

import java.sql.ClientInfoStatus;
import java.time.Duration;
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
        SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
        VehicleRepository vehicleRepository = Repositories.getInstance().getVehicleRepository();
        GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        TaskRepository taskRepository = Repositories.getInstance().getTaskRepository();

        Organization organization = new Organization("MusgoSublime", employeeRepository, jobRepository);
        Job job = new Job("Human Resources Manager");
        jobRepository.addJob(job);
        Job job2 = new Job("Green Space Manager");
        jobRepository.addJob(job2);


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
                job);

        employeeRepository.addEmployee(hrm);


        Employee gsm = organization.createEmployee(
                "Zé",
                LocalDate.of(1991, 1, 1),
                LocalDate.of(2020, 12, 31),
                "Rua da Morada 01",
                "Porto",
                "4000-050",
                "987654322",
                "gsm@this.app",
                "CC",
                "12345677",
                "987654321",
                job2);

        employeeRepository.addEmployee(gsm);

        Employee vfm = organization.createEmployee(
                "Zé",
                LocalDate.of(1991, 1, 1),
                LocalDate.of(2020, 12, 31),
                "Rua da Morada 01",
                "Porto",
                "4000-050",
                "987654332",
                "vfm@this.app",
                "CC",
                "12345678",
                "987784321",
                job2);

        employeeRepository.addEmployee(vfm);


        organizationRepository.add(organization);

        Skill skill1 = new Skill("Trolha");
        skillRepository.addSkill(skill1);

        // Employee employee1 = new Employee();

        Vehicle vehicle1 = new Vehicle(
                "ABC1234",
                "Toyota",
                "Corolla",
                "Sedan",
                1300,
                1800,
                50000,
                LocalDate.of(1991, 1, 1),
                LocalDate.of(2020, 12, 31),
                10000
        );
        vehicleRepository.addVehicle(vehicle1);

        GreenSpace greenSpace1 = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");
        greenSpaceRepository.addGreenSpace(greenSpace1);

        Task task1 = new Task("Limpeza", greenSpace1, "Limpeza dos caixotes do lixo",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(2));
        taskRepository.addTask(task1);




    }




    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HRM, AuthenticationController.ROLE_HRM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_VFM, AuthenticationController.ROLE_VFM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserWithRole("Hrm", "hrm@this.app", "hrm",
                AuthenticationController.ROLE_HRM);
        authenticationRepository.addUserWithRole("Vfm", "vfm@this.app", "vfm",
                AuthenticationController.ROLE_VFM);
        authenticationRepository.addUserWithRole("Gsm", "gsm@this.app", "gsm",
                AuthenticationController.ROLE_GSM);
    }
}