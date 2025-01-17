package pt.ipp.isep.dei.esoft.project.controller.authorization;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Optional;

/**
 * Controller class responsible for handling the creation of skills.
 */
public class CreateSkillController {
    private Organization organization;

    private AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

/**
 * Creates a new skill if the user has the appropriate role.
 *
 * @param skillName The name of the skill to be created.
 * @return An Optional containing the created skill if successful.
 * @throws IllegalArgumentException If the user is not authorized or the organization is not found.
 */


    public Optional<Skill> createSkill(String skillName) throws IllegalArgumentException{
        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Hrm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {
                Organization organization = organizationOptional.get();
                SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
                Skill skill = organization.createSkill(skillName);
                organization.addSkill(skill, skillRepository);

                return Optional.of(skill);

            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not authorized to create a job.");
        }
    }
}





