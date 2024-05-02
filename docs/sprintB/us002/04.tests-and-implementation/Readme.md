# US002 - As an HRM, I want to register a job.

## 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Job class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Job instance = new Job(null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Job class with a name containing special characteres or digits - AC1. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNameMeetsAC1() {
		Job instance = new Job("Ab1");
	}

_It is also recommended to organize this content by subsections._ 


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

* A new option on the Employee menu options was added.

* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a