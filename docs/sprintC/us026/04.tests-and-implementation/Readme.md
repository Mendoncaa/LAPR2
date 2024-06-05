# US026 - As a GSM, I want to assign one or more vehicles to an entry in the Agenda.

## 4. Tests 

**Test 1:** Check that vehicles can´t be assigned in two tasks at same time

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Job instance = new Job(null);
	}
	**AC1** - Vehicles selected must be available in the date and time of execution scheduled.


**Test 2:** Check that only Gsm of that park can assign vehicles. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNameMeetsAC1() {
		Job instance = new Job("Ab1");
	}



## 5. Construction (Implementation)

### Class CreateJobController 

```java
public Job createJob(String name) {

	
	Employee employee = getEmployeeFromSession();
	Organization organization = getOrganizationRepository().getOrganizationByEmployee(employee);

	newJob = organization.createJob(name);
    
	return newJob;
}
```

### Class Organization

```java
public Optional<Job> createJob(String name){
    
    Job job = new Job(name);

    addJob(job);
        
    return job;
}
```


## 6. Integration and Demo 




## 7. Observations

n/a