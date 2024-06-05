package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for managing skills.
 */
public class SkillRepository {
    private List<Skill> skills;


/**
 * Constructor for SkillRepository.
 * Initializes the list of skills.
 */
    public SkillRepository() {
        this.skills = new ArrayList<>();
    }


/**
 * Retrieves the list of all skills.
 *
 * @return A list of all skills.
 */

    public List<Skill> getSkills() {
        return skills;
    }

/**
 * Retrieves a skill by its unique ID.
 *
 * @param skillId The unique ID of the skill.
 * @return The skill with the specified ID, or null if no such skill exists.
 */
    public Skill getSkillById(String skillId) {
        for (Skill skill : this.skills) {
            if (skill.getId().equals(skillId)) {
                return skill;
            }
        }
        return null;
    }

/**
 * Adds a new skill to the repository.
 *
 * @param skill The skill to be added.
 */
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

/**
 * Lists all skills in the repository.
 *
 * @return A new list containing all the skills.
 */

    public List<Skill> listAllSkills() {
        return new ArrayList<>(skills);
    }
}

