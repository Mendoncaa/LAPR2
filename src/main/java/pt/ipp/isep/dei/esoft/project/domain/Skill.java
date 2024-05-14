package pt.ipp.isep.dei.esoft.project.domain;

import java.util.UUID;

public class Skill {
    private String id;
    private String name;

    public Skill(String name) {
        // Checks whether the skill name contains special characters or digits
        if (!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("The skill name cannot contain special characters or digits.");
        }
        this.name = name;
        this.id = generateId();
    }


    /**
     *
     * @return Generates a universally unique identifier (UUID) and converts it to a string, generates a string representing a random UUID, is used to generate a unique ID for each Skill or TeamMember instance
     */
    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

