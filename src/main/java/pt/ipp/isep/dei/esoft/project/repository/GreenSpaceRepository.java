package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.util.ArrayList;
import java.util.List;

public class GreenSpaceRepository {

    private List<GreenSpace> greenSpaces;

    public GreenSpaceRepository() {
        this.greenSpaces = new ArrayList<>();
    }

    public List<GreenSpace> listGreenSpaces() {
        return greenSpaces;
    }


    public void addGreenSpace(GreenSpace greenSpace) {
        greenSpaces.add(greenSpace);
    }
}
