package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.authorization.AddAgendaEntryController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Urgency;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.ReadDate;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Represents the user interface for adding a task to the agenda.
 */
public class AddAgendaEntryUI implements Runnable, ReadDate {
    private final AddAgendaEntryController controller;

    /**
     * Constructs an AddAgendaEntryUI object.
     */
    public AddAgendaEntryUI() {
        controller = new AddAgendaEntryController();
    }

    /**
     * Retrieves the AddAgendaEntryController.
     *
     * @return the AddAgendaEntryController.
     */
    private AddAgendaEntryController getController() {
        return controller;
    }

    TaskRepository taskRepository = Repositories.getInstance().getTaskRepository();

    private Scanner scan = new Scanner(System.in);

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Runs the agenda entry user interface.
     */
    @Override
    public void run() {

        List<Task> options = controller.getPendingTasks();
        int option;

        Task task = null;

        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- PENDING TASKS -------------------------");

            if (option == -1) {
                return;
            }

            if ((option >= 0) && (option < options.size())) {

                task = options.get(option);

            }

        } while (option < 0 || option > options.size());


        LocalDate startDate = readDateFromConsole(scan, formatter, "Start date (DD-MM-YYYY): ");




        System.out.println(task);
        System.out.println(startDate);

        String confirmation = Utils.readLineFromConsole("Are you sure you want to add this task to the Agenda? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(task, startDate);
        } else {
            System.out.println("Operation canceled by the user.");
        }
    }

    /**
     * Submits the task and start date for adding to the agenda.
     *
     * @param task      the task to be added to the agenda.
     * @param startDate the start date for the task.
     */
    private void submitData(Task task, LocalDate startDate) {
        try {
            getController().addNewAgendaEntry(task, startDate);
            if (task.getStatus().equals(Status.PLANNED)) {
                System.out.println("\nA new task has been successfully added to the agenda!");
            } else {
                System.out.println("\nTask not added to the agenda!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while adding the task to the agenda: " + e.getMessage());
        }
    }

    /**
     * Reads a date from the console.
     *
     * @param scanner   the scanner to read input.
     * @param formatter the date formatter.
     * @param prompt    the prompt message to display.
     * @return the entered date.
     */
    @Override
    public LocalDate readDateFromConsole(Scanner scanner, DateTimeFormatter formatter, String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                date = LocalDate.parse(dateString, formatter);

                if (date.isBefore(LocalDate.now())) {
                    throw new IllegalArgumentException("Invalid data input. The day must be in the future.");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in DD-MM-YYYY format.");
            }
        }
        return date;
    }
}
