package pt.ipp.isep.dei.esoft.project.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * This class contains unit tests for the CreateSkillController.
 */
public class CreateSkillControllerTest {

/**
 * Tests the creation of a new skill in the organization.
 */
    @org.junit.Test
    public void createSkillTest() {

        // Setting up the test environment
        Employee employee = new Employee(
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
                new Job("Gardener"));

        // Initializing the CreateSkillController
        CreateSkillController createSkillController = new CreateSkillController();

        // Defining the skill name
        String skillName = "Programacao";

        // Setting up repositories and organization
        EmployeeRepository employeeRepository = new EmployeeRepository();
        JobRepository jobRepository = new JobRepository();
        Organization organization = new Organization("1234", employeeRepository, jobRepository);

        // Creating the skill in the organization
        Skill skill = organization.createSkill(skillName);

        // Asserting that the skill was created with the correct name
        assertEquals(skillName, skill.getName());

    }

/**
 * Tests the addition of a skill to the skill repository.
 */
    @org.junit.Test
    public void addSkillTest() {

        // Initializing the SkillRepository
        SkillRepository skillRepository = new SkillRepository();

        // Creating a new skill
        Skill skill = new Skill("Programacao");

        // Adding the skill to the repository
        skillRepository.addSkill(skill);

        // Retrieving all skills from the repository
        List<Skill> skills = skillRepository.listAllSkills();

        // Asserting that the skill was added correctly
        assertEquals(1, skills.size());
        assertEquals(skill, skills.get(0));
    }

}


