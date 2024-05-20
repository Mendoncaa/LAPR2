package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateTeamUI implements Runnable {

    private static GenerateTeamController generateTeamController = new GenerateTeamController();
    private static SkillRepository skillRepository = new SkillRepository();
    private final Scanner scan = new Scanner(System.in);


    public void run() {

        boolean sucess = false; // validates the acceptance of the HRM


        do {


            int min = Utils.readIntegerFromConsole("Min team size: ");
            int max = Utils.readIntegerFromConsole("Max team size: ");

            ArrayList<Skill> skills = new ArrayList<>();

            while(true) {

                int option = Utils.showAndSelectIndex(skillRepository.getSkills(), "\n\n--- SKILLS -------------------------");


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