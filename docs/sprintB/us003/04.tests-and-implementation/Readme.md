# US003 - Create a Task 

## 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Employee class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Employee instance = new Task(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Employee class with a same taxpayer id - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC2() {
		Category cat = new Category(10, "Category 10");
		
		Task instance = new Task("Ab1", "Task Description", "Informal Data", "Technical Data", 3, 3780, cat);
	}

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class CreateEmployeeController 

```java
public class CreateEmployeeController {

    private OrganizationRepository organizationRepository;
    private JobRepository jobRepository;
    private AuthenticationRepository authenticationRepository;
    private EmployeeRepository employeeRepository;

    //Repository instances are obtained from the Repositories class
    public CreateEmployeeController() {
        getOrganizationRepository();
        getAuthenticationRepository();
        getEmployeeRepository();
        getJobRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public CreateEmployeeController(OrganizationRepository organizationRepository,
                                    TaskCategoryRepository jobRepository,
                                    AuthenticationRepository authenticationRepository) {
        this.organizationRepository = organizationRepository;
        this.jobRepository = jobRepository;
        this.authenticationRepository = authenticationRepository;
    }
}
```

### Class Organization

```java
public Employee(String name, Date birthdate, Date admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) {
    this.name = name;
    this.birthdate = birthdate;
    this.admissionDate = admissionDate;
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
    this.phone = phone;
    this.email = email;
    this.idDocType = idDocType;
    this.idDocNumber = idDocNumber;
    this.taxpayerId = taxpayerId;
    this.job = job;
}
```


## 6. Integration and Demo 

* A new option on the Employee menu options was added.

* For demo purposes some tasks are bootstrapped while system starts.


## 7. Observations

n/a