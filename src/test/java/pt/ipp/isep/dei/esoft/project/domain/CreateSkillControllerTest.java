package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

import static org.junit.jupiter.api.Assertions.*;

public class CreateSkillControllerTest {
    private SkillRepository skillRepository;
    private CreateSkillController controller;

    @BeforeEach
    void setUp() {
        skillRepository = new SkillRepository();
        // controller = new CreateSkillController(skillRepository);
    }

    @Test
    void createSkillWithValidName() {
        String skillName = "Test Skill";
        boolean expResult = true;
        // boolean result = controller.createSkill(skillName);
        // assertEquals(expResult, result);

    }

    //@Test
    /* void createSkillWithInvalidName() {
        String skillName = "Test Skill 123";
        boolean expResult = false;
        boolean result = controller.createSkill(skillName);
        assertEquals(expResult, result);
    }*/
}



