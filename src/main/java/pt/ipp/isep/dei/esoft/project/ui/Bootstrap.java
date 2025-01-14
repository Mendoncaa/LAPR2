package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.VfmUI;

import java.sql.ClientInfoStatus;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addOrganization();
        addUsers();

    }


    private void addOrganization() {
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();
        SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
        TeamRepository teamRepository = Repositories.getInstance().getTeamRepository();
        Organization organization = new Organization("MusgoSublime", employeeRepository, jobRepository);
        organizationRepository.add(organization);

        /*List<Skill> skills = new ArrayList<>();
        skills.add(skillRepository.getSkills().get(0));

        List<Employee> employees = new ArrayList<>();
        employees.add(employeeRepository.getEmployeeById("amadeu@this.app"));

        Team team = new Team(1, 1, skills, employees);
        team.assignTeamMember(employeeRepository.getEmployeeById("amadeu@this.app"));
        System.out.println(team);
        teamRepository.addTeam(team);*/

        /*Job job = new Job("Collaborator");
        jobRepository.addJob(job);
        Employee gsm = organization.createEmployee(
                "Zé",
                LocalDate.of(1991, 1, 1),
                LocalDate.of(2020, 12, 31),
                "Rua da Morada 01",
                "Porto",
                "4000-055",
                "987654323",
                "gsm@this.app",
                "CC",
                "12345678",
                "987654322",
                jobRepository.getJobByName("Collaborator"));

        employeeRepository.addEmployee(gsm);*/


        /*Employee hrm = organization.createEmployee(
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
                jobRepository.getJobByName("Human Resources Manager"));

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
                jobRepository.getJobByName("Green Space Manager"));

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
                jobRepository.getJobByName("Vehicle and Equipment Fleet Manager"));

        employeeRepository.addEmployee(vfm);*/


        //TODO: add organizations bootstrap here

        /*
        SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
        VehicleRepository vehicleRepository = Repositories.getInstance().getVehicleRepository();
        GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        TaskRepository taskRepository = Repositories.getInstance().getTaskRepository();







        Employee collaborator1 = organization.createEmployee(
                "Zé",
                LocalDate.of(1992, 2, 2),
                LocalDate.of(2021, 11, 30),
                "Rua da Morada 02",
                "Porto",
                "4000-051",
                "987654336",
                "collaborator@this.app",
                "CC",
                "12345678",
                "987784321",
                job2);

        employeeRepository.addEmployee(vfm);



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
        GreenSpace greenSpace2 = new GreenSpace("Parque da city", SizeClassification.MEDIUM_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "other@this.app");
        greenSpaceRepository.addGreenSpace(greenSpace2);

        Task task1 = new Task("Limpeza", greenSpace1, "Limpeza dos caixotes do lixo",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(2), "gsm@this.app");
        taskRepository.addTask(task1);

        Task task2 = new Task(" Limpeza1", greenSpace1, "Limpeza dos caixotes do lixo1",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(3), "gsm@this.app");
        task2.planTaskInAgenda(LocalDate.of(2026, 12, 31));
        taskRepository.addTask(task2);*/



    }




    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HRM, AuthenticationController.ROLE_HRM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_VFM, AuthenticationController.ROLE_VFM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_COLLAB, AuthenticationController.ROLE_COLLAB);

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
        authenticationRepository.addUserWithRole("Collab", "collab1@this.app", "collab1",
                AuthenticationController.ROLE_COLLAB);
    }
}