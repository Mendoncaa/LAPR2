package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.AddVehiclesToTaskController;
import pt.ipp.isep.dei.esoft.project.controller.ListGSManagedByMeController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;
import java.util.Scanner;

/**
 * Displays a list of available sorting algorithms and prompts the user to choose one.
 * Sorts and lists the green spaces according to the selected algorithm.
 */
public class ListGSManagedByMeUI implements Runnable {
    private final ListGSManagedByMeController controller;


    /**
     * Constructs the UI with the corresponding controller and green spaces.
     */
    public ListGSManagedByMeUI() {
        this.controller = new ListGSManagedByMeController();
    }

    /**
     * Runs the UI.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- List GreenSpaces Managed sorted by area ------------------------");

        Scanner scanner = new Scanner(System.in);

        // Display available sorting algorithms
        List<String> availableAlgorithms = controller.getAvailableSortingAlgorithms();
        System.out.println("Available sorting algorithms:");
        for (int i = 0; i < availableAlgorithms.size(); i++) {
            System.out.println((i + 1) + ": " + availableAlgorithms.get(i));
        }

        // Prompt user to choose a sorting algorithm
        System.out.println("Choose sorting algorithm:");
        int algorithmIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (algorithmIndex < 1 || algorithmIndex > availableAlgorithms.size()) {
            System.out.println("Invalid algorithm index.");
            return;
        }

        String algorithmName = availableAlgorithms.get(algorithmIndex - 1);

        // Logic to list and sort the green spaces
        List<GreenSpace> sortedGreenSpaces = controller.sortGreenSpaces(algorithmName);

        // List the sorted green spaces
        System.out.println("\nSorted Green Spaces:");
        for ( GreenSpace gs : sortedGreenSpaces ) {
            System.out.println(gs.toString());
        }
    }
}




