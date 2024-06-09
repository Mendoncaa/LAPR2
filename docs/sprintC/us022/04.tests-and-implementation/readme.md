# US021 - Add a New Entry to the To-Do List

## 4. Tests

### Test 1: Ensure that it is not possible to create a To-Do List entry with null values

```java
@Test
public void ensureTaskCanBePlannedInAgenda() {
    GreenSpace greenSpace = new GreenSpace("Central Park", "Large", "Main Street");
    Task task = new Task("Plant Trees", greenSpace, "Plant 100 new trees", Urgency.HIGH, 2, 8);
    Employee employee = new Employee();

    LocalDate startDate = LocalDate.of(2024, 6, 1);
    employee.planTaskInAgenda(task, startDate);

    assertEquals(Status.PLANNED, task.getStatus());
    assertEquals(startDate, task.getStartDate());
}

```

### Test 2: Ensure that it is not possible to create a To-Do List entry with an empty title

```java
@Test(expected = IllegalArgumentException.class)
public void ensureTaskCannotBePlannedWithoutStartDate() {
    GreenSpace greenSpace = new GreenSpace("Central Park", "Large", "Main Street");
    Task task = new Task("Plant Trees", greenSpace, "Plant 100 new trees", Urgency.HIGH, 2, 8);
    Employee employee = new Employee();

    employee.planTaskInAgenda(task, null);
}

```

### Test 3: Ensure that it is not possible to create a To-Do List entry with an invalid duration

```java
@Test(expected = IllegalArgumentException.class)
public void ensureTaskCannotBePlannedWithPastStartDate() {
    GreenSpace greenSpace = new GreenSpace("Central Park", "Large", "Main Street");
    Task task = new Task("Plant Trees", greenSpace, "Plant 100 new trees", Urgency.HIGH, 2, 8);
    Employee employee = new Employee();

    LocalDate pastDate = LocalDate.of(2023, 6, 1);
    employee.planTaskInAgenda(task, pastDate);
}

```

## 5. Construction (Implementation)

```java

public class AddAgendaEntryController {

    Repositories repositories = Repositories.getInstance();


    public List<Task> getPendingTasks() {

        TaskRepository taskRepository = repositories.getTaskRepository();

        List<Task> list = taskRepository.getPendingTasks();

        return list;
    }

    public List<GreenSpace> getAvailableGreenSpaces() {
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();
        List<GreenSpace> spacesManagedByMe = new ArrayList<>();

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            if (greenSpace.getEmail().equals(userSession.getUserId().getEmail())) {
                spacesManagedByMe.add(greenSpace);
            }
        }


        return spacesManagedByMe;
    }

    public void addNewAgendaEntry(Task task, LocalDate startDate) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                employee.planTaskInAgenda(task, startDate);

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to create a job.");

        }

    }
}
````




## 6. Integration and Demo



## 7. Observations

n/a