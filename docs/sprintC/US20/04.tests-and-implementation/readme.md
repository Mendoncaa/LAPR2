# US020 - Register a Green Space

## 4. Tests 

### Test 1: Ensure that it is not possible to create a GreenSpace instance with null values

```java
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
    GreenSpace instance = new GreenSpace(null, null, 0, null);
}
```

### Test 2: Ensure that it is not possible to create a GreenSpace instance with an empty name

```java
@Test(expected = IllegalArgumentException.class)
public void ensureEmptyNameIsNotAllowed() {
    GreenSpace instance = new GreenSpace("", "Garden", 1.5, "123 Green Street");
}
```

### Test 3: Ensure that the system does not allow duplicate GreenSpace names

```java
@Test(expected = DuplicateGreenSpaceException.class)
public void ensureDuplicateNameIsNotAllowed() {
    GreenSpaceRepository repo = new GreenSpaceRepository();
    GreenSpace gs1 = new GreenSpace("Central Park", "Large-sized park", 50.0, "Main Street");
    GreenSpace gs2 = new GreenSpace("Central Park", "Medium-sized park", 20.0, "Second Avenue");
    repo.save(gs1);
    repo.save(gs2); 
}
```

### Test 4: Ensure that valid GreenSpace data is saved correctly

```java
@Test
public void ensureValidGreenSpaceIsSaved() {
    GreenSpaceRepository repo = new GreenSpaceRepository();
    GreenSpace gs = new GreenSpace("Liberty Park", "Medium-sized park", 15.0, "Third Street");
    repo.save(gs);
    assertTrue(repo.existsByName("Liberty Park"));
}
```

## 5. Construction (Implementation)

### Class RegisterGreenSpaceController 

```java
public class RegisterGreenSpaceController {

    private GreenSpaceRepository greenSpaceRepository;
    private AuthenticationRepository authenticationRepository;

    
    public RegisterGreenSpaceController() {
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        this.authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    }

    
    public RegisterGreenSpaceController(GreenSpaceRepository greenSpaceRepository,
                                        AuthenticationRepository authenticationRepository) {
        this.greenSpaceRepository = greenSpaceRepository;
        this.authenticationRepository = authenticationRepository;
    }

    public void registerGreenSpace(String name, String sizeClassification, double area, String address) {
        if (name == null || name.isEmpty() || sizeClassification == null || area <= 0 || address == null || address.isEmpty()) {
            throw new IllegalArgumentException("All fields must be provided and valid.");
        }

        GreenSpace greenSpace = new GreenSpace(name, sizeClassification, area, address);

        if (greenSpaceRepository.checkIfNameExists(name)) {
            throw new DuplicateGreenSpaceException("A green space with this name already exists.");
        }

        greenSpaceRepository.save(greenSpace);
    }
}
```

### Class GreenSpace

```java
public class GreenSpace {
    private String name;
    private String sizeClassification;
    private double area;
    private String address;

    public GreenSpace(String name, String sizeClassification, double area, String address) {
        if (name == null || name.isEmpty() || sizeClassification == null || area <= 0 || address == null || address.isEmpty()) {
            throw new IllegalArgumentException("All fields must be provided and valid.");
        }
        this.name = name;
        this.sizeClassification = sizeClassification;
        this.area = area;
        this.address = address;
    }

    
}
```

### Class GreenSpaceRepository

```java
public class GreenSpaceRepository {
    private Map<String, GreenSpace> database = new HashMap<>();

    public boolean checkIfNameExists(String name) {
        return database.containsKey(name);
    }

    public void save(GreenSpace greenSpace) {
        if (checkIfNameExists(greenSpace.getName())) {
            throw new DuplicateGreenSpaceException("A green space with this name already exists.");
        }
        database.put(greenSpace.getName(), greenSpace);
    }

    public boolean existsByName(String name) {
        return database.containsKey(name);
    }
}
```

## 6. Integration and Demo 


## 7. Observations

n/a