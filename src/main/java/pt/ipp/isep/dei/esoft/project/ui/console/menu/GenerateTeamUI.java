package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateTeamUI {

    private static GenerateTeamController generateTeamController = new GenerateTeamController();
    private final Scanner scan = new Scanner(System.in);

    public GenerateTeamUI(GenerateTeamController generateTeamController) {

        this.generateTeamController = generateTeamController;

    }


    public void run() {

        int min = Utils.readIntegerFromConsole("Min team size: ");
        int max = Utils.readIntegerFromConsole("Max team size: ");
        int numSkills = Utils.readIntegerFromConsole("Num skills: ");

        ArrayList<Skill> skills = new ArrayList<>();

        for (int i = 0; i < numSkills; i++) {

            skills.add(generateTeamController.getChooseSkill());

        }

        Team team = generateTeamController.getGenerateTeam(min, max, skills);

        System.out.println(team);

        System.out.println("  1 - Accept Team");
        System.out.println("  2 - Reject Team");

        int option;

        do {

            option = scan.nextInt();

        } while (option < 1 || option > 2);


        if (option == 1) {

            

        } else {



        }

    }





}