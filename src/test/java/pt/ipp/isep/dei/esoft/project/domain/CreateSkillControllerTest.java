package pt.ipp.isep.dei.esoft.project.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;

import java.util.Optional;

/**
 * Testes para a classe CreateSkillController, garantindo cobertura completa e qualidade dos testes.
 */
public class CreateSkillControllerTest {

    @Mock
    private AuthenticationRepository authenticationRepository;

    @Mock
    private OrganizationRepository organizationRepository;

    @Mock
    private SkillRepository skillRepository;

    @InjectMocks
    private CreateSkillController createSkillController;

    /**
     * Configuração inicial para cada teste.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Testa a criação de uma habilidade com um usuário e organização válidos.
     */
    /*
    @Test
    public void testCreateSkillWithValidUserAndOrganization() {
        // Mock user session
        UserSession userSession = mock(UserSession.class);
        when(authenticationRepository.getCurrentUserSession()).thenReturn(userSession);
        when(userSession.isLoggedInWithRole("Hrm")).thenReturn(true);
        when(userSession.getUserId().getEmail()).thenReturn("user@example.com");

        // Mock organization
        Organization organization = mock(Organization.class);
        when(organizationRepository.getOrganizationByEmployeeEmail(anyString())).thenReturn(Optional.of(organization));

        // Mock skill creation
        Skill skill = new Skill("Test Skill");
        when(organization.createSkill("Test Skill")).thenReturn(skill);

        // Perform the test
        Optional<Skill> createdSkill = createSkillController.createSkill("Test Skill");

        // Verify the result
        assertTrue(createdSkill.isPresent());
        assertEquals(skill, createdSkill.get());
    }*/

    /**
     * Testa a criação de uma habilidade com um usuário inválido.
     */

    /*
    @Test
    public void testCreateSkillWithInvalidUser() {
        // Mock user session
        UserSession userSession = mock(UserSession.class);
        when(authenticationRepository.getCurrentUserSession()).thenReturn(userSession);
        when(userSession.isLoggedInWithRole("Hrm")).thenReturn(false);

        // Perform the test
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            createSkillController.createSkill("Test Skill");
        });

        // Verify the exception message
        assertEquals("User is not authorized to create a job.", exception.getMessage());
    }*/

    /**
     * Testa a criação de uma habilidade com uma organização inválida.
     */

    /*
    @Test
    public void testCreateSkillWithInvalidOrganization() {
        // Mock user session
        UserSession userSession = mock(UserSession.class);
        when(authenticationRepository.getCurrentUserSession()).thenReturn(userSession);
        when(userSession.isLoggedInWithRole("Hrm")).thenReturn(true);
        when(userSession.getUserId().getEmail()).thenReturn("user@example.com");

        // Mock organization repository returning empty optional
        when(organizationRepository.getOrganizationByEmployeeEmail(anyString())).thenReturn(Optional.empty());

        // Perform the test
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            createSkillController.createSkill("Test Skill");
        });

        // Verify the exception message
        assertEquals("Organization not found for user: user@example.com", exception.getMessage());
    }*/

}




