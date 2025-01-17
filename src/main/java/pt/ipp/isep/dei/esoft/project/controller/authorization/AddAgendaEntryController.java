package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controls the addition of tasks to the agenda.
 */
public class AddAgendaEntryController {

    Repositories repositories = Repositories.getInstance();


    /**
     * Retrieves the list of pending tasks.
     *
     * @return the list of pending tasks.
     */
    public List<Task> getPendingTasks() {

        TaskRepository taskRepository = repositories.getTaskRepository();

        List<Task> list = taskRepository.getPendingTasks();

        return list;
    }

    /**
     * Adds a new agenda entry for the given task and start date.
     *
     * @param task      the task to be added to the agenda.
     * @param startDate the start date for the task.
     * @throws IllegalArgumentException if the user is not authorized or if the organization is not found.
     */
    public void addNewAgendaEntry(Task task, LocalDate startDate) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                employee.planTaskInAgenda(task, startDate);

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to create a job.");

        }

    }
}
