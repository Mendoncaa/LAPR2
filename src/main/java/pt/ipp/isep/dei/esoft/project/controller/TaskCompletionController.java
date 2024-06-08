package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.User;

import java.util.List;
import java.util.Optional;

public class TaskCompletionController {

    Repositories repositories = Repositories.getInstance();

    public void completeTask(Task task) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                TaskRepository taskRepository = repositories.getTaskRepository();
                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                employee.completeTask(task);


            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to record the completion of a task.");

        }
    }

    public List<Task> getTasksByManagedMe() {
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        TaskRepository taskRepository = repositories.getTaskRepository();

        return taskRepository.getTasksManagedByMe(userSession.getUserId().getEmail());

    }

}
