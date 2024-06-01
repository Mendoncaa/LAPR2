package pt.ipp.isep.dei.esoft.project.controller;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.ArrayList;
import java.util.List;

public class ToDoListController {



    public List<GreenSpace> getAvailabreGreenSpaces() {
        Repositories repositories = Repositories.getInstance();
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();
        List<GreenSpace> spacesManagedByMe = new ArrayList<>();
        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            if (greenSpace.getManagedBy().equals(userSession.getUserId())) {
                spacesManagedByMe.add(greenSpace);
            }
        }

        return spacesManagedByMe;
    }
}
