package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Skill.
 */
class SkillTest {
    private Skill skill;

    /**
     * Sets up a Skill instance before each test.
     */
    @BeforeEach
    void setUp() {
        skill = new Skill("Programming");
    }

    /**
     * Tests the constructor with a valid skill name.
     * Asserts that the name is set correctly and the ID is not null.
     */
    @Test
    void testConstructorValidName() {
        assertEquals("Programming", skill.getName());
        assertNotNull(skill.getId());
    }

    /**
     * Tests the constructor with an empty skill name.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidNameEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Skill("");
        });
        assertEquals("The skill name cannot be empty.", exception.getMessage());
    }

    /**
     * Tests the constructor with a null skill name.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidNameNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Skill(null);
        });
        assertEquals("The skill name cannot be empty.", exception.getMessage());
    }

    /**
     * Tests the constructor with a skill name containing special characters.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidNameSpecialCharacters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Skill("Programming@123");
        });
        assertEquals("The skill name cannot contain special characters or digits.", exception.getMessage());
    }

    /**
     * Tests the constructor with a skill name containing digits.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidNameDigits() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Skill("Programming123");
        });
        assertEquals("The skill name cannot contain special characters or digits.", exception.getMessage());
    }

    /**
     * Tests setting a valid skill name.
     * Asserts that the name is updated correctly.
     */
    @Test
    void testSetSkillNameValid() {
        skill.setSkillName("Design");
        assertEquals("Design", skill.getName());
    }

    /**
     * Tests setting an empty skill name.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testSetSkillNameInvalidEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            skill.setSkillName("");
        });
        assertEquals("The skill name cannot be empty.", exception.getMessage());
    }

    /**
     * Tests setting a null skill name.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testSetSkillNameInvalidNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            skill.setSkillName(null);
        });
        assertEquals("The skill name cannot be empty.", exception.getMessage());
    }

    /**
     * Tests setting a skill name containing special characters.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testSetSkillNameInvalidSpecialCharacters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            skill.setSkillName("Design@123");
        });
        assertEquals("The skill name cannot contain special characters or digits.", exception.getMessage());
    }

    /**
     * Tests setting a skill name containing digits.
     * Expects an IllegalArgumentException.
     */
    @Test
    void testSetSkillNameInvalidDigits() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            skill.setSkillName("Design123");
        });
        assertEquals("The skill name cannot contain special characters or digits.", exception.getMessage());
    }

    /**
     * Tests generating unique IDs for different Skill instances.
     * Asserts that the IDs are not equal.
     */
    @Test
    void testGenerateId() {
        Skill skill1 = new Skill("Design");
        Skill skill2 = new Skill("Testing");
        assertNotEquals(skill1.getId(), skill2.getId());
    }

    /**
     * Tests the toString method.
     * Asserts that the string representation of the skill is as expected.
     */
    @Test
    void testToString() {
        String expected = "Skill{id='" + skill.getId() + "', name='Programming'}";
        assertEquals(expected, skill.toString());
    }

    /**
     * Tests the compareTo method.
     * Asserts the comparison results between different skill names.
     */
    @Test
    void testCompareTo() {
        Skill skill1 = new Skill("Programming");
        Skill skill2 = new Skill("Design");
        Skill skill3 = new Skill("Testing");

        assertTrue(skill1.compareTo(skill2) > 0); // "Programming" > "Design"
        assertTrue(skill1.compareTo(skill3) < 0); // "Programming" < "Testing"
        assertEquals(0, skill1.compareTo(new Skill("Programming"))); // "Programming" == "Programming"
    }
}
