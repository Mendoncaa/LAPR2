package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateVehicleController;

import java.util.Scanner;

public class CreateVehicleUI {
    private CreateVehicleController controller;
    private Scanner scanner;

    public CreateVehicleUI(CreateVehicleController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Please, enter the vehicle details:");
        System.out.print("Plate ID: ");
        String plateID = scanner.nextLine();
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Tare: ");
        int tare = scanner.nextInt();
        System.out.print("Gross Weight: ");
        int grossWeight = scanner.nextInt();
        System.out.print("Current Kms: ");
        int currentKms = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Register Date (YYYY-MM-DD): ");
        String registerDate = scanner.nextLine();
        System.out.print("Acquisition Date (YYYY-MM-DD): ");
        String acquisitionDate = scanner.nextLine();
        System.out.print("Check-up Frequency in Kms: ");
        int checkUpFrequencyInKms = scanner.nextInt();

        boolean success = controller.createVehicle(plateID, brand, model, type, tare, grossWeight,
                currentKms, registerDate, acquisitionDate, checkUpFrequencyInKms);

        if (success) {
            System.out.println("Vehicle created successfully!");
        } else {
            System.out.println("Failed to create the vehicle. Please try again.");
        }
    }
}
