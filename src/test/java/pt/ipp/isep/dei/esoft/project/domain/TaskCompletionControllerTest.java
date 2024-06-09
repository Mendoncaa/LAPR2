package pt.ipp.isep.dei.esoft.project.domain;


import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.controller.TaskCompletionController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;

import java.util.ArrayList;
        import java.util.List;
        import static org.junit.jupiter.api.Assertions.*;

public class TaskCompletionControllerTest {

    @Test
    public void testCompleteTask_CollabLoggedIn_NoOrganizationFound() {
        // Arrange
        TaskCompletionController controller = new TaskCompletionController();
        Repositories repositories = new Repositories(); // Repositórios reais
        UserSession userSession = new UserSession(); // Sessão de usuário real
        userSession.isLoggedInWithRole("Collab"); // Simula o login como "Collab"
        repositories.setAuthenticationRepository(new AuthenticationRepository(userSession)); // Define o repositório de autenticação com a sessão de usuário
        controller.repositories = repositories; // Define os repositórios no controlador
        Task task = new Task(); // Crie uma tarefa simulada

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> controller.completeTask(task));
    }

    @Test
    public void testCompleteTask_NotCollabLoggedIn() {
        // Arrange
        TaskCompletionController controller = new TaskCompletionController();
        Repositories repositories = new Repositories(); // Repositórios reais
        UserSession userSession = new UserSession(); // Sessão de usuário real
        repositories.setAuthenticationRepository(new AuthenticationRepository(userSession)); // Define o repositório de autenticação com a sessão de usuário
        controller.repositories = repositories; // Define os repositórios no controlador
        Task task = new Task(); // Crie uma tarefa simulada

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> controller.completeTask(task));
    }

    @Test
    public void testGetTasksByManagedMe() {
        // Arrange
        TaskCompletionController controller = new TaskCompletionController();
        Repositories repositories = new Repositories(); // Repositórios reais
        UserSession userSession = new UserSession(); // Sessão de usuário real
        repositories.setAuthenticationRepository(new AuthenticationRepository(userSession)); // Define o repositório de autenticação com a sessão de usuário
        controller.repositories = repositories; // Define os repositórios no controlador

        // Act
        List<Task> tasks = controller.getTasksByManagedMe();

        // Assert
        assertNotNull(tasks); // Verifique se a lista de tarefas não é nula
        assertEquals(0, tasks.size()); // Verifique se a lista de tarefas está vazia inicialmente
    }

    // Você pode adicionar mais casos de teste conforme necessário
}
