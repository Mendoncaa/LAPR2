package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.repository.application.controller.VFMController;
import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class VFMUI {

    private VFMController vfmController;

    public VFMUI() {
        this.vfmController = new VFMController();
    }

    public void run() {
        List<String> options = new ArrayList<String>();
        options.add("List vehicles needing checkup");
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\n--- VFM MENU --------------------------");

            if ((option >= 0) && (option < options.size())) {

                if (option == 0) {

                    initiateCheckUp();

                }

            }
        } while (option != -1);
    }


    public void initiateCheckUp() {
        VFMController vfmController = new VFMController();
    }

}

