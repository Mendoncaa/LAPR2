package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.repository.application.controller.checkup.CreateCheckUpController;

import java.util.Scanner;

public class CreateCheckUpUI {
    private CreateCheckUpController controller;
    private Scanner scanner;

    public CreateCheckUpUI(CreateCheckUpController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Please, enter the check-up details:");
        System.out.print("Vehicle Plate ID: ");
        String plateID = scanner.nextLine();
        System.out.print("Schedule Date (YYYY-MM-DD): ");
        String scheduleDate = scanner.nextLine();
        System.out.print("Current Kms: ");
        int currentKms = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean success = controller.createCheckUp(plateID, scheduleDate, currentKms);

        if (success) {
            System.out.println("Check-up created successfully!");
        } else {
            System.out.println("Failed to create the check-up. Please try again.");
        }
    }
}
