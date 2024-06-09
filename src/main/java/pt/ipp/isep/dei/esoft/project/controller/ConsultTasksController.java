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

public class ConsultTasksController {

    Repositories repositories = Repositories.getInstance();

    public List<Task> consultTasks(LocalDate startDate, LocalDate endDate, Status status) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
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
