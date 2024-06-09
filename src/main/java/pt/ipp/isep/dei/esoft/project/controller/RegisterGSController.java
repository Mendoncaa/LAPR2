package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.User;

import java.util.Optional;

public class RegisterGSController {
    private final AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    private final GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    public Optional<GreenSpace> RegisterGreenSpace(String name, SizeClassification sizeClassification,
                                               double area, String address) {

        UserSession userSession = authenticationRepository.getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = Repositories.getInstance().getOrganizationRepository()
                    .getOrganizationByEmployeeEmail(userEmail);
            EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();


            if (organizationOptional.isPresent()) {
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                GreenSpace greenSpace = employee.createGreenSpace(name, sizeClassification, area, address,
                        userSession.getUserId().getEmail());
                greenSpaceRepository.addGreenSpace(greenSpace);

                return Optional.of(greenSpace);
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not authorized to create a job.");
        }

    }

    public UserSession getUserSession() {
        return authenticationRepository.getCurrentUserSession();
    }

}
