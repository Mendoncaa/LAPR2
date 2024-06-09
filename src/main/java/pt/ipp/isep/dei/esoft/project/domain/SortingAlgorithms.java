package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

public interface SortingAlgorithms {
    List<GreenSpace> getSortedGreenSpaces(String algorithm, List<GreenSpace> greenSpaces);
}

