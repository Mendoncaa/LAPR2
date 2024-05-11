package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeamMemberTest {

    @Test
    void testConstructor() {
        TeamMember teamMember = new TeamMember("Pedro Gomes");
        assertEquals("Pedro Gomes", teamMember.getName());
        assertTrue(teamMember.getSkills().isEmpty());
    }

    @Test
    void testAddSkill() {
        TeamMember teamMember = new TeamMember("Pedro Gomes");
        Skill skill = new Skill("Programming");
        teamMember.addSkill(skill);
        assertTrue(teamMember.getSkills().contains(skill));
    }

}
