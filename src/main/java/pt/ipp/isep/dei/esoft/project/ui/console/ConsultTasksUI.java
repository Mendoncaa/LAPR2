package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.ConsultTasksController;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.ReadDate;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ConsultTasksUI implements Runnable, ReadDate {
    private final Scanner scan = new Scanner(System.in);
    private final ConsultTasksController controller;

    public ConsultTasksUI() {
        controller = new ConsultTasksController();
    }

    private ConsultTasksController getController() {
        return controller;
    }

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    @Override
    public void run() {
        System.out.println("  Insert the starting and ending dates to make a search!!");
        LocalDate startDate = readDateFromConsole(scan, formatter, "Start Date(DD-MM-YYYY): ");
        LocalDate endDate = readDateFromConsole(scan, formatter, "End Date(DD-MM-YYYY): ");

        List<Status> options = Arrays.asList(Status.values());

        int option = 0;

        Status status = null;

        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- EXISTING STATUS -------------------------");

            if (option == -1) {
                return;
            }

            if ((option >= 0) && (option < options.size())) {
                status = options.get(option);
            }

        } while (option < 0 || option > options.size());

        System.out.println("Start date: " + startDate);
        System.out.println("End date: " + endDate);
        System.out.println("Status: " + status);

        String confirmation = Utils.readLineFromConsole("Proceed? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            printTasks(startDate, endDate, status);
        } else {
            System.out.println("Operation canceled by the user.");
        }

    }


    private void printTasks(LocalDate startDate, LocalDate endDate, Status status) {
        List<Task> tasks = getController().consultTasks(startDate, endDate, status);

        if (tasks == null) {
            throw new IllegalArgumentException("There are no tasks matching those conditions!!");
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    @Override
    public LocalDate readDateFromConsole(Scanner scanner, DateTimeFormatter formatter, String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                date = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in DD-MM-YYYY format.");
            }
        }
        return date;
    }
}
