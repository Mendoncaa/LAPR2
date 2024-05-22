package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.controller.ListVehiclesCheckupController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * ListVehiclesCheckupUI class represents the user interface for listing vehicles needing checkup.
 * It interacts with the ListVehiclesCheckupController to perform the necessary operations.
 */
public class ListVehiclesCheckupUI implements Runnable {

    private ListVehiclesCheckupController listVehiclesCheckupController;


    /**
     * Constructs a new ListVehiclesCheckupUI object.
     */
    public ListVehiclesCheckupUI() {
        this.listVehiclesCheckupController = new ListVehiclesCheckupController();
    }


    /**
     * Runs the ListVehiclesCheckupUI, displaying a menu of options and executing the selected option.
     */
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

    /**
     * Initiates the checkup process for vehicles needing checkup.
     * Retrieves the list of vehicles needing checkup and prints their details.
     */
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

