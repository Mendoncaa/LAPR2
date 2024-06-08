package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoListController {

    Repositories repositories = Repositories.getInstance();

    public Optional<Task> addNewTask(String title, String description, GreenSpace greenSpace, Urgency urgency, Duration duration) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                TaskRepository taskRepository = repositories.getTaskRepository();
                Task task = employee.createTask(title, description, greenSpace, urgency, duration,
                        userSession.getUserId().getEmail());
                taskRepository.addTask(task);

                return Optional.of(task);

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to create a job.");

        }
    }


    public List<GreenSpace> getAvailableGreenSpaces() {
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();
        List<GreenSpace> spacesManagedByMe = new ArrayList<>();

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            if (greenSpace.getEmail().equals(userSession.getUserId().getEmail())) {
                spacesManagedByMe.add(greenSpace);
            }
        }

        return spacesManagedByMe;
    }
}
