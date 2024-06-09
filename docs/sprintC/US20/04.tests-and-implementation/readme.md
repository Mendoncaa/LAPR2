# US020 - Register a Green Space

## 4. Tests 

### Test 1: Ensure that it is not possible to create a GreenSpace instance with null values

```java
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
    GreenSpace instance = new GreenSpace(null, null, 0, null);
}
```


### Test 2: Ensure that the system does not allow duplicate GreenSpace names

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

### Class RegisterGreenSpaceController

```java
public class RegisterGSController {
    private final AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
    private final GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    public Optional<GreenSpace> RegisterGreenSpace(String name, SizeClassification sizeClassification,
                                               double area, String address) {

        UserSession userSession = authenticationRepository.getCurrentUserSession();

        if (userSession.isLoggedInWithRole("Gsm")) {
            String userEmail = userSession.getUserId().getEmail();
            Optional<Organization> organizationOptional = Repositories.getInstance().getOrganizationRepository()
                    .getOrganizationByEmployeeEmail(userEmail);
            EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
            for (Employee employee : employeeRepository.listEmployees()) {
                System.out.println(employee);
            }


            if (organizationOptional.isPresent()) {
                employeeRepository = Repositories.getInstance().getEmployeeRepository();
                Employee employee = employeeRepository.getEmployeeById(userEmail);

                GreenSpace greenSpace = employee.createGreenSpace(name, sizeClassification, area, address,
                        userSession.getUserId().getEmail());
                greenSpaceRepository.addGreenSpace(greenSpace);

                return Optional.of(greenSpace);
            } else {
                throw new IllegalArgumentException("Organization not found for user: " + userEmail);
            }
        } else {
            throw new IllegalArgumentException("User is not authorized to create a job.");
        }

    }
```

### Class GreenSpace

```java
public class GreenSpace {

    private String name;
    private SizeClassification sizeClassification;
    private double area;
    private String address;
    private String email;


    public GreenSpace(String name, SizeClassification sizeClassification, double area, String address, String email) {
        this.name = name;
        this.sizeClassification = sizeClassification;
        this.area = area;
        this.address = address;
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public SizeClassification getSizeClassification() {
        return sizeClassification;
    }


    public double getArea() {
        return area;
    }


    public String getAddress() {
        return address;
    }


    private void setManagedBy() {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();


        this.email = userSession.getUserId().getEmail();
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "GreenSpace{" +
                "name='" + name + '\'' +
                ", sizeClassification=" + sizeClassification +
                ", area=" + area +
                ", address='" + address + '\'' +
                '}';
    }
}
```

## 6. Integration and Demo 


## 7. Observations

[n/a]