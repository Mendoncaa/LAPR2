package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.List;
import java.util.Optional;

public class ListGSManagedByMeController {
    private SortingConfigAdapter sortingAdapter;

    /**
     * Retrieves a list of GreenSpaces in the agenda of the current GSM user.
     *
     * @return The list of tasks.
     * @throws IllegalArgumentException If the user is not authorized or if the organization is not found.
     */
    public List<Task> listThisGsmTasksInAgenda() throws IllegalArgumentException {
        Repositories repositories = Repositories.getInstance();
        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository()
                    .getOrganizationByEmployeeEmail(userEmail);
            if (organizationOptional.isPresent()) {
                EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
                Employee employee = employeeRepository.getEmployeeById(userEmail);
                return employee.getGreenSpacesManagedByMe(userEmail);
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not a GSM authorized.");
        }
    }

    public ListGSManagedByMeController(SortingConfigAdapter sortingAdapter) {
        this.sortingAdapter = sortingAdapter;
    }

    public List<String> getAvailableSortingAlgorithms() {
        return sortingAdapter.getAllSortingAlgorithmsNames();
    }

    public List<GreenSpace> sortGreenSpaces(String algorithmName, List<GreenSpace> greenSpaces) {
        // Logic to sort green spaces using the specified algorithm
        return sortingAdapter.getSortedGreenSpaces(algorithmName, greenSpaces);
    }
}


