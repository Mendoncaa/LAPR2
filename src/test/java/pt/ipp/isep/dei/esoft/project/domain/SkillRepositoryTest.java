package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for SkillRepository.
 */
class SkillRepositoryTest {
    private SkillRepository skillRepository;
    private Skill skill1;
    private Skill skill2;

    /**
     * Sets up a SkillRepository instance and sample skills before each test.
     */
    @BeforeEach
    void setUp() {
        skillRepository = new SkillRepository();
        skill1 = new Skill("Programming");
        skill2 = new Skill("Design");
    }

    /**
     * Tests the constructor and ensures the skill list is initialized.
     */
    @Test
    void testConstructor() {
        assertNotNull(skillRepository.getSkills());
        assertTrue(skillRepository.getSkills().isEmpty());
    }

    /**
     * Tests adding a skill to the repository.
     * Verifies that the skill is added to the list.
     */
    @Test
    void testAddSkill() {
        skillRepository.addSkill(skill1);
        assertEquals(1, skillRepository.getSkills().size());
        assertEquals(skill1, skillRepository.getSkills().get(0));
    }

    /**
     * Tests retrieving a skill by its ID.
     * Verifies that the correct skill is returned.
     */
    @Test
    void testGetSkillById() {
        skillRepository.addSkill(skill1);
        Skill retrievedSkill = skillRepository.getSkillById(skill1.getId());
        assertEquals(skill1, retrievedSkill);
    }

    /**
     * Tests retrieving a skill by an ID that does not exist.
     * Verifies that null is returned.
     */
    @Test
    void testGetSkillByIdNotFound() {
        Skill retrievedSkill = skillRepository.getSkillById("nonexistent_id");
        assertNull(retrievedSkill);
    }

    /**
     * Tests listing all skills in the repository.
     * Verifies that the list contains all added skills.
     */
    @Test
    void testListAllSkills() {
        skillRepository.addSkill(skill1);
        skillRepository.addSkill(skill2);
        List<Skill> skills = skillRepository.listAllSkills();
        assertEquals(2, skills.size());
        assertTrue(skills.contains(skill1));
        assertTrue(skills.contains(skill2));
    }

    /**
     * Tests that listing all skills returns a new list instance.
     * Verifies that the returned list is a copy, not the original list.
     */
    @Test
    void testListAllSkillsReturnsNewList() {
        skillRepository.addSkill(skill1);
        List<Skill> skills = skillRepository.listAllSkills();
        skills.add(new Skill("Testing"));
        assertEquals(1, skillRepository.getSkills().size());
        assertEquals(2, skills.size());
    }
}