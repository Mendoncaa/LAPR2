# US005 - Generate a team

## 4. Tests 

**Test 1:** Check that it is not possible to create a Team with a size out of the specified bounds. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureTeamSizeIsWithinBounds() {
    	TeamService teamService = new TeamService(new EmployeeRepository());
    	teamService.generateTeam(0, 5, Arrays.asList("skill1", "skill2"));
	}
	

**Test 2:**  Ensure that a team cannot be created without required skills being specified. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureTeamRequiresSkills() {
    	TeamService teamService = new TeamService(new EmployeeRepository());
    	teamService.generateTeam(1, 3, new ArrayList<>()); 
	}

**Test 3**: Validate that a team cannot have employees assigned without the matching skills.

	@Test
		public void ensureEmployeesHaveRequiredSkills() {
    	TeamService teamService = new TeamService(new EmployeeRepository());
    	Team team = teamService.createTeam(2, 4);
    
    	Employee employeeWithSkill = new Employee("John Doe", "Developer", Arrays.asList("Java", "SQL"));
    	Employee employeeWithoutSkill = new Employee("Jane Smith", "Analyst", Arrays.asList("Excel"));
    
    	
    	team.assignEmployee(employeeWithSkill);
    
    	try {
        
        team.assignEmployee(employeeWithoutSkill);
        fail("Expected an IllegalArgumentException to be thrown");
    	} catch (IllegalArgumentException e) {
        assertEquals("Employee does not have the required skill.", e.getMessage());
    	}
	}

**Test 4**: Check that the team approval and rejection process works as expected.

	@Test
		public void ensureTeamApprovalAndRejection() {
    	TeamService teamService = new TeamService(new EmployeeRepository());
    	Team team = teamService.createTeam(1, 2);

    	teamService.confirmTeam(team);
    	assertTrue("Team should be marked as confirmed.", team.isConfirmed());

    	teamService.rejectTeam(team);
    	assertFalse("Team should be marked as not confirmed after rejection.", team.isConfirmed());
	}







## 5. Construction (Implementation)

### Class HRMController



### Class Team




## 6. Integration and Demo 




## 7. Observations

n/a