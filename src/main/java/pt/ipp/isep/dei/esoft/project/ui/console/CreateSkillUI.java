package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.CreateJobController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.SizeClassification;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Optional;
import java.util.Scanner;

/**
 * This class represents the User Interface for creating a skill.
 * It implements the Runnable interface to allow it to be run in a separate thread if needed.
 */
public class CreateSkillUI implements Runnable {

    private CreateSkillController controller;
    private String name;
    private Scanner scan = new Scanner(System.in);
    private SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();

/**
 * Constructor for CreateSkillUI.
 * Initializes the controller.
 */
    public CreateSkillUI() {
        controller = new CreateSkillController();
    }


/**
 * Returns the instance of the CreateSkillController.
 * @return the instance of CreateSkillController.
 */
    private CreateSkillController getController() {
        return controller;
    }

/**
 * The main method to run the CreateSkillUI.
 * Prompts the user for the skill name and confirms the creation.
 */
    public void run() {

        System.out.println("\n\n--- Create Skill -----------------------");


       try {
           System.out.print("Please enter the skill name: ");
           name = scan.nextLine();


           System.out.print("Are you sure you want to create this skill? (Y/N): ");
           String confirmation = scan.nextLine();

           if (confirmation.equalsIgnoreCase("Y")) {
               submitData(name);
           } else {
               System.out.println("Operation canceled by the user.");
           }

       } catch (Exception e) {
            System.out.println("An error occurred while creating the skill: " + e.getMessage());
        }

    }

/**
 * Submits the skill data to be created.
 * @param skillName The name of the skill to be created.
 */

    private void submitData(String skillName) {
        try {
            Optional<Skill> skill = getController().createSkill(skillName);
            if (skill.isPresent()) {
                System.out.println("\nSkill successfully created!");
            } else {
                System.out.println("\nSkill not created!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while creating the skill: " + e.getMessage());
        }
    }
}


