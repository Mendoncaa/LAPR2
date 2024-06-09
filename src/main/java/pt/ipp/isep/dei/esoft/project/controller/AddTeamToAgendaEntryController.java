package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;
import java.util.Optional;

public class AddTeamToAgendaEntryController {

    Repositories repositories = Repositories.getInstance();
    UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

    public List<Team> getTeams() {



        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                TeamRepository teamRepository = repositories.getTeamRepository();

                return teamRepository.getTeams();


            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to record the completion of a task.");

        }

    }


    public List<Task> getTasks() {

        TaskRepository taskRepository = repositories.getTaskRepository();

        List<Task> tasks = taskRepository.getTasksManagedByMe(userSession.getUserId().getEmail());


        return taskRepository.getTasksByStatus(tasks, Status.PLANNED);

    }


    public void addTeamToEntry(Team team, Task task) {

        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
        String email = userSession.getUserId().getEmail();
        Employee employee = employeeRepository.getEmployeeById(email);

        employee.addTeamToEntry(team, task);

    }

}
