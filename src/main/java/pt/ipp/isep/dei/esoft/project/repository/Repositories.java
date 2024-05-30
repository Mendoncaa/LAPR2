package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.TeamMember;

public class Repositories {

    private static Repositories instance;
    private final OrganizationRepository organizationRepository;
    private final AuthenticationRepository authenticationRepository;
    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;
    private final TeamRepository teamRepository;
    private final VehicleRepository vehicleRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final EmployeeRepository employeeRepository;
    private final GreenSpaceRepository greenSpaceRepository;

    /**
     *
     */
    private Repositories() {
        organizationRepository = new OrganizationRepository();
        authenticationRepository = new AuthenticationRepository();
        skillRepository = new SkillRepository();
        employeeRepository = new EmployeeRepository();
        jobRepository = new JobRepository();
        vehicleRepository = new VehicleRepository();
        teamRepository = new TeamRepository();
        teamMemberRepository = new TeamMemberRepository();
        greenSpaceRepository = new GreenSpaceRepository();
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

    public EmployeeRepository getEmployeeRepository() {return employeeRepository;}

    public GreenSpaceRepository getGreenSpaceRepository() {
        return greenSpaceRepository;
    }
}

