package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository class for managing organizations.
 */
public class OrganizationRepository {

    private final List<Organization> organizations;


/**
 * Constructor for OrganizationRepository.
 * Initializes the list of organizations.
 */
    public OrganizationRepository() {
        organizations = new ArrayList<>();
    }

/**
 * Retrieves an organization by the email of one of its employees.
 *
 * @param email The email of the employee.
 * @return An Optional containing the organization if found, or an empty Optional if not.
 */
    public Optional<Organization> getOrganizationByEmployeeEmail(String email) {

        Optional<Organization> returnOrganization = Optional.empty();

        for (Organization organization : organizations) {
            if (organization.isEmailExists(email)) {
                returnOrganization = Optional.of(organization);
            }
        }

        return returnOrganization;
    }

    public Organization getOrganizationByVat(String vat) {
        for (Organization organization : organizations) {
            if (organization.getVatNumber().equals(vat)) {
                return organization;
            }
        }
        throw new IllegalArgumentException("No organization with that Vat Number!!");
    }


/**
 * Adds a new organization to the repository if it passes validation.
 *
 * @param organization The organization to be added.
 * @return An Optional containing the added organization if successful, or an empty Optional if not.
 */

    public Optional<Organization> add(Organization organization) {

        Optional<Organization> newOrganization = Optional.empty();
        boolean operationSuccess = false;

        if (validateOrganization(organization)) {
            newOrganization = Optional.of(organization.clone());
            operationSuccess = organizations.add(newOrganization.get());
        }

        if (!operationSuccess) {
            newOrganization = Optional.empty();
        }

        return newOrganization;

    }


/**
 * Validates if the organization can be added to the repository.
 *
 * @param organization The organization to be validated.
 * @return True if the organization is valid and can be added, false otherwise.
 */

    private boolean validateOrganization(Organization organization) {
        boolean isValid = !organizations.contains(organization);

        return isValid;
    }


    public List<Organization> getOrganizations() {
        return organizations;
    }
}