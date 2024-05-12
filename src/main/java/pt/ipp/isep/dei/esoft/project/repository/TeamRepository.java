package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository {

    private List<Team> team;

    public TeamRepository() {
        this.team = new ArrayList<>();
    }

    /*public TeamMember getTeamById(String id) {
        for (Team team : team) {
            if (team.getId().equals(id)) {
                return team;
            }
        }
        return null;
    }

    public TeamMember createTeamMember(String name) {
        TeamMember teamMember = new TeamMember(name);
        team.add(teamMember);
        return teamMember;
    }

    public void deleteTeamMember(String id) {
        TeamMember teamMember = getTeamMemberById(id);
        if (teamMember != null) {
            teamMembers.remove(teamMember);
        }
    }*/


    public List<TeamMember> findTeamMemberWithSkill(Skill skill, Team team) {

        List<TeamMember> teamMembers = team.getTeamMembers();

        for (TeamMember teamMember : teamMembers) {

            if (teamMember.getSkills().contains(skill) || !teamMembers.contains(teamMember)) {

                teamMembers.add(teamMember);

            }

        }

        return teamMembers;

    }


}
