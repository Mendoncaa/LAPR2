package pt.ipp.isep.dei.esoft.project.domain.service;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamMemberRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamService {

    private SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
    private TeamRepository teamRepository = Repositories.getInstance().getTeamRepository();
    private TeamMemberRepository teamMemberRepository = Repositories.getInstance().getTeamMemberRepository();

    public Team generateTeam(int minSize, int maxSize, List<Skill> skills) {

        ArrayList<Employee> team = new ArrayList<>();

        for (Skill skill : skills) {

            Employee addition = teamMemberRepository.findTeamMemberWithSkill(skill, team);

            if (addition != null) {

                team.add(addition);

            }

        }

        return new Team(minSize, maxSize, skills, team);

    }


    public Skill chooseSkill(int skillSelected) {

        List<Skill> skills = skillRepository.getSkills();

        System.out.println(skills.get(skillSelected));
        return skills.get(skillSelected);

    }


    public void teamApproved(Team team) {

        try {

            Optional<Team> task = teamRepository.createTeam(team.getMinSize(), team.getMaxSize(), team.getSkills(), team.getTeamMembers());

            if (task.isPresent()) {
                System.out.println("\nA new team has been successfully created!");
            } else {
                System.out.println("\nTeam not created!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while creating the team: " + e.getMessage());
        }

    }


}
