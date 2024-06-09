package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pt.ipp.isep.dei.esoft.project.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class US21Tests {

    @Test
    public void getGreenSpacesManagedByMeTest() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        GreenSpaces greenSpaces = new GreenSpaces();


        String email = "gsm@this.app";
        List<GreenSpace> result = greenSpaces.getGreenSpacesManagedByMe(email);

        // Verifying the result
        assertEquals(1, result.size());
        assertEquals("Parque da cidade", result.get(0).getName());
    }

}


