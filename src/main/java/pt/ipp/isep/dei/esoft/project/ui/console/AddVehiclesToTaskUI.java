package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.AddVehiclesToTaskController;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console-based UI for adding vehicles to a task.
 */
public class AddVehiclesToTaskUI implements Runnable {
    private final AddVehiclesToTaskController controller;

    /**
     * Constructs the UI with the corresponding controller.
     */
    public AddVehiclesToTaskUI() {
        this.controller = new AddVehiclesToTaskController();
    }

    /**
     * Runs the UI.
     */
    public void run() {
        System.out.println("\n\n--- Add Vehicles to Task ------------------------");

        try {
            List<Task> tasks = controller.listThisGsmTasksInAgenda();
            Task selectedTask = selectTask(tasks);
            if (selectedTask != null) {
                List<Vehicle> vehicles = controller.listVehiclesNotAssignedByDateOfTasks(selectedTask);
                List<Vehicle> selectedVehicles = selectVehicles(vehicles);
                if (!selectedVehicles.isEmpty()) {
                    System.out.println("\nSelected Task: " + selectedTask);
                    System.out.println("Selected Vehicles: " + selectedVehicles);
                    boolean success = controller.updateTaskVehicles(selectedTask, selectedVehicles);
                    if (success) System.out.println("\nVehicles added to task successfully!");
                } else {
                    System.out.println("\nNo vehicles selected. Task update cancelled.");
                }
            } else {
                System.out.println("\nTask selection cancelled.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding vehicles to the task: " + e.getMessage());
        }
    }

    /**
     * Allows the user to select a task from a list.
     *
     * @param tasks The list of tasks to choose from.
     * @return The selected task.
     */
    private Task selectTask(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available in the agenda.");
            return null;
        }

        System.out.println("Tasks in agenda:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a task index: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            return tasks.get(taskIndex);
        } else {
            System.out.println("Invalid task index.");
            return null;
        }
    }

    /**
     * Allows the user to select vehicles from a list.
     *
     * @param vehicles The list of vehicles to choose from.
     * @return The list of selected vehicles.
     */
    private List<Vehicle> selectVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return new ArrayList<>();
        }

        System.out.println("Available vehicles:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(i + ": " + vehicles.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select vehicles by index (comma separated): ");
        String[] vehicleIndices = scanner.nextLine().split(",");

        List<Vehicle> selectedVehicles = new ArrayList<>();
        for (String index : vehicleIndices) {
            int vehicleIndex = Integer.parseInt(index.trim());
            if (vehicleIndex >= 0 && vehicleIndex < vehicles.size()) {
                selectedVehicles.add(vehicles.get(vehicleIndex));
            } else {
                System.out.println("Invalid vehicle index: " + vehicleIndex);
            }
        }

        return selectedVehicles;
    }
}



