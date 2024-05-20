package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JobRepositoryTest {

    private JobRepository jobRepository;

    @BeforeEach
    public void setUp() {
        jobRepository = new JobRepository();
    }

    @Test
    public void testAddJob() {
        Job job = new Job("Software Engineer");
        jobRepository.addJob(job);
        List<Job> jobs = jobRepository.listAllJobs();
        assertEquals(1, jobs.size());
        assertEquals("Software Engineer", jobs.get(0).getJobName());
    }

    @Test
    public void testAddMultipleJobs() {
        Job job1 = new Job("Software Engineer");
        Job job2 = new Job("Data Scientist");
        jobRepository.addJob(job1);
        jobRepository.addJob(job2);
        List<Job> jobs = jobRepository.listAllJobs();
        assertEquals(2, jobs.size());
        assertEquals("Software Engineer", jobs.get(0).getJobName());
        assertEquals("Data Scientist", jobs.get(1).getJobName());
    }

    @Test
    public void testAddJobWithInvalidNameContainingDigits() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Job job = new Job("Engineer123");
            jobRepository.addJob(job);
        });
        assertEquals("The job name cannot contain special characters or digits.", thrown.getMessage());
    }

    @Test
    public void testAddJobWithInvalidNameContainingSpecialCharacters() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Job job = new Job("Engineer@Home");
            jobRepository.addJob(job);
        });
        assertEquals("The job name cannot contain special characters or digits.", thrown.getMessage());
    }

    @Test
    public void testAddJobWithEmptyName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Job job = new Job("");
            jobRepository.addJob(job);
        });
        assertEquals("The job name cannot be empty.", thrown.getMessage());
    }

    @Test
    public void testAddJobWithOnlySpaces() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Job job = new Job("   ");
            jobRepository.addJob(job);
        });
        assertEquals("The job name cannot be empty.", thrown.getMessage());
    }

    @Test
    public void testAddJobWithNullName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Job job = new Job(null);
            jobRepository.addJob(job);
        });
        assertEquals("The job name cannot be empty.", thrown.getMessage());
    }

    @Test
    public void testListAllJobsEmpty() {
        List<Job> jobs = jobRepository.listAllJobs();
        assertTrue(jobs.isEmpty());
    }

    @Test
    public void testListAllJobsImmutable() {
        Job job = new Job("Software Engineer");
        jobRepository.addJob(job);
        List<Job> jobs = jobRepository.listAllJobs();
        jobs.clear(); // Attempt to modify the returned list
        jobs = jobRepository.listAllJobs(); // Get the list again
        assertEquals(1, jobs.size()); // Original list should remain unchanged
    }
}
