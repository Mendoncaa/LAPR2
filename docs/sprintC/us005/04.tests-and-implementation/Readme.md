# US005 - Generate a team

## 4. Tests 

**Test 1:** Check if the team is saved properly on the List

	@Test
    public void testTeamRepositoryIsNotEmptyAfterCreation() {
        TeamService teamService = new TeamService();
        TeamRepository teamRepository = new TeamRepository();

        TeamMember member1 = new TeamMember("John");
        TeamMember member2 = new TeamMember("Alice");

        member1.addSkill(new Skill("Python"));
        member2.addSkill(new Skill("Java"));

        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Python"));
        skills.add(new Skill("Java"));

        List<TeamMember> teamMembers = new ArrayList<>();
        teamMembers.add(member1);
        teamMembers.add(member2);

        teamService.teamApproved(new Team(2, 4, skills, teamMembers));

        assertFalse(teamRepository.getTeams().isEmpty());
    }
	

**Test 2:**  Ensures that the verification of a collaborator being in a team is working.

	@Test
    public void testIsInAnyTeam_ReturnsTrueWhenMemberIsInTeam() {

        List<TeamMember> members = new ArrayList<>();
        TeamMember teamMember = new TeamMember("John");
        members.add(teamMember);
        Team team = new Team(3, 5, new ArrayList<>(), members);


        TeamRepository teamRepository = new TeamRepository();
        teamRepository.createTeam(team.getMinSize(), team.getMaxSize(), team.getSkills(), team.getTeamMembers());


        TeamMemberRepository teamMemberRepository = new TeamMemberRepository();
        boolean isInTeam = teamMemberRepository.isInAnyTeam(teamMember);


        assertTrue(isInTeam);

    }

**Test 3:** Ensures the team creation has been done properly

    @Test
    public void testCreateTeam() {
        
        int minSize = 2;
        int maxSize = 5;
        List<Skill> skills = new ArrayList<>();
        List<TeamMember> teamMembers = new ArrayList<>();


        Team createdTeam = teamRepository.createTeam(minSize, maxSize, skills, teamMembers);


        assertNotNull(createdTeam);
        assertEquals(1, teamRepository.getTeams().size());
        assertEquals(minSize, createdTeam.getMinSize());
        assertEquals(maxSize, createdTeam.getMaxSize());
        assertEquals(skills, createdTeam.getSkills());
        assertEquals(teamMembers, createdTeam.getTeamMembers());

    }

**Test 4:** Checks if getTeams method is working properly
    
    @Test
    public void testGetTeams() {

        Team team1 = new Team(3, 6, new ArrayList<>(), new ArrayList<>());
        Team team2 = new Team(2, 4, new ArrayList<>(), new ArrayList<>());

        teamRepository.getTeams().add(team1);
        teamRepository.getTeams().add(team2);


        List<Team> teams = teamRepository.getTeams();


        assertNotNull(teams);
        assertEquals(2, teams.size());
        assertTrue(teams.contains(team1));
        assertTrue(teams.contains(team2));
    }




## 5. Construction (Implementation)

### Class GenerateTeamController

```java
public class GenerateTeamController {


    private final TeamService teamService = new TeamService();



    public Team getGenerateTeam(int minSize, int maxSize, List<Skill> skills) {

        return teamService.generateTeam(minSize, maxSize, skills);

    }

    public Skill getChooseSkill(int option) {

        return teamService.chooseSkill(option);

    }

    public void getTeamApproved(Team team) {

        teamService.teamApproved(team);

    }

}
```

### Class TeamService

```java


public Team generateTeam(int minSize, int maxSize, List<Skill> skills) {

        ArrayList<TeamMember> team = new ArrayList<>();

        for (Skill skill : skills) {

            TeamMember addition = teamMemberRepository.findTeamMemberWithSkill(skill, team);

            if (addition != null) {

                team.add(addition);

            }

        }

        return new Team(minSize, maxSize, skills, team);

    }

```

## 6. Integration and Demo 




## 7. Observations

n/a