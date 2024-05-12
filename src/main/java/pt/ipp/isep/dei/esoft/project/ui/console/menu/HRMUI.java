package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HRMUI implements Runnable {

    public HRMUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Generate a team", new GenerateTeamUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- HRM MENU --------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }

        } while (option != -1);
    }

}