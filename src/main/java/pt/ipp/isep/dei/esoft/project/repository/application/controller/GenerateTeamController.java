package pt.ipp.isep.dei.esoft.project.repository.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.service.TeamService;


import java.util.List;

public class GenerateTeamController {


    private final TeamService teamService = new TeamService();





    public Team getGenerateTeam(int minSize, int maxSize, List<Skill> skills) {

        return teamService.generateTeam(minSize, maxSize, skills);

    }

    public Skill getChooseSkill() {

        return teamService.chooseSkill();

    }

}
