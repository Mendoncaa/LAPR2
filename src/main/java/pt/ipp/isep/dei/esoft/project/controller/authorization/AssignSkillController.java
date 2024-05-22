package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

public class AssignSkillController {
    private final SkillRepository skillRepository;


    public AssignSkillController() {
        this.skillRepository = Repositories.getInstance().getSkillRepository();
    }

    public boolean assignSkillToTeamMember(String teamMemberId, String skillId) {
        Skill skill = skillRepository.getSkillById(skillId);
        if (skill == null) {
            System.out.println("Skill not found");
            return false;
        }

        return true;
    }
}



