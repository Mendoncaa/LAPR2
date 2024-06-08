import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

/**
 * Unit tests for the AssignSkillController class.
 */
public class AssignSkillControllerTest {

    @Mock
    private SkillRepository skillRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private AssignSkillController assignSkillController;

    private Employee employee;
    private Skill skill;

    /**
     * Sets up the test environment before each test.
     * Initializes mocks and creates an instance of Skill.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employee = mock(Employee.class);
        skill = new Skill("Java Programming");
    }

    /**
     * Tests the assignSkillToTeamMember method to ensure it correctly
     * assigns a skill to an employee.
     */
    @Test
    public void testAssignSkillToTeamMember() {
        assignSkillController.assignSkillToTeamMember(employee, skill);
        verify(employee, times(1)).assignSkill(skill);
    }

    /**
     * Tests the assignSkillToTeamMember method to ensure it throws an
     * IllegalArgumentException when the employee is null.
     */
    @Test
    public void testAssignSkillToTeamMemberWithNullEmployee() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            assignSkillController.assignSkillToTeamMember(null, skill);
        });
        assertEquals("Employee cannot be null", exception.getMessage());
    }

    /**
     * Tests the assignSkillToTeamMember method to ensure it throws an
     * IllegalArgumentException when the skill is null.
     */
    @Test
    public void testAssignSkillToTeamMemberWithNullSkill() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            assignSkillController.assignSkillToTeamMember(employee, null);
        });
        assertEquals("Skill cannot be null", exception.getMessage());
    }

    /**
     * Tests the assignSkillToTeamMember method to ensure it throws an
     * IllegalArgumentException when both the employee and skill are null.
     */
    @Test
    public void testAssignSkillToTeamMemberWithNullEmployeeAndSkill() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            assignSkillController.assignSkillToTeamMember(null, null);
        });
        assertEquals("Employee and Skill cannot be null", exception.getMessage());
    }
}

