package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.AddTeamToAgendaEntryController;
import pt.ipp.isep.dei.esoft.project.controller.TaskCompletionController;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class AddTeamToAgendaEntryUI implements Runnable {
    private final AddTeamToAgendaEntryController controller;

    public AddTeamToAgendaEntryUI() {
        controller = new AddTeamToAgendaEntryController();
    }

    private AddTeamToAgendaEntryController getController() {
        return controller;
    }

    @Override
    public void run() {

        List<Team> optionsTeams = getController().getTeams();

        int optionTeam;

        Team team = null;

        do {

            optionTeam = Utils.showAndSelectIndex(optionsTeams, "\n\n--- AVAILABLE TEAMS -------------------------");

            if (optionTeam == -1) {
                return;
            }

            if ((optionTeam >= 0) && (optionTeam < optionsTeams.size())) {

                team = optionsTeams.get(optionTeam);

            }

        } while (optionTeam < 0 || optionTeam > optionsTeams.size());


        List<Task> optionsTasks = getController().getTasks();

        int optionTask;

        Task task = null;

        do {

            optionTask = Utils.showAndSelectIndex(optionsTasks, "\n\n--- AVAILABLE TEAMS -------------------------");

            if (optionTask == -1) {
                return;
            }

            if ((optionTask >= 0) && (optionTask < optionsTasks.size())) {

                task = optionsTasks.get(optionTask);

            }

        } while (optionTask < 0 || optionTask > optionsTasks.size());


        System.out.println(team);
        System.out.println(task);

        String confirmation = Utils.readLineFromConsole("Are you sure you want to record the completion of this task? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(team, task);
        } else {
            System.out.println("Operation canceled by the user.");
        }
    }

    private void submitData(Team team, Task task) {
        try {
            getController().addTeamToEntry(team, task);
            if (task.getTeam().equals(team)) {
                System.out.println("\nThe team has been sucessfully added to the agenda entry!");
            } else {
                System.out.println("\nTeam not added to the agenda entry!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while adding the team to the agenda entry: " + e.getMessage());
        }
    }

}
