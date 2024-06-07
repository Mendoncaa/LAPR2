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

### Test 4: Ensure that it is not possible to create a To-Do List entry with an invalid duration

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





## 6. Integration and Demo

* A new option on the To-Do List menu options was added.

* For demo purposes some To-Do List entries are bootstrapped while system starts.

## 7. Observations

n/a