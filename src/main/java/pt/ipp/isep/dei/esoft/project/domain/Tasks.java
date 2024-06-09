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


