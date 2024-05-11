package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeamUI implements Runnable {

    private static GenerateTeamController ctrl;

    public GenerateTeamUI() {
        ctrl = new GenerateTeamController();
    }

    public void run() {
        int min = Utils.readIntegerFromConsole("Min team size: ");
        int max = Utils.readIntegerFromConsole("Max team size: ");
        int skills = Utils.readIntegerFromConsole("Num skills: ");

        for (int i = 0; i < skills; i++) {

        }


        List<String> approval = new ArrayList<String>();
        approval.add("Yes");
        approval.add("No");

        int option;

        do {

            option = Utils.showAndSelectIndex(approval, "\n\n--- HRM MENU -------------------------");

            if (option == 0) {
                System.out.println("Yes test");
            }

            System.out.println("No test");

        } while (option != -1);
    }

}
