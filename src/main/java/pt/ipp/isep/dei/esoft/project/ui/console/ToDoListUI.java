package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class ToDoListUI implements Runnable {


    @Override
    public void run() {
        String title = Utils.readLineFromConsole("Task title: ");
        String description = Utils.readLineFromConsole("Description: ");
        int expectedDuration = Utils.readIntegerFromConsole("Expected duration in days: ");


    }

}
