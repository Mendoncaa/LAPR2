package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class that manages Job objects.
 */
public class JobRepository {
    private List<Job> jobs;

    /**
     * Constructor for the JobRepository class.
     */
    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Adds a job to the repository.
     * @param job The job to add.
     */
    public void addJob(Job job) throws IllegalArgumentException {
        jobs.add(job);
    }

    /**
     * Lists all jobs in the repository.
     * @return A list of all jobs.
     */
    public List<Job> listAllJobs() {
        return new ArrayList<>(jobs);
    }

    public Job getJobByName(String name) {
        for (Job job : jobs) {
            if (job.getJobName().equals(name)) {
                return job;
            }
        }
        throw new IllegalArgumentException("No job with the typed name!!");
    }
}


