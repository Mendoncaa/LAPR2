package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.CreateJobController;
import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class ToDoListUI implements Runnable {

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

        List<GreenSpace> options = controller.getAvailabreGreenSpaces();
        int option;

        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- YOUR GREEN SPACES -------------------------");

            if ((option >= 0) && (option < options.size())) {

                GreenSpace greenSpace = options.get(option-1);

            }

        } while (option != -1);

    }

}
