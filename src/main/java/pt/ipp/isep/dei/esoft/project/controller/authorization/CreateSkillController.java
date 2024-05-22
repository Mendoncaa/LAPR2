package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

public class CreateSkillController {
    private SkillRepository skillRepository;

    public CreateSkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     *
     * @param skillName
     * @return Checks whether the skill name contains special characters or digits
     */
    public boolean createSkill(String skillName) {

        if (!skillName.matches("[a-zA-Z ]+")) {
            System.out.println("The skill name cannot contain special characters or digits.");
            return false;
        }

        Skill skill = new Skill(skillName);
        skillRepository.addSkill(skill);
        return true;
    }
}



