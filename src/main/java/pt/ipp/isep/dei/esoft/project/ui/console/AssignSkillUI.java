package pt.ipp.isep.dei.esoft.project.ui.console;


import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.controller.authorization.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * This class represents the UI for assigning skills to team members.
 * It implements the Runnable interface to allow the operation to be run on a separate thread.
 */
public class AssignSkillUI implements Runnable {
    private final AssignSkillController controller;

/**
* Initializes a new AssignSkillUI with a new AssignSkillController.
 */
    public AssignSkillUI() {
        controller = new AssignSkillController();
    }

/**
* Gets the AssignSkillController.
*
* @return the controller
 */
    private AssignSkillController getController() {
        return controller;
    }
    private Scanner scanner = new Scanner(System.in);

    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();

/**
 * Runs the UI to assign a skill to a team member.
 * Lists employees and skills, allows user to select one of each, and assigns the selected skill to the selected employee.
 */
    public void run() {
        List<Employee> optionsEmployee = employeeRepository.listEmployees();
        Employee employee = null;

        int optionEmployee;
        do {

            optionEmployee = Utils.showAndSelectIndex(optionsEmployee, "\n\n--- YOUR EMPLOYEES -------------------------");

            if (optionEmployee == -1) {
                return;
            }

            if ((optionEmployee >= 0) && (optionEmployee < optionsEmployee.size())) {

                employee = optionsEmployee.get(optionEmployee);

            }

        } while (optionEmployee < 0 || optionEmployee > optionsEmployee.size());

        List<Skill> optionsSkills = skillRepository.getSkills();
        Skill skill = null;

        int optionSkill;
        do {

            optionSkill = Utils.showAndSelectIndex(optionsSkills, "\n\n--- YOUR EMPLOYEES -------------------------");

            if (optionSkill == -1) {
                return;
            }

            if ((optionSkill >= 0) && (optionSkill < optionsSkills.size())) {

                skill = optionsSkills.get(optionSkill);

            }

        } while (optionSkill < 0 || optionEmployee > optionsSkills.size());

        System.out.printf("Are your sure you want to add %s to %s? (Y/N): ", skill, employee);
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            submitData(employee, skill);
        } else {
            System.out.println("Operation canceled by the user.");
        }


    }

/**
 * Submits the selected data to the controller to assign the skill to the employee.
*
* @param employee the employee to whom the skill is to be assigned
* @param skill the skill to be assigned to the employee
 */
    private void submitData(Employee employee, Skill skill) {
        try {
            controller.assignSkillToTeamMember(employee, skill);
            if (employee.hasSkill(skill)) {
                System.out.println("\nA new skill has been successfully added to: " + employee);
            } else {
                System.out.println("\nSkill not added!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred while adding the skill: " + e.getMessage());
        }
    }
}
