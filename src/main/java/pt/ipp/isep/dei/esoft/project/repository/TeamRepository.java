package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
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


    public Team createTeamMember(int minSize, int maxSize, List<Skill> skills, List<TeamMember> teamMembers) {

        Team team = new Team(minSize, maxSize, skills, teamMembers);

        teams.add(team);

        return team;

    }



    public TeamMember findTeamMemberWithSkill(Skill skill, List<TeamMember> team) {


        for (TeamMember teamMember : team) {

            if (teamMember.getSkills().contains(skill) || !isInAnyTeam(teamMember)) {

                return teamMember;

            }

        }

        return null;

    }

    public boolean isInAnyTeam(TeamMember teamMember) {


        for (Team team : teams) {

            if (team.getTeamMembers().contains(teamMember)) {

                return true;

            }
        }

        return false;

    }

}
