# US021 - Add a New Entry to the To-Do List

## 4. Tests 

### Test 1: Ensure that it is not possible to create a To-Do List entry with null values

```java
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
    ToDoListEntry entry = new ToDoListEntry(null, null, null, 0);
}
```

### Test 2: Ensure that it is not possible to create a To-Do List entry with an empty title

```java
@Test(expected = IllegalArgumentException.class)
public void ensureEmptyTitleIsNotAllowed() {
    ToDoListEntry entry = new ToDoListEntry("", "High", "GreenSpace1", 2);
}
```

### Test 3: Ensure that it is not possible to create a To-Do List entry with a null urgency

```java
@Test(expected = IllegalArgumentException.class)
public void ensureNullUrgencyIsNotAllowed() {
    ToDoListEntry entry = new ToDoListEntry("Task1", null, "GreenSpace1", 2);
}
```

### Test 4: Ensure that it is not possible to create a To-Do List entry with an invalid duration

```java
@Test(expected = IllegalArgumentException.class)
public void ensureInvalidDurationIsNotAllowed() {
    ToDoListEntry entry = new ToDoListEntry("Task1", "High", "GreenSpace1", -1);
}
```

### Test 5: Ensure that valid To-Do List entry is saved correctly

```java
@Test
public void ensureValidToDoListEntryIsSaved() {
    ToDoListEntryRepository repo = new ToDoListEntryRepository();
    ToDoListEntry entry = new ToDoListEntry("Task1", "High", "GreenSpace1", 2);
    repo.save(entry);
    assertTrue(repo.existsByTitle("Task1"));
}
```

### Test 6: Ensure that selecting a task from the repository works correctly

```java
@Test
public void ensureTaskSelectionFromRepositoryWorks() {
    TaskRepository taskRepo = new TaskRepository();
    Task task = new Task("Task1", "Description1");
    taskRepo.save(task);
    assertNotNull(taskRepo.getTaskByTitle("Task1"));
}
```

### Test 7: Ensure that selecting a GreenSpace from the repository works correctly

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

### Class ToDoListController 

```java
public class ToDoListController {

    private TaskRepository taskRepository;
    private GreenSpaceRepository greenSpaceRepository;
    private AuthenticationRepository authenticationRepository;
    private ToDoListEntryRepository toDoListEntryRepository;

    public ToDoListController() {
        this.taskRepository = Repositories.getInstance().getTaskRepository();
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        this.toDoListEntryRepository = Repositories.getInstance().getToDoListEntryRepository();
    }

    public ToDoListController(TaskRepository taskRepository,
                              GreenSpaceRepository greenSpaceRepository,
                              AuthenticationRepository authenticationRepository,
                              ToDoListEntryRepository toDoListEntryRepository) {
        this.taskRepository = taskRepository;
        this.greenSpaceRepository = greenSpaceRepository;
        this.authenticationRepository = authenticationRepository;
        this.toDoListEntryRepository = toDoListEntryRepository;
    }

    public void addNewToDoListEntry(String taskTitle, String urgency, String greenSpaceName, int duration) {
        if (taskTitle == null || taskTitle.isEmpty() || urgency == null || greenSpaceName == null || greenSpaceName.isEmpty() || duration <= 0) {
            throw new IllegalArgumentException("All fields must be provided and valid.");
        }

        Task task = taskRepository.getTaskByTitle(taskTitle);
        GreenSpace greenSpace = greenSpaceRepository.getGreenSpaceByName(greenSpaceName);

        if (task == null) {
            throw new IllegalArgumentException("Task does not exist.");
        }
        if (greenSpace == null) {
            throw new IllegalArgumentException("GreenSpace does not exist.");
        }

        ToDoListEntry entry = new ToDoListEntry(taskTitle, urgency, greenSpaceName, duration);
        toDoListEntryRepository.save(entry);
    }
}
```

### Class ToDoListEntry

```java
public class ToDoListEntry {
    private String title;
    private String urgency;
    private String greenSpace;
    private int duration;

    public ToDoListEntry(String title, String urgency, String greenSpace, int duration) {
        if (title == null || title.isEmpty() || urgency == null || greenSpace == null || greenSpace.isEmpty() || duration <= 0) {
            throw new IllegalArgumentException("All fields must be provided and valid.");
        }
        this.title = title;
        this.urgency = urgency;
        this.greenSpace = greenSpace;
        this.duration = duration;
    }

    // Getters and setters
}
```

### Class TaskRepository

```java
public class TaskRepository {
    private Map<String, Task> taskDatabase = new HashMap<>();

    public void save(Task task) {
        taskDatabase.put(task.getTitle(), task);
    }

    public Task getTaskByTitle(String title) {
        return taskDatabase.get(title);
    }
}
```

### Class GreenSpaceRepository

```java
public class GreenSpaceRepository {
    private Map<String, GreenSpace> database = new HashMap<>();

    public void save(GreenSpace greenSpace) {
        database.put(greenSpace.getName(), greenSpace);
    }

    public GreenSpace getGreenSpaceByName(String name) {
        return database.get(name);
    }
}
```

### Class ToDoListEntryRepository

```java
public class ToDoListEntryRepository {
    private Map<String, ToDoListEntry> database = new HashMap<>();

    public void save(ToDoListEntry entry) {
        database.put(entry.getTitle(), entry);
    }

    public boolean existsByTitle(String title) {
        return database.containsKey(title);
    }
}
```

## 6. Integration and Demo 

* A new option on the To-Do List menu options was added.

* For demo purposes some To-Do List entries are bootstrapped while system starts.

## 7. Observations

n/a