package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getPendingTasks() {


        List<Task> list = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(Status.PENDING)) {
                list.add(task);
            }
        }

        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

}
