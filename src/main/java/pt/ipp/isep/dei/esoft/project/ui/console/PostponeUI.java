package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.PostponeController;
import pt.ipp.isep.dei.esoft.project.controller.TaskCompletionController;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;
/**
 * This class represents the UI for postponing a task.
 * It implements the Runnable interface to allow its instances to be executed by a thread.
 */
public class PostponeUI implements Runnable {
    private final PostponeController controller;
    /**
     * Constructs an instance of PostponeUI and initializes the controller.
     */
    public PostponeUI() {
        controller = new PostponeController();
    }
    /**
     * Gets the controller.
     *
     * @return the controller
     */
    private PostponeController getController() {
        return controller;
    }
    /**
     * Runs the UI process to postpone a task.
     * It interacts with the user to select a task and confirm the postponement.
     */
    @Override
    public void run() {

        List<Task> options = getController().getTasks();

        if (options == null) {
            throw new IllegalArgumentException("You have no tasks in the agenda!!");
        }

        int option;

        Task task = null;

        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- YOUR AGENDA -------------------------");

            if (option == -1) {
                return;
            }

            if ((option >= 0) && (option < options.size())) {

                task = options.get(option);

            }

        } while (option < 0 || option > options.size());

        System.out.println(task);

        String confirmation = Utils.readLineFromConsole("Are you sure you want to cancel this task? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(task);
        } else {
            System.out.println("Operation canceled by the user.");
        }

    }

    /**
     * Submits the task data for postponement.
     *
     * @param task the task to be postponed
     */
    private void submitData(Task task) {
        try {
            getController().postponeTask(task);
            if (task.getStatus().equals(Status.POSTPONED)) {
                System.out.println("\nThe task has been successfully postponed!");
            } else {
                System.out.println("\nTask not postponed!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while postponing the task: " + e.getMessage());
        }
    }
}
