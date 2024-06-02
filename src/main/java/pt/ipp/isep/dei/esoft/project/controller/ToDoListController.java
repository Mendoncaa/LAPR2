package pt.ipp.isep.dei.esoft.project.controller;

import com.sun.source.util.TaskListener;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoListController {



    public List<GreenSpace> getAvailabreGreenSpaces() {
        Repositories repositories = Repositories.getInstance();
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


    public Optional<Task> addNewTask(String title, String description, GreenSpace greenSpace, Urgency urgency, int days, int hours) {

        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                TaskRepository taskRepository = repositories.getTaskRepository();
                Task task = employee.createTask(title, description, greenSpace, urgency, days, hours);
                taskRepository.addTask(task);

                return Optional.of(task);

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to create a job.");

        }
    }
}
