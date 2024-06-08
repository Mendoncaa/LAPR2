package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Urgency;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ToDoListUI implements Runnable {
    private final Scanner scan = new Scanner(System.in);
    private final ToDoListController controller;

    public ToDoListUI() {
        controller = new ToDoListController();
    }

    private ToDoListController getController() {
        return controller;
    }

    @Override
    public void run() {
        String title = Utils.readLineFromConsole("Task title: ");
        String description = Utils.readLineFromConsole("Description: ");
        System.out.println("Expected duration: ");
        int days = Utils.readIntegerFromConsole("  -> Days: ");
        int hours = Utils.readIntegerFromConsole("  -> Hours: ");

        Duration duration = Duration.ofDays(days).plusHours(hours);

        List<GreenSpace> options = controller.getAvailableGreenSpaces();
        int option;

        GreenSpace greenSpace = null;
        
        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- YOUR GREEN SPACES -------------------------");

            if (option == -1) {
                return;
            }
            
            if ((option >= 0) && (option < options.size())) {

                 greenSpace = options.get(option);

            }

        } while (option < 0 || option > options.size());

        Urgency urgency = null;

        do {

            System.out.println("  1 - Low");
            System.out.println("  2 - Medium");
            System.out.println("  3 - High");
            System.out.println("  0 - Cancel");
            option = scan.nextInt();

            if (option == -1) {
                return;
            }

            if (option >= 0 && option < 4) {

               urgency = Urgency.getByIndex(option-1);

            }

        } while (option < 0 || option > 4);

        Task task = new Task(title, greenSpace, description, urgency, duration);

        System.out.println(task);

        String confirmation = Utils.readLineFromConsole("Are you sure you want to add this task to the To-Do List? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(title, description, greenSpace, urgency, duration);
        } else {
            System.out.println("Operation canceled by the user.");
        }

    }

    private void submitData(String title, String description, GreenSpace greenSpace,
                            Urgency urgency, Duration duration) {
        try {
            Optional<Task> task = getController().addNewTask(title, description, greenSpace, urgency, duration);
            if (task.isPresent()) {
                System.out.println("\nA new task has been successfully created!");
            } else {
                System.out.println("\nTask not created!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while creating the task: " + e.getMessage());
        }
    }

}
