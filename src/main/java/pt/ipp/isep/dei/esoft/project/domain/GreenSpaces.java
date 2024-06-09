package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;

public class GreenSpaces {
    Repositories repositories = Repositories.getInstance();
    public List<GreenSpace> getGreenSpacesManagedByMe() {
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();
        List<GreenSpace> spacesManagedByMe = new ArrayList<>();

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            if (greenSpace.getEmail().equals(userSession.getUserId().getEmail())) {
                spacesManagedByMe.add(greenSpace);
            }
        }

        return spacesManagedByMe;
    }
}
