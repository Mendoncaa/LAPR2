package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class AssignSkillController {
    private final SkillRepository skillRepository;
    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    public void listEmployees() {
        List<Employee> options = employeeRepository.listEmployees();
        int option;
        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- HRM MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {



            }

        } while (option != -1);
    }

    public AssignSkillController() {
        this.skillRepository = Repositories.getInstance().getSkillRepository();
    }

    public boolean assignSkillToTeamMember(String teamMemberId, String skillId) {
        Skill skill = skillRepository.getSkillById(skillId);
        if (skill == null) {
            System.out.println("Skill not found");
            return false;
        }

        return true;
    }
}



