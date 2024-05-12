package pt.ipp.isep.dei.esoft.project.domain;

import java.util.*;

public class TeamMember {
    private String id;
    private String name;
    private List<Skill> skills;

    public TeamMember(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString(); //
        this.skills = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {

        if (!skills.contains(skill)) {

            skills.add(skill);

        }

    }
}

