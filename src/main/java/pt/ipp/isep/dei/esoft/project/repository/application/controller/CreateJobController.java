package pt.ipp.isep.dei.esoft.project.repository.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Optional;


public class CreateJobController {
    private Repositories repositories;

    public CreateJobController() {
        this.repositories = repositories;
    }

    /**
     * Cria um novo trabalho para a organização atual.
     *
     * @param jobName O nome do trabalho a ser criado.
     * @throws IllegalStateException Se o usuário não estiver autenticado ou não tiver permissão para criar um trabalho.
     */
    public Optional<Job> createJob(String jobName) {
        // Obtém a sessão atual
        UserSession currentUserSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        // Verifica se o usuário está logado e tem a permissão.
        if (currentUserSession != null && currentUserSession.isLoggedInWithRole("HRM")) {
            // Obtém o email do usuário atual
            String userEmail = String.valueOf(currentUserSession.getUserId());

            // Obtém a organização.
            Optional<Organization> organization = repositories.getOrganizationRepository().getOrganizationByEmployeeEmail(userEmail);

            // Verifica se a organização existe
            if (organization.isPresent()) {
                // Cria o trabalho e o adiciona à organização
                Job job = new Job(jobName);

                // Obtém o repositório de trabalhos
                JobRepository jobRepository = repositories.getJobRepository();

                // Adiciona o trabalho ao repositório
                jobRepository.addJob(job);
                System.out.println("Operação bem-sucedida: Trabalho criado.");
            } else {
                throw new IllegalStateException("Organização não encontrada para o usuário atual.");
            }
        } else {
            throw new IllegalStateException("Usuário não autenticado ou sem permissão para criar um trabalho.");
        }
        return null;
    }
}
