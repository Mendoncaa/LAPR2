package pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;

public class AssignSkillController {
    private SkillRepository skillRepository;
    private Repositories repositories;

    public AssignSkillController(SkillRepository skillRepository, Repositories repositories) {
        this.skillRepository = skillRepository;
        this.repositories = repositories;
    }

    public boolean assignSkillToTeamMember(String teamMemberId, String skillId) {
        Skill skill = skillRepository.getSkillById(skillId);
        if (skill == null) {
            System.out.println("Skill not found");
            return false;
        }

        /*TeamMember teamMember = repositories.getTeamMember(teamMemberId);
        if (teamMember == null) {
            System.out.println("Collaborator not found.");
            return false;
        }

        teamMember.addSkill(skill); */
        return true;
    }
}


