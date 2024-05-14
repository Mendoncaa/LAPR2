package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * HRMUI class represents the user interface for Human Resource Management (HRM) functionalities.
 * It provides a menu-driven interface to interact with different HRM functionalities of the system.
 */
public class HRMUI implements Runnable {

    /**
     * Constructs a new HRMUI object.
     */
    public HRMUI() {
    }

    /**
     * Runs the HRMUI, displaying a menu of options and executing the selected option.
     */   public void run() {
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