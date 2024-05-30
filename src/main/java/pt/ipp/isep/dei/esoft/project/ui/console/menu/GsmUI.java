package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.ListVehiclesCheckupUI;
import pt.ipp.isep.dei.esoft.project.ui.console.RegisterGSUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GsmUI implements Runnable {

    public GsmUI() {
    }


    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register a green space", new RegisterGSUI()));

        int option = 0;

        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- VFM MENU --------------------------");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }

        } while (option != -1);

    }
}
