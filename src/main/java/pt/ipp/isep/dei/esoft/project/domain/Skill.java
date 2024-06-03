package pt.ipp.isep.dei.esoft.project.domain;

import java.util.UUID;

public class Skill implements Comparable<Skill> {
    private String id;
    private String name;

    public Skill(String name) {
        this.id = generateId();
        setSkillName(name);
    }



    public void setSkillName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The skill name cannot be empty.");
        }

        if (!name.matches("^[a-zA-Z ]+$")) {
            throw new IllegalArgumentException("The skill name cannot contain special characters or digits.");
        }

        if (name.split(" ").length < 1) {
            throw new IllegalArgumentException("The skill name must contain at least one word.");
        }
        this.name = name;
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

    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Skill skill) {
        return this.name.compareTo(skill.name);
    }
}

