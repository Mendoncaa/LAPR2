package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.ConsultTasksController;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ConsultTasksControllerTest {

    @Test
    public void ConsultTasksControllerTest () {
        // Arrange
        ConsultTasksController controller = new ConsultTasksController();
        Repositories repositories = new Repositories(); // Repositórios reais
        UserSession userSession = new UserSession(); // Sessão de usuário real
        userSession.isLoggedInWithRole("Collab"); // Simula o login como "Collab"
        repositories.setAuthenticationRepository(new AuthenticationRepository(userSession)); // Define o repositório de autenticação com a sessão de usuário
        controller.repositories = repositories; // Define os repositórios no controlador

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> controller.consultTasks(LocalDate.now(), LocalDate.now(), Status.OPEN));
    }

    @Test
    public void testConsultTasks_NotCollabLoggedIn() {
        // Arrange
        ConsultTasksController controller = new ConsultTasksController();
        Repositories repositories = new Repositories(); // Repositórios reais
        UserSession userSession = new UserSession(); // Sessão de usuário real
        repositories.setAuthenticationRepository(new AuthenticationRepository(userSession)); // Define o repositório de autenticação com a sessão de usuário
        controller.repositories = repositories; // Define os repositórios no controlador

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> controller.consultTasks(LocalDate.now(), LocalDate.now(), Status.OPEN));
    }

}
