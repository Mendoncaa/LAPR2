package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.ListVehiclesCheckupController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListVehiclesCheckupUI {

    private ListVehiclesCheckupController listVehiclesCheckupController;

    public ListVehiclesCheckupUI() {
        this.listVehiclesCheckupController = new ListVehiclesCheckupController();
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

        ListVehiclesCheckupController listVehiclesCheckupController = new ListVehiclesCheckupController();
        List<Vehicle> list = listVehiclesCheckupController.checkup();

        for (Vehicle vehicle : list) {

            System.out.printf("Plate -> %s", vehicle.getPlateID());
            System.out.printf("Brand -> %s", vehicle.getBrand());
            System.out.printf("Model -> %s", vehicle.getModel());
            System.out.printf("Curr. Kms -> %s", vehicle.getCurrentKms());
            System.out.printf("Freq -> %s", vehicle.getCheckUpFrequencyInKms());
            System.out.printf("Last -> %s", vehicle.calculateNextCheckup());
            System.out.printf("Next -> %s", vehicle.getCheckUpFrequencyInKms());

        }


    }

}

