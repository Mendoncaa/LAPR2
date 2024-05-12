package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization.HRMController;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HRMUI implements Runnable {

    private static HRMController controller;
    public HRMUI(HRMController controller) {
        this.controller = controller;
    }
    SkillRepository skillRepository = new SkillRepository();
    // EmployeeRepository employeeRepository = new EmployeeRepository();


    public void run() {
        int min = Utils.readIntegerFromConsole("Min team size: ");
        int max = Utils.readIntegerFromConsole("Max team size: ");
        int skills = Utils.readIntegerFromConsole("Num skills: ");
        ArrayList<TeamMember> team = new ArrayList<>();

        /* for (int i = 0; i < skills; i++) {

            chooseSkill();

            if (chooseEmployee() == null) {
                System.out.println("It isn´t possible to create that team at the moment!!");
                return;
            }

            team.add(chooseEmployee());

        } */

        Utils.showList(team, "\n\n--- Recommended Team -------------------------");
        List<String> approval = new ArrayList<String>();
        approval.add("Accept Team");
        approval.add("Reject Team");

        int option;

        do {

            option = Utils.showAndSelectIndex(approval, "\n\n--- HRM MENU -------------------------");

            if (option == 1) {
                System.out.println("Yes test");
            }

            System.out.println("You have rejected the team!!");
            return;

        } while (option != -1);
    }


    public int chooseSkill() {

        return Utils.showAndSelectIndex(skillRepository.getSkills(), "\n\n--- SKILLS -------------------------");

    }

    /* public Employee chooseEmployee(String skill, ArrayList<TeamMember> team) {

        for (Employee employee : employeeRepository) {
            if (employee.getSkill.equals(skill) && !team.contains(employee)) {
                return employee;
            }
        }

        return null;

    } */


}