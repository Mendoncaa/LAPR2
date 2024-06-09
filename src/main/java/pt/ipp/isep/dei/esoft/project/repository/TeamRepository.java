package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TeamRepository {

    private List<Team> teams;

    public TeamRepository() {
        this.teams = new ArrayList<>();
    }


    public Optional<Team> createTeam(int minSize, int maxSize, List<Skill> skills, List<Employee> teamMembers) {

        Team team = new Team(minSize, maxSize, skills, teamMembers);

        addTeam(team);

        return Optional.of(team);

    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }
}
