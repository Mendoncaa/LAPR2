package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.ListGSManagedByMeController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListGSManagedByMeTest {

    private ListGSManagedByMeController controller;
    private AuthFacade authController;


    @BeforeEach
    public void setUp() {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);
        authenticationRepository.addUserWithRole("Gsm", "gsm@this.app", "gsm", AuthenticationController.ROLE_GSM);
        authController.doLogin("Gsm@this.app","gsm");

        controller = new ListGSManagedByMeController();
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        JobRepository jobRepository = Repositories.getInstance().getJobRepository();
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        Organization organization = new Organization("MusgoSublime", employeeRepository, jobRepository);
        organizationRepository.add(organization);
        Job job = new Job("Green Space Manager");
        jobRepository.addJob(job);
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

    }

    @Test
    public void testSortGreenSpaces_SizeDescending() {
        // Create mock green spaces
        GreenSpace gs1 = new GreenSpace("GreenSpace1", SizeClassification.MEDIUM_SIZED_PARK, 10.0, "Address1", "gsm@this.app");
        GreenSpace gs2 = new GreenSpace("GreenSpace2", SizeClassification.LARGE_SIZED_PARK, 20.0, "Address2", "gsm@this.app");
        GreenSpace gs3 = new GreenSpace("GreenSpace3", SizeClassification.MEDIUM_SIZED_PARK, 15.0, "Address3", "gsm@this.app");

        List<GreenSpace> greenSpaces = Arrays.asList(gs1, gs2, gs3);

        // Mock the method to return these green spaces
        List<GreenSpace> sortedGreenSpaces = controller.sortGreenSpaces("QuickSortAlgorithm");

        // Verify the result
        assertNotNull(sortedGreenSpaces);
        assertEquals(3, sortedGreenSpaces.size());
        assertEquals(gs2, sortedGreenSpaces.get(0));
        assertEquals(gs3, sortedGreenSpaces.get(1));
        assertEquals(gs1, sortedGreenSpaces.get(2));
    }

}

