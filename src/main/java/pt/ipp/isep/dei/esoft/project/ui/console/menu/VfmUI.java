package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.ListVehiclesCheckupUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * VFMUI class represents the user interface for Vehicle and Equipment Fleet Management (VFM) system.
 * It provides a menu-driven interface to interact with different functionalities of the system.
 */
public class VfmUI implements Runnable {

    /**
     * Constructs a new VFMUI object.
     */
    public VfmUI() {
    }

    /**
     * Runs the VFMUI, displaying a menu of options and executing the selected option.
     */
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List vehicles needing checkup", new ListVehiclesCheckupUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- VFM MENU --------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }

        } while (option != -1);
    }

}
