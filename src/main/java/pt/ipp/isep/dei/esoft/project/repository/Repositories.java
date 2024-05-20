package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

public class Repositories {

    private static Repositories instance;
    private final OrganizationRepository organizationRepository;
    private final TaskCategoryRepository taskCategoryRepository;
    private final AuthenticationRepository authenticationRepository;
    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;
    private final TeamRepository teamRepository;
    private final VehicleRepository vehicleRepository;
    private final TeamMemberRepository teamMemberRepository;

    /**
     *
     */
    private Repositories() {
        organizationRepository = new OrganizationRepository();
        taskCategoryRepository = new TaskCategoryRepository();
        authenticationRepository = new AuthenticationRepository();
        skillRepository = new SkillRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        teamRepository = new TeamRepository();
        teamMemberRepository = new TeamMemberRepository();
    }

    public static Repositories getInstance() {
        if (instance == null) {
            synchronized (Repositories.class) {
                instance = new Repositories();
            }
        }
        return instance;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public SkillRepository getSkillRepository() {
        return skillRepository;
    }

    public JobRepository getJobRepository() {return jobRepository; }

    public VehicleRepository getVehicleRepository() {return vehicleRepository;}

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public TeamMemberRepository getTeamMemberRepository() {
        return teamMemberRepository;
    }
}

