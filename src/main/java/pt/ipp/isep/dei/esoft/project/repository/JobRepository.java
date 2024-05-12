package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import java.util.ArrayList;
import java.util.List;

public class JobRepository {
    private List<Job> jobs;

    public JobRepository() {
        this.jobs = new ArrayList<>();
    }

    /**
     * Adiciona um trabalho ao repositório.
     * @param job O trabalho a ser adicionado.
     */
    public void addJob(Job job) {
        // Verifica se já existe um trabalho com o mesmo nome na organização
        if (isJobNameDuplicate(job.getJobName())) {
            throw new IllegalArgumentException("Já existe um trabalho com o mesmo nome na organização.");
        }

        jobs.add(job);
    }

    /**
     * Verifica se já existe um trabalho com o mesmo nome na organização.
     * @param jobName O nome do trabalho a ser verificado.
     * @return true se um trabalho com o mesmo nome já existir na organização, false caso contrário.
     */
    private boolean isJobNameDuplicate(String jobName) {
        return jobs.stream().anyMatch(job -> job.getJobName().equalsIgnoreCase(jobName));
    }

    /**
     * Obtém todos os trabalhos no repositório.
     * @return Uma lista de todos os trabalhos no repositório.
     */
    public List<Job> getAllJobs() {
        return new ArrayList<>(jobs);
    }
}

