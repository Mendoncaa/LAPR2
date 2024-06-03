package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AssignSkillController;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssignSkillControllerTest {
    private SkillRepository skillRepository;
    private Repositories repositories;
    private AssignSkillController controller;

    @BeforeEach
    void setUp() {
        repositories = Repositories.getInstance();
        skillRepository = repositories.getSkillRepository();
        controller = new AssignSkillController();
    }


   /* @Test
    void assignSkillToTeamMemberTeamMemberNotFound() {
        String skillId = "124";
        String teamMemberId = "456";

        Skill skill = new Skill("Test Skill");
        skillRepository.addSkill(skill);

        assertFalse(controller.assignSkillToTeamMember(teamMemberId, skillId), "Expected skill assignment to fail when team member is not found");
    } */
}

