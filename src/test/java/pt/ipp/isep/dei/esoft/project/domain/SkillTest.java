package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @Test
    void testConstructor_validName() {
        Skill skill = new Skill("Programming");
        assertEquals("Programming", skill.getName());
    }



    @Test
    void testGenerateId() {
        Skill skill1 = new Skill("Programming");
        Skill skill2 = new Skill("Design");
        assertNotEquals(skill1.getId(), skill2.getId());
    }
}
