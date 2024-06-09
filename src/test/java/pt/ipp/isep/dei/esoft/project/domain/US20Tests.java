package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class US20Tests {

    @org.junit.Test
    public void createGreenSpaceTest() {

        Employee employee = new Employee(
                "Zé",
                LocalDate.of(1992, 2, 2),
                LocalDate.of(2021, 11, 30),
                "Rua da Morada 02",
                "Porto",
                "4000-051",
                "987654336",
                "collaborator@this.app",
                "CC",
                "12345678",
                "987784321",
                new Job("Trolha"));

        String name = "Parque da Cidade";
        SizeClassification sizeClassification = SizeClassification.LARGE_SIZED_PARK;
        double area = 1000.20;
        String address = "Estrada Interior da Circunvalação, 4100-083 Porto";
        String email = "collaborator@this.app";

        GreenSpace greenSpace = employee.createGreenSpace(name, sizeClassification, area, address, email);

        assertEquals(name, greenSpace.getName());
        assertEquals(sizeClassification, greenSpace.getSizeClassification());
        assertEquals(area, greenSpace.getArea(), 0);
        assertEquals(address, greenSpace.getAddress());
        assertEquals(email, greenSpace.getEmail());
    }

    @org.junit.Test
    public void addGreenSpaceTest() {
        GreenSpaceRepository greenSpaceRepository = new GreenSpaceRepository();

        GreenSpace greenSpace = new GreenSpace("Parque Maia", SizeClassification.MEDIUM_SIZED_PARK
                , 1, "rua 1234", "gsm@this.app");

        greenSpaceRepository.addGreenSpace(greenSpace);

        List<GreenSpace> greenSpaces = greenSpaceRepository.listGreenSpaces();
        assertEquals(1, greenSpaces.size());
        assertEquals(greenSpace, greenSpaces.get(0));
    }

}
