package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;

import java.util.Scanner;

public class CreateSkillUI {
    private CreateSkillController controller;
    private Scanner scanner;

    public CreateSkillUI(CreateSkillController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Please, enter the skill name:");
        String skillName = scanner.nextLine();

        // Checks whether the skill name contains special characters or digits
        if (!skillName.matches("[a-zA-Z ]+")) {
            System.out.println("The skill name cannot contain special characters or digits.");
            return;
        }

        boolean success = controller.createSkill(skillName);

        if (success) {
            System.out.println("Skill created successfully!");
        } else {
            System.out.println("Failed to create the skill. Please try again.");
        }
    }
}


