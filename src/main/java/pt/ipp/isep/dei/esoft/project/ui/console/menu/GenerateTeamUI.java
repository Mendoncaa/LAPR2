package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.VFMController;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization.HRMController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeamUI {

    private static GenerateTeamController generateTeamController = new GenerateTeamController();
    SkillRepository skillRepository = new SkillRepository();


    public GenerateTeamUI(GenerateTeamController generateTeamController) {

        this.generateTeamController = generateTeamController;

    }


    public void run() {

        int min = Utils.readIntegerFromConsole("Min team size: ");
        int max = Utils.readIntegerFromConsole("Max team size: ");
        int numSkills = Utils.readIntegerFromConsole("Num skills: ");

        ArrayList<Skill> skills = new ArrayList<>();

        for (int i = 0; i < numSkills; i++) {

            skills.add(chooseSkill(numSkills));

        }

        generateTeamController.initialize(min, max, skills);

    }


    public Skill chooseSkill(int numSkills) {

        List<Skill> skills = skillRepository.getSkills();

        int option = 0;
        do {
            Utils.showAndSelectIndex(skills, "\n\n--- SKILLS -------------------------");

            if ((option >= 0) && (option < skills.size())) {

                return skills.get(option);

            }

        } while (option != -1);

        return null;

    }

}