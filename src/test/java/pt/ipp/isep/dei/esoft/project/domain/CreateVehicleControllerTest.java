package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateVehicleController;

import java.time.LocalDate;
import java.util.Optional;

public class CreateVehicleControllerTest {

        @Test
        void testCreateVehicle() {
            // Criar um repositório simulado manualmente
            VehicleRepository repository = new VehicleRepository();

            // Criar um controlador com o repositório simulado
            CreateVehicleController controller = new CreateVehicleController();

            // Chamar o método createVehicle no controlador
            Optional<Vehicle> result = controller.createVehicle(new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                    50000, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 1), 10000));


            // Verificar se o resultado é verdadeiro
            assertTrue(result.isPresent());

            // Verificar se o método addVehicle foi chamado no repositório
            assertEquals(1, repository.getVehicles().size());
        }
    }

