package pt.ipp.isep.dei.esoft.project.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillRepository;
import pt.ipp.isep.dei.esoft.project.repository.application.session.UserSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CreateSkillControllerTest {

    @org.junit.Test
    public void createSkillTest() {

        // Setup do ambiente de teste
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
                new Job("Gardener"));

        // Criação do controller
        CreateSkillController createSkillController = new CreateSkillController();

        // Dados da habilidade
        String skillName = "Programação";

        // Chamada do método para criar a habilidade
        Optional<Skill> skillOptional = createSkillController.createSkill(skillName);

        // Verificação se a habilidade foi criada com sucesso
        assertTrue(skillOptional.isPresent());
        Skill skill = skillOptional.get();
        assertEquals(skillName, skill.getName());
    }

    @org.junit.Test
    public void addSkillTest() {
        // Setup do ambiente de teste
        SkillRepository skillRepository = new SkillRepository();

        // Criação de uma nova habilidade
        Skill skill = new Skill("Programação");

        // Adiciona a habilidade ao repositório
        skillRepository.addSkill(skill);

        // Lista as habilidades e verifica se a habilidade foi adicionada corretamente
        List<Skill> skills = skillRepository.listAllSkills();
        assertEquals(1, skills.size());
        assertEquals(skill, skills.get(0));
    }

}


