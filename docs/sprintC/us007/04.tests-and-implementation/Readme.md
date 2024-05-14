# US007 - Register a vehicle's check-up.

## 4. Tests 

**Test 1:** Checks a check-up with negative current kilometers

    @Test
    void testCreateCheckUpWithNegativeCurrentKms() {
    VehicleRepository vehicleRepository = new VehicleRepository();
    CreateCheckUpController controller = new CreateCheckUpController(vehicleRepository);
    
            String plateID = "AB123CD";
            String scheduleDate = "2022-05-20";
            int currentKms = -1000;
    
            boolean result = controller.createCheckUp(plateID, scheduleDate, currentKms);
    
            assertFalse(result);
        }
    


**Test 2:** Test a check-up for a non-existing vehicle

        @Test
        void testCreateCheckUpWithNonExistingVehicle() {
            VehicleRepository vehicleRepository = new VehicleRepository();
            CreateCheckUpController controller = new CreateCheckUpController(vehicleRepository);
    
            // Assuming "XYZ789" does not exist in the repository
            String plateID = "XYZ789";
            String scheduleDate = "2022-05-20";
            int currentKms = 50000;
    
            boolean result = controller.createCheckUp(plateID, scheduleDate, currentKms);
    
            assertFalse(result);
        }

[//]: # (_It is also recommended to organize this content by subsections._ )

[//]: # ()

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

[//]: # ()

## 7. Observations

n/a