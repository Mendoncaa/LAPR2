package pt.ipp.isep.dei.esoft.project.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pt.ipp.isep.dei.esoft.project.controller.authorization.CreateSkillController;
import pt.ipp.isep.dei.esoft.project.repository.*;
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
        String skillName = "Programacao";


        EmployeeRepository employeeRepository = new EmployeeRepository();
        JobRepository jobRepository = new JobRepository();
        Organization organization = new Organization("1234", employeeRepository, jobRepository);
        Skill skill = organization.createSkill(skillName);

        assertEquals(skillName, skill.getName());

    }

    @org.junit.Test
    public void addSkillTest() {
        // Setup do ambiente de teste
        SkillRepository skillRepository = new SkillRepository();

        // Criação de uma nova habilidade
        Skill skill = new Skill("Programacao");

        // Adiciona a habilidade ao repositório
        skillRepository.addSkill(skill);

        // Lista as habilidades e verifica se a habilidade foi adicionada corretamente
        List<Skill> skills = skillRepository.listAllSkills();
        assertEquals(1, skills.size());
        assertEquals(skill, skills.get(0));
    }

}


