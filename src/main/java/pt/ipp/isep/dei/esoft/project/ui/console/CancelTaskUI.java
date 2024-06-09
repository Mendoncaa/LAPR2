package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.CancelTaskController;
import pt.ipp.isep.dei.esoft.project.controller.PostponeController;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class CancelTaskUI implements Runnable {

    private final CancelTaskController controller;

    public CancelTaskUI() {
        controller = new CancelTaskController();
    }

    private CancelTaskController getController() {
        return controller;
    }

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


    private void submitData(Task task) {
        try {
            getController().cancelTask(task);
            if (task.getStatus().equals(Status.CANCELED)) {
                System.out.println("\nThe task has been successfully cancelled!");
            } else {
                System.out.println("\nTask not canceled!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while cancelling the task: " + e.getMessage());
        }
    }
}
