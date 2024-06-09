package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.ConsultTasksController;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.ui.console.AddAgendaEntryUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ConsultTasksUI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultTasksControllerTest {


    @Test
    public void getTasksByStatusTest() {
        // Configurar o cenário
        GreenSpace greenSpace1 = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");

        Task task1 = new Task("Limpeza1", greenSpace1, "Limpeza dos caixotes do lixo1",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(4), "gsm@this.app");

        Task task2 = new Task("Limpeza2", greenSpace1, "Limpeza dos caixotes do lixo2",
                Urgency.HIGH, Duration.ofHours(2), "gsm@this.app");
        task2.planTaskInAgenda(LocalDate.of(2020, 2, 2));

        Task task3 = new Task("Limpeza3", greenSpace1, "Limpeza dos caixotes do lixo3",
                Urgency.LOW, Duration.ofDays(2), "gsm@this.app");
        task3.completeTask();

        List<Task> tasks = Arrays.asList(task1, task2, task3);

        // Chamar o método a ser testado
        List<Task> plannedTasks = getTasksByStatus(tasks, Status.PLANNED);

        // Verificar o resultado
        assertNotNull(plannedTasks);
        assertEquals(1, plannedTasks.size());
        assertTrue(plannedTasks.contains(task2));
    }

    // Método a ser testado
    public List<Task> getTasksByStatus(List<Task> tasks, Status status) {
        List<Task> tasks2 = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                tasks2.add(task);
            }
        }
        return tasks2;
    }


    /**
     * Test of readDataFromConsole method (AddAgendaEntryUI)
     */
    @org.junit.Test
    public void readDataFromConsoleTest() {
        String userInput = "30-06-2024";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner scanner = new Scanner(userInput);

        ConsultTasksUI consultTasksUI = new ConsultTasksUI();
        LocalDate result =  consultTasksUI.readDateFromConsole(scanner, formatter, "Enter a date: ");

        assertNotNull(result);
        assertEquals(LocalDate.of(2024, 6, 30), result);
    }

}
