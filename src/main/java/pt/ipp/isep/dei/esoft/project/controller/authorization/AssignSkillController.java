package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.TeamMember;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

/**
 * Controller responsible for assigning skills to team members.
 */
public class AssignSkillController {
    private final SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

/**
* Assigns a skill to a team member.
*
* @param employee the employee to whom the skill will be assigned
* @param skill the skill to be assigned to the employee
 */
    public void assignSkillToTeamMember(Employee employee, Skill skill) {
        employee.assignSkill(skill);
    }

}



