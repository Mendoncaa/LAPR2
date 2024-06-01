package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }


    public void addTask(Task task) {
        tasks.add(task);
    }

}
