package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * Controller for managing tasks in the To-Do List.
 * This controller interacts with the repositories and user session to handle task creation and retrieval of green spaces.
 */
public class ToDoListController {

    Repositories repositories = Repositories.getInstance();
    UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

    /**
     * Adds a new task to the repository.
     *
     * @param title The title of the task.
     * @param description The description of the task.
     * @param greenSpace The green space associated with the task.
     * @param urgency The urgency level of the task.
     * @param duration The expected duration of the task.
     * @return An Optional containing the created task if successful, otherwise an empty Optional.
     */
    public Optional<Task> addNewTask(String title, String description, GreenSpace greenSpace, Urgency urgency, Duration duration) {

            String userEmail = userSession.getUserId().getEmail();
            EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
            Employee employee = employeeRepository.getEmployeeById(userEmail);

            TaskRepository taskRepository = repositories.getTaskRepository();
            Task task = employee.createTask(title, description, greenSpace, urgency, duration,
            userSession.getUserId().getEmail());
            taskRepository.addTask(task);

            return Optional.of(task);
    }

    /**
     * Retrieves a list of green spaces managed by the current user.
     *
     * @return A list of GreenSpace objects managed by the current user.
     * @throws IllegalArgumentException If the user is not authorized to create a task or the organization is not found for the user.
     */
    public List<GreenSpace> getGreenSpacesManagedByMe() {

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                return employee.getGreenSpacesManagedByMe();

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

            } else {

                throw new IllegalArgumentException("User is not authorized to create a task.");

            }

    }
}
