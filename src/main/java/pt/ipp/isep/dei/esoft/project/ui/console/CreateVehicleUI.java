package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateVehicleController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

public class CreateVehicleUI implements Runnable {
    private CreateVehicleController controller;
    private String name;
    private Scanner scan = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private VehicleRepository vehicleRepository = Repositories.getInstance().getVehicleRepository();

    public CreateVehicleUI() {
        controller = new CreateVehicleController();
    }
    private CreateVehicleController getController() {
        return controller;
    }

    public void run() {

        System.out.println("\n\n--- Create Vehicle -----------------------");


        try {
            String plateID = Utils.readLineFromConsole("Plate ID: ");
            String brand = Utils.readLineFromConsole("Brand: ");
            String model = Utils.readLineFromConsole("Model: ");
            String type = Utils.readLineFromConsole("Type: ");
            double tareWeight = Utils.readDoubleFromConsole("Tare weight: ");
            double grossWeight = Utils.readDoubleFromConsole("Gross weight: ");
            int currentKM = Utils.readIntegerFromConsole("Current kms: ");


            LocalDate registerDate = readDateFromConsole(scan, formatter, "Register date (DD-MM-YYYY): ");
            LocalDate acquisitionDate = readDateFromConsole(scan, formatter, "Acquisition date (DD-MM-YYYY): ");
            int checkupKM = Utils.readIntegerFromConsole("Checkup frequency(kms): ");

            Vehicle vehicle = new Vehicle(plateID, brand, model, type, tareWeight, grossWeight, currentKM,
                    registerDate, acquisitionDate, checkupKM);

            System.out.println(vehicle);
            System.out.print("Are you sure you want to create this vehicle? (Y/N): ");
            String confirmation = scan.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                submitData(vehicle);
            } else {
                System.out.println("Operation canceled by the user.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred while creating the vehicle: " + e.getMessage());
        }

    }

    private void submitData(Vehicle vehicle) {
        try {
            Optional<Vehicle> vehicle1 = getController().createVehicle(vehicle);
            if (vehicle1.isPresent()) {
                System.out.println("\nVehicle successfully created!");
            } else {
                System.out.println("\nVehicle not created!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while creating the vehicle: " + e.getMessage());
        }
    }

    private static LocalDate readDateFromConsole(Scanner scanner, DateTimeFormatter formatter, String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                date = LocalDate.parse(dateString, formatter);

                if (date.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException("Invalid data input. The day must be in the future.");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in DD-MM-YYYY format.");
            }
        }
        return date;
    }
}