package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import static org.junit.jupiter.api.Assertions.*;

public class JobRepositoryTest {

    @Test
    public void testAddJob() {
        JobRepository repository = new JobRepository();
        Job job1 = new Job("Desenvolvedor");
        Job job2 = new Job("Tester");

        repository.addJob(job1);
        assertEquals(1, repository.getAllJobs().size());
        assertTrue(repository.getAllJobs().contains(job1));

        repository.addJob(job2);
        assertEquals(2, repository.getAllJobs().size());
        assertTrue(repository.getAllJobs().contains(job2));
    }

    @Test
    public void testAddDuplicateJob() {
        JobRepository repository = new JobRepository();
        Job job1 = new Job("Desenvolvedor");
        Job job2 = new Job("Desenvolvedor");

        repository.addJob(job1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            repository.addJob(job2);
        });

        assertEquals("Já existe um trabalho com o mesmo nome na organização.", exception.getMessage());
        assertEquals(1, repository.getAllJobs().size());
    }

    @Test
    public void testInvalidJobName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Job("1234");
        });

        assertEquals("O nome do trabalho não pode conter caracteres especiais ou dígitos.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Job("");
        });

        assertEquals("O nome do trabalho deve conter pelo menos uma palavra.", exception.getMessage());
    }
}

