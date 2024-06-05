# US0027 - As a GSM, I need to list all green spaces managed by me.

## 4. Tests 

**Test 1:** Check if the list of green spaces is sorted by size in descending order

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Job instance = new Job(null);
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