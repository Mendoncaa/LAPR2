package pt.ipp.isep.dei.esoft.project.domain;


import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.TaskCompletionController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
        import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class TaskCompletionControllerTest {

    @Test
    public void testCompleteTask_CollabLoggedIn_NoOrganizationFound() {
            GreenSpace greenSpace1 = new GreenSpace("Parque da cidade", SizeClassification.LARGE_SIZED_PARK,
                    1000, "Estrada Interior da Circunvalação, 4100-083 Porto", "gsm@this.app");
            Task task = new Task(" Limpeza2", greenSpace1, "Limpeza dos caixotes do lixo2",
                    Urgency.MEDIUM, Duration.ofDays(1).plusHours(4), "gsm@this.app");

            LocalDate date = LocalDate.of(2026, 12, 31);
            task.completeTask();

            assertNotNull(task);
            assertEquals(Status.DONE, task.getStatus());
    }
}
