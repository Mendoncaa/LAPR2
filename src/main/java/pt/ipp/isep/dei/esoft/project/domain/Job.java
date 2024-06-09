package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Class that represents a job.
 */
public class Job implements Comparable<Job>, Serializable {
    private String jobName;

    /**
     * Constructor for the Job class.
     * @param jobName The name of the job.
     * @throws IllegalArgumentException If the job name does not meet the specified criteria.
     */
    public Job(String jobName) {
        setJobName(jobName);
    }

    /**
     * Sets the name of the job.
     * @param jobName The name of the job.
     * @throws IllegalArgumentException If the job name does not meet the specified criteria.
     */
    public void setJobName(String jobName) {
        // Verify if the job name is empty or null
        if (jobName == null || jobName.trim().isEmpty()) {
            throw new IllegalArgumentException("The job name cannot be empty.");
        }
        // Verify if the job name contains only letters and spaces
        if (!jobName.matches("^[a-zA-Z ]+$")) {
            throw new IllegalArgumentException("The job name cannot contain special characters or digits.");
        }
        // Verify if the job name contains at least one word
        if (jobName.split(" ").length < 1) {
            throw new IllegalArgumentException("The job name must contain at least one word.");
        }
        this.jobName = jobName;
    }

    /**
     * Gets the name of the job.
     * @return The name of the job.
     */
    public String getJobName() {
        return jobName;
    }

    @Override
    public int compareTo(Job other) {
        return this.jobName.compareTo(other.jobName);
    }


    @Override
    public String toString() {
        return ("job=" + jobName);
    }
}
