# US026 - As a GSM, I want to assign one or more vehicles to an entry in the Agenda.

## 4. Tests 

**Test 1:** Check that vehicles can´t be assigned in two tasks at same time

	@Test
    public void ensureVehicleCannotBeAssignedToTwoTasksAtSameTime() {
    GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
    Task task1 = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, Duration.ofHours(2), "gsm@this.app");
    Task task2 = new Task("Task 2", greenSpace, "Task description", Urgency.HIGH, Duration.ofHours(2), "gsm@this.app");

    Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000);
    
    task1.assignVehicle(vehicle);
    
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        task2.assignVehicle(vehicle);
    });
    
    assertEquals("Vehicle cannot be assigned to two tasks at the same time", exception.getMessage());
}

	**AC1** - Vehicles selected must be available in the date and time of execution scheduled.


**Test 2:** Check that only Gsm of that park can assign vehicles. 

    @Test
    public void ensureOnlyGsmOfThatParkCanAssignVehicles() {
    GreenSpace greenSpace = new GreenSpace("Park", SizeClassification.MEDIUM_SIZED_PARK, 100.0, "Park Street", "gsm@this.app");
    Task task = new Task("Task 1", greenSpace, "Task description", Urgency.HIGH, Duration.ofHours(2), "gsm@this.app");

    Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500, 50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000);
    
    task.assignVehicle(vehicle);
    
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        task.assignVehicle(vehicle);
    });
    
    assertEquals("Only GSM of that park can assign vehicles", exception.getMessage());
}





## 5. Construction (Implementation)

### Class AddVehiclesToTaskController 

```java
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

```

### Class Organization

```java
package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of tasks.
 */
public class Tasks {

    private List<Task> tasks = new ArrayList<>();

    /**
     * Filters tasks in the agenda of the given user email.
     *
     * @param userEmail The email of the user.
     * @return The list of tasks in the agenda of the user.
     */
    public List<Task> filterThisGsmTasksInAgenda(String userEmail) {
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getEmail().equalsIgnoreCase(userEmail)) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }

    /**
     * Filters vehicles that are not assigned to the given task by the date of the task.
     *
     * @param task     The task to check for.
     * @param vehicles The list of all vehicles.
     * @return The list of vehicles not assigned to the task by date.
     */
    public List<Vehicle> filterVehiclesNotAssignedByDateOfTask(Task task, List<Vehicle> vehicles) {
        List<Vehicle> availableVehicles = new ArrayList<>(vehicles);
        for (Vehicle vehicle : vehicles) {
            for (Task t : tasks) {
                if (t.getStartDate() != null && t.getStartDate().equals(task.getStartDate()) && t.getVehicles().contains(vehicle)) {
                    availableVehicles.remove(vehicle);
                }
            }
        }
        return availableVehicles;
    }

    /**
     * Adds a task to the collection.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    /**
     * Gets the list of tasks in the collection.
     *
     * @return The list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
```


## 6. Integration and Demo 




## 7. Observations

n/a