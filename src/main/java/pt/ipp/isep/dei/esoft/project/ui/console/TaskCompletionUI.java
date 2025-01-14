package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.TaskCompletionController;
import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents the user interface for completing tasks.
 */
public class TaskCompletionUI implements Runnable {

    private final TaskCompletionController controller;

    /**
     * Constructs a TaskCompletionUI object.
     */
    public TaskCompletionUI() {
        controller = new TaskCompletionController();
    }

    /**
     * Retrieves the TaskCompletionController.
     *
     * @return the TaskCompletionController.
     */
    private TaskCompletionController getController() {
        return controller;
    }


    /**
     * Runs the task completion user interface.
     */
    @Override
    public void run() {

        List<Task> options = getController().getTasksByManagedMe();

        if (options == null) {
            throw new IllegalArgumentException("You have no tasks!!");
        }

        int option;

        Task task = null;

        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- YOUR TASKS -------------------------");

            if (option == -1) {
                return;
            }

            if ((option >= 0) && (option < options.size())) {

                task = options.get(option);

            }

        } while (option < 0 || option > options.size());

        System.out.println(task);

        String confirmation = Utils.readLineFromConsole("Are you sure you want to record the completion of this task? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(task);
        } else {
            System.out.println("Operation canceled by the user.");
        }

    }


    private void submitData(Task task) {
        try {
            getController().completeTask(task);
            if (task.getStatus().equals(Status.DONE)) {
                System.out.println("\nThe task has been successfully recorded has completed!");
            } else {
                System.out.println("\nTask not recorded as completed!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while recording the completion of the task: " + e.getMessage());
        }
    }

}
