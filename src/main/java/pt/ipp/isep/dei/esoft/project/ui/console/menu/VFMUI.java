package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.repository.application.controller.VFMController;

public class VFMUI {

    private VFMController vfmController;

    public VFMUI() {
        this.vfmController = new VFMController();
    }

    /* public void initiateCheckUp() {
        List<String> vehicles = vfmController.requestCheckUpListing();
        for (String vehicle : vehicles) {
            System.out.println(vehicle);
        }
    } */

}
