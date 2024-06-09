package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.RegisterGSController;
import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Optional;
import java.util.Scanner;

/**
 * Represents the user interface for registering a green space.
 */
public class RegisterGSUI implements Runnable {
    private static GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    private static EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private static RegisterGSController registerGSController = new RegisterGSController();

    private final RegisterGSController controller;

    /**
     * Constructs a RegisterGSUI object.
     */
    public RegisterGSUI() {
        controller = new RegisterGSController();
    }


    /**
     * Retrieves the RegisterGSController.
     *
     * @return the RegisterGSController.
     */
    private RegisterGSController getController() {
        return controller;
    }


    private final Scanner scan = new Scanner(System.in);

    /**
     * Runs the green space registration user interface.
     */
    public void run() {

        String name = Utils.readLineFromConsole("Name: ");

        int option = 0;

        SizeClassification sizeClassification;

        do {

            System.out.println("Choose the size classification:");
            System.out.println("1 - Garden");
            System.out.println("2 - Medium-sized park");
            System.out.println("3 - Large-sized park");
            System.out.print("Type your option: ");

            option = scan.nextInt();

            sizeClassification = SizeClassification.getByIndex(option-1);

        } while (option < 0 || option > 3);


        double area = Utils.readDoubleFromConsole("Area(m2): ");
        String address = Utils.readLineFromConsole("Address: ");

        System.out.println("Name: " +  name);
        System.out.println("Size Classification: " + sizeClassification);
        System.out.println("Area: " + area);
        System.out.println("Address: " + address);

        String confirmation = Utils.readLineFromConsole("Are you sure you want to register this green space? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(name, sizeClassification, area, address);
        } else {
            System.out.println("Operation canceled by the user.");
        }
    }

    /**
     * Submits the green space registration data.
     *
     * @param name              the name of the green space.
     * @param sizeClassification the size classification of the green space.
     * @param area              the area of the green space.
     * @param address           the address of the green space.
     */
    private void submitData(String name, SizeClassification sizeClassification, double area, String address) {
        try {
            Optional<GreenSpace> greenSpace = getController().RegisterGreenSpace(name, sizeClassification, area, address);;
            if (greenSpace.isPresent()) {
                System.out.println("\nA new green space has been successfully created!");
            } else {
                System.out.println("\nGreen space not created!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while creating the green space: " + e.getMessage());
        }
    }

}
