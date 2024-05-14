package pt.ipp.isep.dei.esoft.project.repository.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.service.TeamService;
import java.util.List;

/**
 * GenerateTeamController class serves as a controller for generating teams and managing team-related operations.
 * It interacts with the TeamService to perform team-related functionalities.
 */
public class GenerateTeamController {


    private final TeamService teamService = new TeamService();




    /**
     * Generates a team based on the provided parameters.
     *
     * @param minSize The minimum size of the team.
     * @param maxSize The maximum size of the team.
     * @param skills  The list of skills required for the team members.
     * @return The generated team.
     */
    public Team getGenerateTeam(int minSize, int maxSize, List<Skill> skills) {

        return teamService.generateTeam(minSize, maxSize, skills);

    }


    /**
     * Retrieves a skill chosen by the user based on the provided option.
     *
     * @param option The option selected by the user.
     * @return The chosen skill.
     */
    public Skill getChooseSkill(int option) {

        return teamService.chooseSkill(option);

    }


    /**
     * Approves a team.
     *
     * @param team The team to be approved.
     */
    public void getTeamApproved(Team team) {

        teamService.teamApproved(team);

    }

}
