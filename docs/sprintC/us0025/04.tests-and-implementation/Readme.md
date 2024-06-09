# US0025 - Cancel an entry in the Agenda

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

**Test 3:** Ensure Vehicle Creation with invalida Register Date in not allowed
    
    @Test
    public void testCreateVehicleWithInvalidRegisterDate() {
    assertThrows(IllegalArgumentException.class, () -> {
    Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
    50000, null, "2022-01-01", 10000);
    });
    }

**Test 4:** Ensure Vehicle creation with valid data

    @Test
    void testCreateVehicle() {
    Vehicle vehicle = new Vehicle("AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,
    50000, "2022-01-01", "2022-01-01", 10000);
    
            assertEquals("AB123CD", vehicle.getPlateID());
            assertEquals("Toyota", vehicle.getBrand());
            assertEquals("Corolla", vehicle.getModel());
            assertEquals("Sedan", vehicle.getType());
            assertEquals(1200, vehicle.getTare());
            assertEquals(1500, vehicle.getGrossWeight());
            assertEquals(50000, vehicle.getCurrentKms());
            assertEquals("2022-01-01", vehicle.getRegisterString());
            assertEquals("2022-01-01", vehicle.getAcquisitionString());
            assertEquals(10000, vehicle.getCheckUpFrequencyInKms());
        }

**Test 5:** Verifies if in a vehicle repository a vehicle can be added or retrieved by it's plate ID

[//]: # ()
[//]: # ()
[//]: # (    @Test)

[//]: # (    void testAddVehicleAndGetVehicleByPlateId&#40;&#41; {)

[//]: # (        VehicleRepository repository = new VehicleRepository&#40;&#41;;)

[//]: # (        Vehicle vehicle = new Vehicle&#40;"AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,)

[//]: # (                50000, "2022-01-01", "2022-01-01", 10000&#41;;)

[//]: # (        repository.addVehicle&#40;vehicle&#41;;)

[//]: # ()
[//]: # (        assertEquals&#40;vehicle, repository.getVehicleByPlateId&#40;"AB123CD"&#41;&#41;;)

[//]: # (    })

[//]: # (        @Test)

[//]: # (        void testCreateVehicle&#40;&#41; {)

[//]: # (            // Criar um repositório simulado manualmente)

[//]: # (            VehicleRepository repository = new VehicleRepository&#40;&#41;;)

[//]: # ()
[//]: # (            // Criar um controlador com o repositório simulado)

[//]: # (            CreateVehicleController controller = new CreateVehicleController&#40;repository&#41;;)

[//]: # ()
[//]: # (            // Chamar o método createVehicle no controlador)

[//]: # (            boolean result = controller.createVehicle&#40;"AB123CD", "Toyota", "Corolla", "Sedan", 1200, 1500,)

[//]: # (                    50000, "2022-01-01", "2022-01-01", 10000&#41;;)

[//]: # ()
[//]: # (            // Verificar se o resultado é verdadeiro)

[//]: # (            assertTrue&#40;result&#41;;)

[//]: # ()
[//]: # (            // Verificar se o método addVehicle foi chamado no repositório)

[//]: # (            assertEquals&#40;1, repository.getVehicles&#40;&#41;.size&#40;&#41;&#41;;)

[//]: # (        })

[//]: # (    })

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