package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TeamRepositoryTest {

    private TeamRepository teamRepository;

    @BeforeEach
    public void setUp() {
        teamRepository = new TeamRepository();
    }

    /*@Test
    public void testCreateTeam() {

        int minSize = 2;
        int maxSize = 5;
        List<Skill> skills = new ArrayList<>();
        List<TeamMember> teamMembers = new ArrayList<>();


        Team createdTeam = teamRepository.createTeam(minSize, maxSize, skills, teamMembers);


        assertNotNull(createdTeam);
        assertEquals(1, teamRepository.getTeams().size());
        assertEquals(minSize, createdTeam.getMinSize());
        assertEquals(maxSize, createdTeam.getMaxSize());
        assertEquals(skills, createdTeam.getSkills());
        assertEquals(teamMembers, createdTeam.getTeamMembers());

    }*/

    @Test
    public void testGetTeams() {

        Team team1 = new Team(3, 6, new ArrayList<>(), new ArrayList<>());
        Team team2 = new Team(2, 4, new ArrayList<>(), new ArrayList<>());

        teamRepository.getTeams().add(team1);
        teamRepository.getTeams().add(team2);


        List<Team> teams = teamRepository.getTeams();


        assertNotNull(teams);
        assertEquals(2, teams.size());
        assertTrue(teams.contains(team1));
        assertTrue(teams.contains(team2));
    }
}
