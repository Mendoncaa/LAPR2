package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.controller.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GenerateTeamUI implements Runnable {

    private final GenerateTeamController controller;

    public GenerateTeamUI() {
        controller = new GenerateTeamController();
    }

    private GenerateTeamController getController() {
        return controller;
    }
    private SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
    private final Scanner scan = new Scanner(System.in);


    public void run() {

        boolean sucess = false; // validates the acceptance of the HRM


        do {


            int min = Utils.readIntegerFromConsole("Min team size: ");
            int max = Utils.readIntegerFromConsole("Max team size: ");

            ArrayList<Skill> skills = new ArrayList<>();

            while(true) {

                int option = Utils.showAndSelectIndex(skillRepository.getSkills(), "\n\n--- SKILLS -------------------------");


                if (controller.getChooseSkill(option) == null) {

                    break;

                }

                skills.add(controller.getChooseSkill(option));

            }

            Team team = controller.getGenerateTeam(min, max, skills);


            if (team.getTeamMembers() == null) {

                System.out.println("  No team has been generated!!!");
                break;

            } else if (team.getTeamMembers().size() < min) {

                System.out.println("  No employees available to join the team for now!!!");
                break;

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

                controller.getTeamApproved(team);

            }

        } while (!sucess);

    }

}