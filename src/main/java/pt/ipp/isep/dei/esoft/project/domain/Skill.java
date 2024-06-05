package pt.ipp.isep.dei.esoft.project.domain;

import java.util.UUID;

/**
 * Class representing a skill with a unique ID and a name.
 * Implements Comparable to allow comparison based on the skill name.
 */
public class Skill implements Comparable<Skill> {
    private String id;
    private String name;

/**
 * Constructor for Skill.
 * Generates a unique ID and sets the skill name.
 *
 * @param name The name of the skill.
 */
    public Skill(String name) {
        this.id = generateId();
        setSkillName(name);
    }

/**
 * Sets the skill name after validating it.
 *
 * @param name The name of the skill.
 * @throws IllegalArgumentException If the name is empty, contains special characters or digits, or doesn't contain at least one word.
 */

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
 * Generates a universally unique identifier (UUID) for the skill.
 *
 * @return A string representing a random UUID.
 */
    private String generateId() {
        return UUID.randomUUID().toString();
    }

/**
 * Gets the unique ID of the skill.
 *
 * @return The skill ID.
 */
    public String getId() {
        return id;
    }

/**
 * Gets the name of the skill.
 *
 * @return The skill name.
 */
    public String getName() {
        return name;
    }


/**
 * Returns a string representation of the skill.
 *
 * @return A string representation of the skill, including its ID and name.
 */
    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


/**
 * Compares this skill to another skill based on their names.
 *
 * @param skill The skill to be compared with.
 * @return A negative integer, zero, or a positive integer as this skill name is less than, equal to, or greater than the specified skill name.
 */
    @Override
    public int compareTo(Skill skill) {
        return this.name.compareTo(skill.name);
    }
}

