package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateCheckUpController;

import java.util.Scanner;
/**
 * This class represents the UI for creating a check-up.
 */
public class CreateCheckUpUI {
    private CreateCheckUpController controller;
    private Scanner scanner;
    /**
     * Constructs an instance of CreateCheckUpUI with the specified controller.
     *
     * @param controller the controller to be used by this UI
     */
    public CreateCheckUpUI(CreateCheckUpController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the UI process for creating a check-up.
     * It prompts the user to enter check-up details and attempts to create the check-up.
     */
    public void start() {
        System.out.println("Please, enter the check-up details:");
        System.out.print("Vehicle Plate ID: ");
        String plateID = scanner.nextLine();
        System.out.print("Schedule Date (YYYY-MM-DD): ");
        String scheduleDate = scanner.nextLine();
        System.out.print("Current Kms: ");
        int currentKms = scanner.nextInt();
        scanner.nextLine();

        boolean success = controller.createCheckUp(plateID, scheduleDate, currentKms);

        if (success) {
            System.out.println("Check-up created successfully!");
        } else {
            System.out.println("Failed to create the check-up. Please try again.");
        }
    }
}
