# US006 - Create a Task 

## 4. Tests 

**Test 1:** Ensure Vehicle creation with null values is not allowed 

    @Test
    public void testCreateVehicleWithNullValues() {
    assertThrows(IllegalArgumentException.class, () -> {
    Vehicle vehicle = new Vehicle(null, null, null, null, 0, 0, 0, null, null, 0);
    });
    }

	

**Test 2:** Ensure Vehicle creation with plate ID less than 5 characters is not allowed. 

    @Test
    public void testCreateVehicleWithShortPlateID() {
    assertThrows(IllegalArgumentException.class, () -> {
    Vehicle vehicle = new Vehicle("Ab1", "Toyota", "Corolla", "Sedan", 1200, 1500,
    50000, "2022-01-01", "2022-01-01", 10000);
    });
    }

**Test 3:** Ensure Vehicle creation with invalid register date is not allowed
    
    @Test
    public void testCreateVehicleWithInvalidRegisterDate() {
    assertThrows(IllegalArgumentException.class, () -> {
    Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
    50000, null, "2022-01-01", 10000);
    });
    }





## 5. Construction (Implementation)

### Class CreateTaskController 

[//]: # (```java)

[//]: # (public Task createTask&#40;String reference, String description, String informalDescription, String technicalDescription,)

[//]: # (                       Integer duration, Double cost, String taskCategoryDescription&#41; {)

[//]: # ()
[//]: # (	TaskCategory taskCategory = getTaskCategoryByDescription&#40;taskCategoryDescription&#41;;)

[//]: # ()
[//]: # (	Employee employee = getEmployeeFromSession&#40;&#41;;)

[//]: # (	Organization organization = getOrganizationRepository&#40;&#41;.getOrganizationByEmployee&#40;employee&#41;;)

[//]: # ()
[//]: # (	newTask = organization.createTask&#40;reference, description, informalDescription, technicalDescription, duration,)

[//]: # (                                      cost,taskCategory, employee&#41;;)

[//]: # (    )
[//]: # (	return newTask;)

[//]: # (})

[//]: # (```)

### Class Organization

[//]: # ()
[//]: # (```java)

[//]: # (public Optional<Task> createTask&#40;String reference, String description, String informalDescription,)

[//]: # (                                 String technicalDescription, Integer duration, Double cost, TaskCategory taskCategory,)

[//]: # (                                 Employee employee&#41; {)

[//]: # (    )
[//]: # (    Task task = new Task&#40;reference, description, informalDescription, technicalDescription, duration, cost,)

[//]: # (                         taskCategory, employee&#41;;)

[//]: # ()
[//]: # (    addTask&#40;task&#41;;)

[//]: # (        )
[//]: # (    return task;)

[//]: # (})

[//]: # (```)


## 6. Integration and Demo 

[//]: # (* A new option on the Employee menu options was added.)

[//]: # ()
[//]: # (* For demo purposes some tasks are bootstrapped while system starts.)


## 7. Observations

n/a