package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SkillRepository {
    private List<Skill> skills;

    public SkillRepository() {
        this.skills = new ArrayList<>();
    }

    public List<Skill> getSkills() {
        return skills;
    }

    /**
     *
     * @param skillId
     * @return user skill
     */
    public Skill getSkillById(String skillId) {
        for (Skill skill : this.skills) {
            if (skill.getId().equals(skillId)) {
                return skill;
            }
        }
        return null;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

}

