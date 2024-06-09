package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

import java.util.*;

/**
 * Repository class for managing team members.
 */
public class TeamMemberRepository {
    private List<TeamMember> teamMembers;

/**
 * Constructor for TeamMemberRepository.
 * Initializes the list of team members.
 */
    public TeamMemberRepository() {
        this.teamMembers = new ArrayList<>();
    }


/**
 * Retrieves a team member by their unique ID.
 *
 * @param id The unique ID of the team member.
 * @return The team member with the specified ID, or null if no such team member exists.
 */
    public TeamMember getTeamMemberById(String id) {
        for (TeamMember teamMember : teamMembers) {
            if (teamMember.getId().equals(id)) {
                return teamMember;
            }
        }
        return null;
    }

/**
 * Creates a new team member with the specified name and adds them to the repository.
 *
 * @param name The name of the new team member.
 * @return The created team member.
 */
    public TeamMember createTeamMember(String name) {
        TeamMember teamMember = new TeamMember(name);
        addTeamMember(teamMember);
        return teamMember;
    }


    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }

/**
 * Deletes a team member by their unique ID.
 *
 * @param id The unique ID of the team member to be deleted.
 */
    public void deleteTeamMember(String id) {
        TeamMember teamMember = getTeamMemberById(id);
        if (teamMember != null) {
            teamMembers.remove(teamMember);
        }
    }

/**
 * Finds a team member with the specified skill in a given list of team members.
 * If no team member with the skill is found, or if the team member is not in any team, returns null.
 *
 * @param skill The skill to search for.
 * @param team The list of team members to search in.
 * @return The first team member with the specified skill, or null if no such team member exists.
 */
    public Employee findTeamMemberWithSkill(Skill skill, List<Employee> team) {


        for (Employee employee : team) {

            if (employee.getSkills().contains(skill) || !isInAnyTeam(employee)) {

                return employee;

            }

        }

        return null;

    }

/**
 * Checks if a team member is part of any team.
 *
 * @param employee The team member to check.
 * @return True if the team member is in any team, false otherwise.
 */
    public boolean isInAnyTeam(Employee employee) {

        TeamRepository teamRepository = Repositories.getInstance().getTeamRepository();


        for (Team team : teamRepository.getTeams()) {

            if (team.getTeamMembers().contains(employee)) {

                return true;

            }
        }

        return false;

    }


    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }
}
