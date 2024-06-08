package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    public List<Task> getTasksManagedByMe(String email) {
        TaskRepository taskRepository = Repositories.getInstance().getTaskRepository();
        UserSession userSession = Repositories.getInstance().getAuthenticationRepository().getCurrentUserSession();
        List<Task> tasks = new ArrayList<>();

        for (Task task: taskRepository.getTasks()) {
            if (task.getEmail().equals(userSession.getUserId().getEmail())) {
                tasks.add(task);
            }
        }

        return tasks;
    }

    public List<Task> getTasksByStatus(List<Task> tasks, Status status) {

        List<Task> tasks2 = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                tasks2.add(task);
            }
        }

        return tasks2;

    }


    public List<Task> getTasksByDates(List<Task> tasks, LocalDate startDate, LocalDate endDate) {
        List<Task> filteredTasks = new ArrayList<>();



        for (Task task : tasks) {
            if (task.getStartDate() == null) {

            } else if ((task.getStartDate().isEqual(startDate) || task.getStartDate().isAfter(startDate)) &&
                    (task.getStartDate().isEqual(endDate) || task.getStartDate().isBefore(endDate))) {
                filteredTasks.add(task);
            }

        }
        return filteredTasks;
    }


    public void addTask(Task task) {
        tasks.add(task);
    }

}
