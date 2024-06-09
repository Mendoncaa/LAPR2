package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;
import pt.isep.lei.esoft.auth.UserSession;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class US21Tests {

    /**
     * Testing createTask method's sucess
     */
    @org.junit.Test
    public void createTaskTest() {

        GreenSpace greenSpace = new GreenSpace("Parque da Cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");
        Employee employee = new Employee(
                "Zé",
                LocalDate.of(1992, 2, 2),
                LocalDate.of(2021, 11, 30),
                "Rua da Morada 02",
                "Porto",
                "4000-051",
                "987654336",
                "collaborator@this.app",
                "CC",
                "12345678",
                "987784321",
                new Job("Trolha"));


        String title = "Limpeza dos Caixotes do Lixo";
        String description = "Limpeza dos caixotes do lixo no parque";
        Urgency urgency = Urgency.HIGH;
        Duration duration = Duration.ofHours(2);
        String email = "gsm@this.app";

        Task task = employee.createTask(title, description, greenSpace, urgency, duration, email);


        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(greenSpace, task.getGreenSpace());
        assertEquals(urgency, task.getUrgency());
        assertEquals(duration, task.getDuration());
        assertEquals(email, task.getEmail());
    }

    /**
     * Testing createTask method's sucess
     */
    @org.junit.Test
    public void getGreenSpacesManagedByMeTest() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        GreenSpaces greenSpaces = new GreenSpaces();


        String email = "gsm@this.app";
        List<GreenSpace> result = greenSpaces.getGreenSpacesManagedByMe(email);

        // Verifying the result
        assertEquals(1, result.size());
        assertEquals("Parque da cidade", result.get(0).getName());

    }

    /**
     * Testing addTaskTest method
     */
    @org.junit.Test
    public void addGreenSpaceTest() {
        TaskRepository taskRepository = new TaskRepository();

        String title = "Limpeza dos Caixotes do Lixo";
        String description = "Limpeza dos caixotes do lixo no parque";
        GreenSpace greenSpace = new GreenSpace("Parque Maia", SizeClassification.MEDIUM_SIZED_PARK
                , 1, "rua 1234", "gsm@this.app");
        Urgency urgency = Urgency.HIGH;
        Duration duration = Duration.ofHours(2);
        String email = "gsm@this.app";

        Task task = new Task(title,  greenSpace, description, urgency, duration, email);
        taskRepository.addTask(task);

        List<Task> tasks = taskRepository.getTasks();

        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

}


