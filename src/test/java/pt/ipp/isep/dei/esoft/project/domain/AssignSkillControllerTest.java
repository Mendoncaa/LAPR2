package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization.AssignSkillController;

import static org.junit.jupiter.api.Assertions.*;

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



    /*@Test
    void assignSkillToTeamMemberSkillNotFound() {
        String skillId = "123";
        String teamMemberId = "456";

        TeamMember teamMember = new TeamMember("Test TeamMember");
        repositories.addTeamMember(teamMember);

        assertFalse(controller.assignSkillToTeamMember(teamMemberId, skillId), "Expected skill assignment to fail when skill is not found");
    }*/

    @Test
    void assignSkillToTeamMemberTeamMemberNotFound() {
        String skillId = "124";
        String teamMemberId = "456";

        Skill skill = new Skill("Test Skill");
        skillRepository.addSkill(skill);

        assertFalse(controller.assignSkillToTeamMember(teamMemberId, skillId), "Expected skill assignment to fail when team member is not found");
    }

    /*@Test
    void assignSkillToTeamMemberSuccess() {
        String skillId = "125";
        String teamMemberId = "457";

        Skill skill = new Skill("Test Skill");
        skillRepository.addSkill(skill);

        TeamMember teamMember = new TeamMember("Test TeamMember");
        repositories.addTeamMember(teamMember);

        assertTrue(controller.assignSkillToTeamMember(teamMemberId, skillId), "Expected skill assignment to succeed when both team member and skill are found");
        assertTrue(teamMember.getSkills().contains(skill), "Expected the team member to have the assigned skill");
    }*/
}
