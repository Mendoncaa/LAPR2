# US001 - As a HRM, I want to register skills that may be appointed to a collaborator.

## 4. Tests 

**Test 1:** Checks the functionality of creating a new skill in the system 

	@Test
    void createSkillWithValidName() {
        String skillName = "Test Skill";
        boolean expResult = true;
        boolean result = controller.createSkill(skillName);
        assertEquals(expResult, result);
    }

**Test 2:** Checks the functionality of creating a new skill in the system when the skill name is invalid

    @Test
    void createSkillWithInvalidName() {
        String skillName = "Test Skill 123";
        boolean expResult = false;
        boolean result = controller.createSkill(skillName);
        assertEquals(expResult, result);
    }

**Test 3:** Checks the functionality of the SkillRepository class constructor and the initial behavior of the skill list

    @Test
    void testConstructor() {
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.getSkills();
        assertTrue(skillRepository.getSkills().isEmpty());
    }
	

**Test 4:** Checks the functionality of the getSkillById method of the SkillRepository class

    @Test
    void testGetSkillById_found() {
        SkillRepository skillRepository = new SkillRepository();
        Skill skill = new Skill("Programming");
        skillRepository.addSkill(skill);
        assertEquals(skill, skillRepository.getSkillById(skill.getId()));
    }
	

**Test 5:** Checks the functionality of the SkillRepository class's getSkillById method when the provided ID does not match any existing skills

    @Test
    void testGetSkillById_notFound() {
        SkillRepository skillRepository = new SkillRepository();
        assertNull(skillRepository.getSkillById("nonexistentId"));
    }

**Test 6:** Checks the functionality of the createTeamMember method of the TeamMemberRepository class

    @Test
    void testCreateTeamMember() {
        TeamMember teamMember = teamMemberRepository.createTeamMember("João Gomes");
        assertNotNull(teamMember);
        assertEquals("João Gomes", teamMember.getName());
    }
    
**Test 7:** Checks the functionality of the getTeamMemberById method of the TeamMemberRepository class

    @Test
    void testGetTeamMemberById() {
        TeamMember teamMember = teamMemberRepository.createTeamMember("João Gomes");
        TeamMember fetchedTeamMember = teamMemberRepository.getTeamMemberById(teamMember.getId());
        assertEquals(teamMember, fetchedTeamMember);
    }

**Test 8:** Checks the functionality of the deleteTeamMember method of the TeamMemberRepository class

    @Test
    void testDeleteTeamMember() {
        TeamMember teamMember = teamMemberRepository.createTeamMember("João Gomes");
        teamMemberRepository.deleteTeamMember(teamMember.getId());
        assertNull(teamMemberRepository.getTeamMemberById(teamMember.getId()));
    }

**Test 9:** Checks the functionality of the Team Member class constructor

    @Test
    void testConstructor() {
        TeamMember teamMember = new TeamMember("Pedro Gomes");
        assertEquals("Pedro Gomes", teamMember.getName());
        assertTrue(teamMember.getSkills().isEmpty());
    }

**Test 10:** Checks the functionality of the add Skill method of the Team Member class

    @Test
    void testAddSkill() {
        TeamMember teamMember = new TeamMember("Pedro Gomes");
        Skill skill = new Skill("Programming");
        teamMember.addSkill(skill);
        assertTrue(teamMember.getSkills().contains(skill));
    }

**Test 11:** Checks the functionality of the Skill class constructor

    @Test
    void testConstructor_validName() {
        Skill skill = new Skill("Programming");
        assertEquals("Programming", skill.getName());
    }

**Test 12:** Checks the functionality of the getId method of the Skill class

    @Test
    void testGenerateId() {
        Skill skill1 = new Skill("Programming");
        Skill skill2 = new Skill("Design");
        assertNotEquals(skill1.getId(), skill2.getId());
    }



## 5. Construction (Implementation)

### Class CreateSkillController 

```java
public class CreateSkillController {
    private SkillRepository skillRepository;

    public CreateSkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     *
     * @param skillName
     * @return Checks whether the skill name contains special characters or digits
     */
    public boolean createSkill(String skillName) {

        if (!skillName.matches("[a-zA-Z ]+")) {
            System.out.println("The skill name cannot contain special characters or digits.");
            return false;
        }

        Skill skill = new Skill(skillName);
        skillRepository.addSkill(skill);
        return true;
    }
}
```

### Class Organization

```java

public class TeamMember {
    private String id;
    private String name;
    private List<Skill> skills;

    public TeamMember(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString(); //
        this.skills = new ArrayList<>();
    }


    public class Skill {
        private String id;
        private String name;

        public Skill(String name) {
            // Checks whether the skill name contains special characters or digits
            if (!name.matches("[a-zA-Z ]+")) {
                throw new IllegalArgumentException("The skill name cannot contain special characters or digits.");
            }
            this.name = name;
            this.id = generateId();
        }
    }
}
```


## 6. Integration and Demo 



## 7. Observations

n/a