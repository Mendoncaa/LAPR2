package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import java.util.ArrayList;
import java.util.List;


public class TeamRepository {

    private List<Team> teams;

    public TeamRepository() {
        this.teams = new ArrayList<>();
    }


    public Team createTeam(int minSize, int maxSize, List<Skill> skills, List<TeamMember> teamMembers) {

        Team team = new Team(minSize, maxSize, skills, teamMembers);

        teams.add(team);

        return team;

    }


    public List<Team> getTeams() {
        return teams;
    }
}
