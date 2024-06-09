package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;
import java.util.Optional;

public class CancelTaskController {
    Repositories repositories = Repositories.getInstance();

    public List<Task> getTasks() {
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                TaskRepository taskRepository = repositories.getTaskRepository();

                List<Task> tasks1 = taskRepository.getTasksManagedByMe(userEmail);
                return taskRepository.getTasksByStatus(tasks1, Status.PLANNED);

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to cancel the completion of a task.");

        }
    }

    public void cancelTask(Task task) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();
        String userEmail = userSession.getUserId().getEmail();

        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
        Employee employee = employeeRepository.getEmployeeById(userEmail);

        employee.cancelTask(task);

    }
}
