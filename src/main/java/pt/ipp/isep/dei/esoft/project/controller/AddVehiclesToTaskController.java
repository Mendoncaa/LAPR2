package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for adding vehicles to a task.
 */
public class AddVehiclesToTaskController {

    /**
     * Retrieves a list of all vehicles.
     *
     * @return The list of vehicles.
     */
    public List<Vehicle> listAllVehicles() {
        Repositories repositories = Repositories.getInstance();
        VehicleRepository vehicleRepository = repositories.getVehicleRepository();
        return vehicleRepository.getVehicles();
    }

    /**
     * Retrieves a list of tasks in the agenda of the current GSM user.
     *
     * @return The list of tasks.
     * @throws IllegalArgumentException If the user is not authorized or if the organization is not found.
     */
    public List<Task> listThisGsmTasksInAgenda() throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository()
                    .getOrganizationByEmployeeEmail(userEmail);
            if (organizationOptional.isPresent()) {
                EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
                Employee employee = employeeRepository.getEmployeeById(userEmail);
                return employee.listThisGsmTasksInAgenda(userEmail);
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not a GSM authorized.");
        }
    }

    /**
     * Retrieves a list of vehicles that are not assigned to the given task by the date of the task.
     *
     * @param task The task to check for.
     * @return The list of vehicles not assigned to the task.
     * @throws IllegalArgumentException If the task or vehicles are not found.
     */
    public List<Vehicle> listVehiclesNotAssignedByDateOfTasks(Task task) throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
        Employee employee = employeeRepository.getEmployeeById(task.getEmail());
        return employee.filterVehiclesNotAssignedByDateOfTasks(task, listAllVehicles());
    }

    /**
     * Updates the vehicles assigned to the given task.
     *
     * @param task     The task to update.
     * @param vehicles The list of vehicles to assign to the task.
     * @return True if the update was successful, false otherwise.
     * @throws IllegalArgumentException If the task or vehicles are not found.
     */
    public Boolean updateTaskVehicles(Task task, List<Vehicle> vehicles) throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();
        Employee employee = employeeRepository.getEmployeeById(task.getEmail());
        return employee.addUpdatedTaskVehicles(task, vehicles);
    }
}








