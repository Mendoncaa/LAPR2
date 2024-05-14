package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization.AssignSkillController;

import java.util.Scanner;

public class AssignSkillUI {
    private AssignSkillController controller;
    private Scanner scanner;

    public AssignSkillUI(AssignSkillController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Please enter the collaborator ID:");
        String teamMemberId = scanner.nextLine();

        System.out.println("Please enter the skill ID");
        String skillId = scanner.nextLine();

        boolean success = controller.assignSkillToTeamMember(teamMemberId, skillId);

        if (success) {
            System.out.println("Skill successfully assigned to the employee!");
        } else {
            System.out.println("Failed to assign the skill to the collaborator. Please try again.");
        }
    }
}
