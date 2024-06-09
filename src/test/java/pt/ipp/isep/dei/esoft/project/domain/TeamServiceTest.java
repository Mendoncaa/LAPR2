package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.service.TeamService;
import pt.ipp.isep.dei.esoft.project.repository.TeamMemberRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamServiceTest {

    @Test
    public void testTeamRepositoryIsNotEmptyAfterCreation() {
        TeamService teamService = new TeamService();
        TeamRepository teamRepository = new TeamRepository();

        Employee employee1 = new Employee("John", LocalDate.of(1990, 2, 10),
                LocalDate.of(2020, 2, 10), "Rua da Rua", "London", "4470-045",
                "910145644", "john@this.app", "cc", "14563482", "123456789"
                , new Job("Trolha"));
        Employee employee2 = new Employee("Johnny", LocalDate.of(1990, 2, 10),
                LocalDate.of(2020, 2, 10), "Rua da Rua", "London", "4470-046",
                "910143644", "john@this.app", "cc", "14763482", "123456689"
                , new Job("Trolha"));

        employee1.addSkill(new Skill("Python"));
        employee2.addSkill(new Skill("Java"));

        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Python"));
        skills.add(new Skill("Java"));

        List<Employee> teamMembers = new ArrayList<>();
        teamMembers.add(employee1);
        teamMembers.add(employee2);

        teamService.teamApproved(new Team(2, 4, skills, teamMembers));

        assertFalse(teamRepository.getTeams().isEmpty());
    }


    @Test
    public void testIsInAnyTeam_ReturnsTrueWhenMemberIsInTeam() {

        List<Employee> members = new ArrayList<>();
        Employee employee = new Employee("John", LocalDate.of(1990, 2, 10),
                LocalDate.of(2020, 2, 10), "Rua da Rua", "London", "4470-045",
                "910145644", "john@this.app", "cc", "14563482", "123456789"
                , new Job("Trolha"));
        members.add(employee);
        Team team = new Team(3, 5, new ArrayList<>(), members);


        TeamRepository teamRepository = new TeamRepository();
        teamRepository.createTeam(team.getMinSize(), team.getMaxSize(), team.getSkills(), team.getTeamMembers());


        TeamMemberRepository teamMemberRepository = new TeamMemberRepository();
        boolean isInTeam = teamMemberRepository.isInAnyTeam(employee);


        assertTrue(isInTeam);

    }

}
