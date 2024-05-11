package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

import static org.junit.jupiter.api.Assertions.*;

class SkillRepositoryTest {

    @Test
    void testConstructor() {
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.getSkills();
        assertTrue(skillRepository.getSkills().isEmpty());
    }


    @Test
    void testGetSkillById_found() {
        SkillRepository skillRepository = new SkillRepository();
        Skill skill = new Skill("Programming");
        skillRepository.addSkill(skill);
        assertEquals(skill, skillRepository.getSkillById(skill.getId()));
    }

    @Test
    void testGetSkillById_notFound() {
        SkillRepository skillRepository = new SkillRepository();
        assertNull(skillRepository.getSkillById("nonexistentId"));
    }
}
