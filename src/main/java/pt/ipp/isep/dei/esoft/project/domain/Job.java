package pt.ipp.isep.dei.esoft.project.domain;

/**
 * Classe que representa um trabalho.
 */
public class Job {
    private String jobName;

    /**
     * Construtor da classe Job.
     * @param jobName O nome do trabalho.
     * @throws IllegalArgumentException Se o nome do trabalho não atender aos critérios especificados.
     */
    public Job(String jobName) {
        setJobName(jobName);
    }

    /**
     * Define o nome do trabalho.
     * @param jobName O nome do trabalho.
     * @throws IllegalArgumentException Se o nome do trabalho não atender aos critérios especificados.
     */
    public void setJobName(String jobName) {
        // Verifica se o nome do trabalho contém apenas letras e espaços
        if (!jobName.matches("^[a-zA-Z ]+$")) {
            throw new IllegalArgumentException("O nome do trabalho não pode conter caracteres especiais ou dígitos.");
        }
        // Verifica se o nome do trabalho contém pelo menos uma palavra
        if (jobName.split(" ").length < 1) {
            throw new IllegalArgumentException("O nome do trabalho deve conter pelo menos uma palavra.");
        }
        this.jobName = jobName;
    }

    /**
     * Obtém o nome do trabalho.
     * @return O nome do trabalho.
     */
    public String getJobName() {
        return jobName;
    }
}
