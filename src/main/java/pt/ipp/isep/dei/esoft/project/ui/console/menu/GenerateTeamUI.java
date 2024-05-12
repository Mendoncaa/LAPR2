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


    public void run() {

        boolean sucess = false; // validates the acceptance of the HRM


        do {


            int min = Utils.readIntegerFromConsole("Min team size: ");
            int max = Utils.readIntegerFromConsole("Max team size: ");

            ArrayList<Skill> skills = new ArrayList<>();

            while(true) {
                int option = Utils.showAndSelectIndex(skills, "\n\n--- SKILLS -------------------------");


                if (generateTeamController.getChooseSkill(option) == null) {

                    break;

                }

                skills.add(generateTeamController.getChooseSkill(option));

            }

            Team team = generateTeamController.getGenerateTeam(min, max, skills);

            if (team.getTeamMembers().size() < min) {

                System.out.println("  No employees available to join the team for now!!!");
                continue;

            }


            System.out.println(team);

            System.out.println("  1 - Accept Team");
            System.out.println("  2 - Reject Team");

            int option;

            do {

                option = scan.nextInt();

            } while (option < 1 || option > 2);


            if (option == 1) {

                sucess = true;

                generateTeamController.getTeamApproved(team);

            }

        } while (!sucess);

    }
}