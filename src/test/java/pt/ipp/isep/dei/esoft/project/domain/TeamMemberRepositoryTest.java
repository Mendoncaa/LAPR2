package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.TeamMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class TeamMemberRepositoryTest {
    private TeamMemberRepository teamMemberRepository;

    @BeforeEach
    void setUp() {
        teamMemberRepository = new TeamMemberRepository();
    }

    @Test
    void testCreateTeamMember() {
        TeamMember teamMember = teamMemberRepository.createTeamMember("João Gomes");
        assertNotNull(teamMember);
        assertEquals("João Gomes", teamMember.getName());
    }

    @Test
    void testGetTeamMemberById() {
        TeamMember teamMember = teamMemberRepository.createTeamMember("João Gomes");
        TeamMember fetchedTeamMember = teamMemberRepository.getTeamMemberById(teamMember.getId());
        assertEquals(teamMember, fetchedTeamMember);
    }

    @Test
    void testDeleteTeamMember() {
        TeamMember teamMember = teamMemberRepository.createTeamMember("João Gomes");
        teamMemberRepository.deleteTeamMember(teamMember.getId());
        assertNull(teamMemberRepository.getTeamMemberById(teamMember.getId()));
    }
}
