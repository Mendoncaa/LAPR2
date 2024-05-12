package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.service.TeamService;
import pt.ipp.isep.dei.esoft.project.repository.TeamMemberRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamServiceTest {

    @Test
    public void testTeamRepositoryIsNotEmptyAfterCreation() {
        TeamService teamService = new TeamService();
        TeamRepository teamRepository = new TeamRepository();

        TeamMember member1 = new TeamMember("John");
        TeamMember member2 = new TeamMember("Alice");

        member1.addSkill(new Skill("Python"));
        member2.addSkill(new Skill("Java"));

        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Python"));
        skills.add(new Skill("Java"));

        List<TeamMember> teamMembers = new ArrayList<>();
        teamMembers.add(member1);
        teamMembers.add(member2);

        teamService.teamApproved(new Team(2, 4, skills, teamMembers));

        assertFalse(teamRepository.getTeams().isEmpty());
    }


    @Test
    public void testIsInAnyTeam_ReturnsTrueWhenMemberIsInTeam() {

        List<TeamMember> members = new ArrayList<>();
        TeamMember teamMember = new TeamMember("John");
        members.add(teamMember);
        Team team = new Team(3, 5, new ArrayList<>(), members);


        TeamRepository teamRepository = new TeamRepository();
        teamRepository.createTeam(team.getMinSize(), team.getMaxSize(), team.getSkills(), team.getTeamMembers());


        TeamMemberRepository teamMemberRepository = new TeamMemberRepository();
        boolean isInTeam = teamMemberRepository.isInAnyTeam(teamMember);


        assertTrue(isInTeam);
        
    }


}
