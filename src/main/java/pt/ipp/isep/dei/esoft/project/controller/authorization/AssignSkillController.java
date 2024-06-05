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
    private final SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    public void assignSkillToTeamMember(Employee employee, Skill skill) {
        employee.assignSkill(skill);
    }

}



