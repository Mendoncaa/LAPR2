package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
/**
 * This class is responsible for querying tasks based on specific criteria, such as start date, end date, and status.
 */
public class ConsultTasksController {

    Repositories repositories = Repositories.getInstance();

    /**
     * Queries tasks based on the provided start date, end date, and status.
     *
     * @param startDate the start date to filter tasks
     * @param endDate   the end date to filter tasks
     * @param status    the status of tasks to be queried
     * @return a list of tasks that meet the query criteria
     * @throws IllegalArgumentException if the user is not authorized to query the agenda or if the organization is not found for the logged-in user
     */
    public List<Task> consultTasks(LocalDate startDate, LocalDate endDate, Status status) {

        // Retrieves the current user session
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();


        if (userSession.isLoggedInWithRole("Gsm")) {

                String userEmail = userSession.getUserId().getEmail();

                // Retrieves the organization associated with the logged-in employee's email
                Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                        getOrganizationByEmployeeEmail(userEmail);


                if (organizationOptional.isPresent()) {
                    TaskRepository taskRepository = repositories.getTaskRepository();

                    List<Task> tasks = taskRepository.getTasksManagedByMe(userSession.getUserId().getEmail());
                    tasks = taskRepository.getTasksByStatus(tasks, status);
                    tasks = taskRepository.getTasksByDates(tasks, startDate, endDate);

                    return tasks;

                } else {

                    throw new IllegalArgumentException("Organization not found for user: " + userEmail);

                }

            } else {

                throw new IllegalArgumentException("User is not authorized to consult the agenda.");

            }
        }
    }

