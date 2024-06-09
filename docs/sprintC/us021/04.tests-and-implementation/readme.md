# US021 - Add a New Entry to the To-Do List

## 4. Tests 

### Test 1: Ensure that it is not possible to create a To-Do List entry with null values

```java
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
    ToDoListEntry entry = new ToDoListEntry(null, null, null, 0);
}
```

### Test 2: Ensure that it is not possible to create a To-Do List entry with an invalid duration

```java
@Test(expected = IllegalArgumentException.class)
public void ensureInvalidDurationIsNotAllowed() {
    ToDoListEntry entry = new ToDoListEntry("Task1", "High", "GreenSpace1", -1);
}
```


### Test 3: Ensure that selecting a GreenSpace from the repository works correctly

```java
@Test
public void ensureGreenSpaceSelectionFromRepositoryWorks() {
    GreenSpaceRepository gsRepo = new GreenSpaceRepository();
    GreenSpace gs = new GreenSpace("GreenSpace1", "Medium-sized park", 15.0, "Third Street");
    gsRepo.save(gs);
    assertNotNull(gsRepo.getGreenSpaceByName("GreenSpace1"));
}
```

## 5. Construction (Implementation)


### Class TodoListController

```java
public class ToDoListController {

    Repositories repositories = Repositories.getInstance();

    public Optional<Task> addNewTask(String title, String description, GreenSpace greenSpace, Urgency urgency, Duration duration) {

        UserSession userSession = repositories.getAuthenticationRepository().getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = repositories.getOrganizationRepository().
                    getOrganizationByEmployeeEmail(userEmail);


            if (organizationOptional.isPresent()) {

                EmployeeRepository employeeRepository = repositories.getEmployeeRepository();;
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                TaskRepository taskRepository = repositories.getTaskRepository();
                Task task = employee.createTask(title, description, greenSpace, urgency, duration,
                        userSession.getUserId().getEmail());
                taskRepository.addTask(task);

                return Optional.of(task);

            } else {

                throw new IllegalArgumentException("Organization not found for user: " + userEmail);

            }

        } else {

            throw new IllegalArgumentException("User is not authorized to create a job.");

        }
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
}
```

### Class Task

```java
public class Task implements Comparable<Task> {
    private String title;
    private GreenSpace greenSpace;
    private String description;
    private Status status;
    private Urgency urgency;
    private LocalDate startDate;
    private Duration duration;
    private String email;


    public Task (String title, GreenSpace greenSpace, String description, Urgency urgency, Duration duration, String email) {
        this.title = title;
        this.greenSpace = greenSpace;
        this.description = description;
        this.status = Status.PENDING;
        this.urgency = urgency;
        this.duration = duration;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public GreenSpace getGreenSpace() {
        return greenSpace;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void planTaskInAgenda(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date must be provided");
        }
        this.startDate = startDate;
        this.status = Status.PLANNED;
    }

    public void completeTask() {
        this.status = Status.DONE;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", greenSpace=" + greenSpace +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", urgency=" + urgency +
                ", startDate=" + startDate +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.startDate.compareTo(o.startDate);
    }
}
```

## 6. Integration and Demo 


## 7. Observations

n/a