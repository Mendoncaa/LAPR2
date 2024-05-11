package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssignSkillControllerTest {
    private SkillRepository skillRepository;
    private Repositories repositories;
    private AssignSkillController controller;

    @BeforeEach
    void setUp() {
        skillRepository = new SkillRepository();
        repositories = Repositories.getInstance();
        controller = new AssignSkillController(skillRepository, repositories);
    }

    /*@Test
    void assignSkillToTeamMemberSkillNotFound() {
        String skillId = "123";
        String teamMemberId = "456";

        TeamMember teamMember = new TeamMember("Test TeamMember");
        repositories.addTeamMember(teamMember);

        assertFalse(controller.assignSkillToTeamMember(teamMemberId, skillId));
    }*/

    @Test
    void assignSkillToTeamMemberTeamMemberNotFound() {
        String skillId = "123";
        String teamMemberId = "456";

        Skill skill = new Skill("Test Skill");
        skillRepository.addSkill(skill);

        assertFalse(controller.assignSkillToTeamMember(teamMemberId, skillId));
    }

    /*@Test
    void assignSkillToTeamMemberSuccess() {
        String skillId = "123";
        String teamMemberId = "456";

        Skill skill = new Skill("Test Skill");
        skillRepository.addSkill(skill);

        TeamMember teamMember = new TeamMember("Test TeamMember");
        repositories.addTeamMember(teamMember);

        assertTrue(controller.assignSkillToTeamMember(teamMemberId, skillId));
        assertTrue(teamMember.getSkills().contains(skill));
    }*/
}