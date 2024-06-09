package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.TaskRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.AddAgendaEntryUI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class US22Tests {
    /**
     * Test of planTaskInAgenda method sucess
     */
    @org.junit.Test
    public void planTaskInAgendaTest() {
        GreenSpace greenSpace1 = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");
        Task task = new Task(" Limpeza2", greenSpace1, "Limpeza dos caixotes do lixo2",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(4), "gsm@this.app");

        LocalDate date = LocalDate.of(2026, 12, 31);
        task.planTaskInAgenda(date);

        assertNotNull(task); 
        assertEquals(Status.PLANNED, task.getStatus());
        assertEquals(date, task.getStartDate());
    }

    /**
     * Test of getPendingTasks method sucess
     */
    @org.junit.Test
    public void getPendingTasksTest() {
        TaskRepository taskRepository = new TaskRepository();
        GreenSpace greenSpace1 = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");

        Task task1 = new Task(" Limpeza2", greenSpace1, "Limpeza dos caixotes do lixo2",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(4), "gsm@this.app");
        Task task2 = new Task(" Limpeza1", greenSpace1, "Limpeza dos caixotes do lixo1",
                Urgency.MEDIUM, Duration.ofDays(1).plusHours(3), "gsm@this.app");
        task2.planTaskInAgenda(LocalDate.of(2026, 12, 31));
        taskRepository.addTask(task1);
        taskRepository.addTask(task2);

        List<Task> pendingTasks = taskRepository.getPendingTasks();

        assertEquals(1, pendingTasks.size());
        assertEquals(task1, pendingTasks.get(0));
    }

    /**
     * Test of readDataFromConsole method (AddAgendaEntryUI)
     */
    @org.junit.Test
    public void readDataFromConsoleTest() {
        String userInput = "30-06-2024";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Scanner scanner = new Scanner(userInput);

        AddAgendaEntryUI addAgendaEntryUI = new AddAgendaEntryUI();
        LocalDate result =  addAgendaEntryUI.readDateFromConsole(scanner, formatter, "Enter a date: ");

        assertNotNull(result);
        assertEquals(LocalDate.of(2024, 6, 30), result);
    }
}

