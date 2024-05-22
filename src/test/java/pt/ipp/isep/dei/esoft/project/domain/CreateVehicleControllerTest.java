package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateVehicleController;

public class CreateVehicleControllerTest {

        @Test
        void testCreateVehicle() {
            // Criar um repositório simulado manualmente
            VehicleRepository repository = new VehicleRepository();

            // Criar um controlador com o repositório simulado
            CreateVehicleController controller = new CreateVehicleController(repository);

            // Chamar o método createVehicle no controlador
            boolean result = controller.createVehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
                    50000, "2022-01-01", "2022-01-01", 10000);

            // Verificar se o resultado é verdadeiro
            assertTrue(result);

            // Verificar se o método addVehicle foi chamado no repositório
            assertEquals(1, repository.getVehicles().size());
        }
    }

