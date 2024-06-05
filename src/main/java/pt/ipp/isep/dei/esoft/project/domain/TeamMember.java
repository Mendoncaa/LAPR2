package pt.ipp.isep.dei.esoft.project.domain;

import java.util.*;

/**
 * Class representing a team member with a unique ID, name, and a list of skills.
 */
public class TeamMember {
    private String id;
    private String name;
    private List<Skill> skills;


/**
 * Constructor for TeamMember.
 * Generates a unique ID and initializes the list of skills.
 *
 * @param name The name of the team member.
 */
    public TeamMember(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString(); //
        this.skills = new ArrayList<>();
    }

/**
 * Gets the unique ID of the team member.
 *
 * @return The team member's ID.
 */
    public String getId() {
        return id;
    }

/**
 * Gets the name of the team member.
 *
 * @return The team member's name.
 */
    public String getName() {
        return name;
    }

/**
 * Gets the list of skills associated with the team member.
 *
 * @return A list of skills.
 */
    public List<Skill> getSkills() {
        return skills;
    }


/**
 * Adds a skill to the team member's skill list if it is not already present.
 *
 * @param skill The skill to be added.
 */
    public void addSkill(Skill skill) {

        if (!skills.contains(skill)) {

            skills.add(skill);

        }

    }
}

