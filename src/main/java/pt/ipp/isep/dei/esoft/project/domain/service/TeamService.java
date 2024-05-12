package pt.ipp.isep.dei.esoft.project.domain.service;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamMemberRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    private final SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
    private final TeamRepository teamRepository = Repositories.getInstance().getTeamRepository();
    private final TeamMemberRepository teamMemberRepository = Repositories.getInstance().getTeamMemberRepository();

    public Team generateTeam(int minSize, int maxSize, List<Skill> skills) {

        ArrayList<TeamMember> team = new ArrayList<>();

        for (Skill skill : skills) {

            TeamMember addition = teamMemberRepository.findTeamMemberWithSkill(skill, team);

            if (addition != null) {

                team.add(addition);

            }

        }

        return new Team(minSize, maxSize, skills, team);

    }


    public Skill chooseSkill() {

        List<Skill> skills = skillRepository.getSkills();

        int option = 0;
        do {
            Utils.showAndSelectIndex(skills, "\n\n--- SKILLS -------------------------");

            if ((option >= 0) && (option < skills.size())) {

                if (option == 0) {

                    return null;

                }

                return skills.get(option);

            }

        } while (option != -1);

        return null;

    }


    public void teamApproved(Team team) {

        teamRepository.createTeam(team.getMinSize(), team.getMaxSize(), team.getSkills(), team.getTeamMembers());

    }


}
