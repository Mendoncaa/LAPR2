package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

import java.util.*;

public class TeamMemberRepository {
    private List<TeamMember> teamMembers;

    public TeamMemberRepository() {
        this.teamMembers = new ArrayList<>();
    }

    public TeamMember getTeamMemberById(String id) {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId().equals(id)) {
                return teamMember;
            }
        }
        return null;
    }


    public TeamMember createTeamMember(String name) {
        TeamMember teamMember = new TeamMember(name);
        teamMembers.add(teamMember);
        return teamMember;
    }


    public void deleteTeamMember(String id) {
        TeamMember teamMember = getTeamMemberById(id);
        if (teamMember != null) {
            teamMembers.remove(teamMember);
        }
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

        TeamRepository teamRepository = Repositories.getInstance().getTeamRepository();


        for (Team team : teamRepository.getTeams()) {

            if (team.getTeamMembers().contains(teamMember)) {

                return true;

            }
        }

        return false;

    }


}
