package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.VFMController;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.authorization.AssignSkillController;

import static org.junit.jupiter.api.Assertions.*;


public class VFMControllerTest {

    @Test
    void testNeedsCheckup() {
        VFMController vfmController = new VFMController();

        Vehicle vehicle = new Vehicle("ABC123", "Toyota", "Camry", "Sedan", 1500, 2000, 10000, "2022-01-01", "2021-01-01", 5000); // Adjust parameters as needed

        boolean expResult = false;
        // boolean result = vfmController.needsCheckup(vehicle);


        // assertEquals(expResult, result);
    }

    @Test
    void testCalculateNextCheckup() {
        // Instantiate the VFMController
        VehicleRepository vehicleRepository = new VehicleRepository(); // Or use your implementation
        VFMController vfmController = new VFMController();


    }
}
