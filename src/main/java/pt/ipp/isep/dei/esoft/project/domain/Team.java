package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.List;
import java.util.UUID;

public class Team {
    private String id;
    private int minSize;
    private int maxSize;
    private List<Skill> skills;
    private List<TeamMember> teamMembers;


    public Team(int minSize, int maxSize, List<Skill> skills, List<TeamMember> teamMembers) {
        this.id = UUID.randomUUID().toString();
        validateInput(minSize);
        this.minSize = minSize;
        validateInput(maxSize);
        this.maxSize = maxSize;
        this.skills = skills;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    private void validateInput(int input) {
        //TODO: missing from the diagrams
        if (input < 1) {
            throw new IllegalArgumentException("Reference cannot be null or empty.");
        }
    }


    public int getMinSize() {
        return minSize;
    }


    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }


    public int getMaxSize() {
        return maxSize;
    }


    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


    public List<Skill> getSkills() {
        return skills;
    }


    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }


    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }


    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }


    public void assignTeamMember(TeamMember teamMember) {

        teamMembers.add(teamMember);

    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("### Team Members ###\n");

        for (TeamMember teamMember : teamMembers) {

            stringBuilder.append(teamMember.toString()).append("\n");

        }

        return stringBuilder.toString();
    }
}
