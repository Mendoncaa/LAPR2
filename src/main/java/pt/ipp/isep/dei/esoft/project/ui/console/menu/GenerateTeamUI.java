package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class GenerateTeamUI implements Runnable {

    private static GenerateTeamController ctrl;

    public GenerateTeamUI() {
        ctrl = new GenerateTeamController();
    }

    public void run() {
        int min = Utils.readIntegerFromConsole("Min team size: ");
        int max = Utils.readIntegerFromConsole("Max team size: ");
        // need the skills created
    }

}
