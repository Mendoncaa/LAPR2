# US004 - As an HRM, I want to assign one or more skills to a collaborator.

## 4. Tests 

**Test 1:** 

	



## 5. Construction (Implementation)

### Class AssignSkillController 

```java
/**
 * Controller responsible for assigning skills to team members.
 */
public class AssignSkillController {
    private final SkillRepository skillRepository = Repositories.getInstance().getSkillRepository();
    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    /**
     * Assigns a skill to a team member.
     *
     * @param employee the employee to whom the skill will be assigned
     * @param skill the skill to be assigned to the employee
     */
    public void assignSkillToTeamMember(Employee employee, Skill skill) {
        employee.assignSkill(skill);
    }

}
```

### Class Organization

```java
public class Organization {
    private final String vatNumber;
    private String name;
    private String website;
    private String phone;
    private String email;
    private EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private JobRepository jobRepository = Repositories.getInstance().getJobRepository();
    private VehicleRepository vehicleRepository = Repositories.getInstance().getVehicleRepository();
    /**
     * This method is the constructor of the organization.
     *
     * @param vatNumber The vat number of the organization. This is the identity of the organization, therefore it
     *                  cannot be changed.
     */
    public Organization(String vatNumber, EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.vatNumber = vatNumber;
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    public Employee createEmployee(String name, LocalDate birthdate, LocalDate admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job selectedJob) {
        Employee employee = new Employee(name, birthdate, admissionDate, street, city, zipCode, phone, email, idDocType, idDocNumber, taxpayerId, selectedJob);
        return employee.clone();
    }

    public void addEmployee(Employee employee) {
        // Check if the employee already exists in the repository
        if (employeeRepository.emailExists(employee.getEmail())) {
            throw new IllegalArgumentException("Employee with the same email already exists");
        }

        for (Employee emp : employeeRepository.listEmployees()) {
            if (emp.getTaxpayerId().compareTo(employee.getTaxpayerId()) == 0) {
                throw new IllegalArgumentException("Employee with the same taxpayer ID already exists");
            }
        }

        employeeRepository.addEmployee(employee);
    }


    public void addVehicle(Vehicle vehicle) {
        // Check if the employee already exists in the repository
        if (vehicleRepository.plateIDExists(vehicle.getPlateID())) {
            throw new IllegalArgumentException("Vehicle with the same plate already exists");
        }

        vehicleRepository.addVehicle(vehicle);
    }

    public List<Employee> listAllEmployees() {
        return employeeRepository.listEmployees();
    }

    public boolean isEmailExists(String email) {
        return employeeRepository.emailExists(email);
    }

    /**
     * Creates a new job.
     * @param jobName The name of the job.
     * @return The created Job object.
     * @throws IllegalArgumentException If the job name does not meet the specified criteria.
     */
    public Job createJob(String jobName) throws IllegalArgumentException {
        return new Job(jobName);
    }


    public Skill createSkill(String skillName) throws IllegalArgumentException {
        return new Skill(skillName);
    }


    /**
     * Adds a job to the repository after checking for duplicates.
     *
     * @param job           The job to add.
     * @param jobRepository
     * @throws IllegalArgumentException If a job with the same name already exists.
     */
    public void addJob(Job job, JobRepository jobRepository) throws IllegalArgumentException {

        for (Job existingJob : jobRepository.listAllJobs()) {
            if (existingJob.compareTo(job) == 0) {
                throw new IllegalArgumentException("A job with the same name already exists: " + job.getJobName());
            }
        }
        jobRepository.addJob(job);
    }

    public void addSkill(Skill skill, SkillRepository skillRepository) throws IllegalArgumentException {

        for (Skill existingskill : skillRepository.listAllSkills()) {
            if (existingskill.compareTo(skill) == 0) {
                throw new IllegalArgumentException("A skill with the same name already exists: " + skill.getName());
            }
        }
        skillRepository.addSkill(skill);
    }

    public String getName() {
        return name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.vatNumber,this.employeeRepository,this.jobRepository);
        clone.name = (this.name);
        clone.website = (this.website);
        clone.phone = (this.phone);
        clone.email = (this.email);
        return clone;
    }
}

### Class Employee

```java

/**
 * Represents an employee in an organization.
 */
public class Employee implements Comparable<Employee>, Serializable {
    private String name;
    private LocalDate birthdate;
    private LocalDate admissionDate;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    private String email;
    private String idDocType;
    private String idDocNumber;
    private String taxpayerId;
    private Job job;
    private List<Skill> skills = new ArrayList<>();

    /**
     * Constructs an Employee object with the given details.
     *
     * @param name          Employee's name.
     * @param birthdate     Employee's birthdate.
     * @param admissionDate Employee's admission date.
     * @param street        Employee's street address.
     * @param city          Employee's city.
     * @param zipCode       Employee's zip code.
     * @param phone         Employee's phone number.
     * @param email         Employee's email.
     * @param idDocType     Employee's ID document type.
     * @param idDocNumber   Employee's ID document number.
     * @param taxpayerId    Employee's taxpayer ID.
     * @param job           Employee's job.
     * @throws IllegalArgumentException If any of the parameters are invalid.
     */
    public Employee(String name, LocalDate birthdate, LocalDate admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) {
        setName(name);
        setBirthdate(birthdate);
        setAdmissionDate(admissionDate);
        setStreet(street);
        setCity(city);
        setZipCode(zipCode);
        setPhone(phone);
        setEmail(email);
        setIdDocType(idDocType);
        setIdDocNumber(idDocNumber);
        setTaxpayerId(taxpayerId);
        this.job = job;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        if (birthdate == null || birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid birthdate");
        }
        this.birthdate = birthdate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
    public void setAdmissionDate(LocalDate admissionDate) {
        if (admissionDate == null || admissionDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid admission date");
        }
        if (birthdate != null && admissionDate.isBefore(birthdate.plusYears(15))) {
            throw new IllegalArgumentException("Admission date must be at least 15 years after birthdate");
        }
        this.admissionDate = admissionDate;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{4}-\\d{3}")) {
            throw new IllegalArgumentException("Invalid zip code format. Should be in format xxxx-xxx");
        }
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid phone number format. Should contain 9 digits");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public String getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(String idDocType) {
        if (!idDocType.equalsIgnoreCase("CC") && !idDocType.equalsIgnoreCase("BI") && !idDocType.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Invalid ID document type");
        }
        this.idDocType = idDocType;
    }

    public String getIdDocNumber() {
        return idDocNumber;
    }

    public void setIdDocNumber(String idDocNumber) {
        if ((idDocType.equalsIgnoreCase("CC") && (idDocNumber == null || !idDocNumber.matches("\\d{8}"))) ||
                (idDocType.equalsIgnoreCase("BI") && (idDocNumber == null || !idDocNumber.matches("\\d{8}"))) ||
                (idDocType.equalsIgnoreCase("Other") && (idDocNumber == null || idDocNumber.isEmpty()))) {
            throw new IllegalArgumentException("Invalid ID document number");
        }
        this.idDocNumber = idDocNumber;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        if (taxpayerId == null || !taxpayerId.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid taxpayer ID");
        }
        this.taxpayerId = taxpayerId;
    }

    public Job getJob() {
        return job;
    }

    public void assignSkill(Skill skill) {
        if (!hasSkill(skill)) {
            skills.add(skill);
        } else {
            throw new IllegalArgumentException("The employee already has the skill: " + skill);
        }
    }

    public boolean hasSkill(Skill skill) {
        if (skills == null) {
            return false;
        }

        for (Skill skillTest : skills) {
            if (skillTest.getName().equals(skill.getName())) {
                return true;
            }
        }

        return false;
    }


    public GreenSpace createGreenSpace(String name, SizeClassification sizeClassification,
                                       double area, String address, String email) {
        return new GreenSpace(name, sizeClassification, area, address, email);
    }


    public Task createTask(String title, String description, GreenSpace greenSpace, Urgency urgency, Duration duration, String email) {
        return new Task(title, greenSpace, description, urgency, duration, email);
    }


    public Employee clone() {
        return new Employee(this.name, this.birthdate, this.admissionDate, this.street, this.city, this.zipCode, this.phone, this.email, this.idDocType, this.idDocNumber, this.taxpayerId, this.job);
    }

    public List<Skill> getSkills() {
        return skills;
    }


    public void planTaskInAgenda(Task task, LocalDate startDate) {
        task.planTaskInAgenda(startDate);
    }

    public void completeTask(Task task) {
        task.completeTask();
    }

    /**
     * Updates the task with the given list of vehicles.
     *
     * @param task     The task to be updated.
     * @param vehicles The list of vehicles to be assigned to the task.
     * @return
     * @throws IllegalArgumentException If the task or vehicles are invalid.
     */
    public Boolean addUpdatedTaskVehicles(Task task, List<Vehicle> vehicles) {

        validateTask(task, vehicles);

        return task.setVehicles(vehicles);
    }

    /**
     * Validates the task and the list of vehicles.
     *
     * @param task     The task to be validated.
     * @param vehicles The list of vehicles to be validated.
     * @throws IllegalArgumentException If the task or vehicles are invalid.
     */
    public void validateTask(Task task, List<Vehicle> vehicles) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if (vehicles == null || vehicles.isEmpty()) {
            throw new IllegalArgumentException("Vehicle list cannot be null or empty");
        }

    }
    public List<Task> listThisGsmTasksInAgenda(String userEmail) {
        Tasks taskManager = new Tasks();
        return taskManager.filterThisGsmTasksInAgenda(userEmail);
    }

    public List<Vehicle> filterVehiclesNotAssignedByDateOfTasks(Task task, List<Vehicle> vehicles) {
        Tasks taskManager = new Tasks();
        return taskManager.filterVehiclesNotAssignedByDateOfTask(task, vehicles);
    }


    public List<GreenSpace> getGreenSpacesManagedByMe() {
        GreenSpaces greenSpaces = new GreenSpaces();

        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();

        return greenSpaces.getGreenSpacesManagedByMe(userSession.getUserId().getEmail());
    }
    /**
     * Sorts the given list of green spaces managed by me by areas using the specified algorithm name.
     *
     * @param algorithmName The name of the sorting algorithm to be used.
     * @return The sorted list of green spaces.
     */
    public List<GreenSpace> sortGreenSpaces(String algorithmName)  {
        List<GreenSpace> greenSpaces = getGreenSpacesManagedByMe();
        SortingConfigAdapter sortingConfigAdapter = new SortingConfigAdapter();
        List<GreenSpace> sortedGreenSpaces = sortingConfigAdapter.getSortedGreenSpaces(algorithmName,greenSpaces);

        return sortedGreenSpaces;
    }
    /**
     * Retrieves the names of all available sorting algorithms.
     *
     * @return The list of available sorting algorithm names.
     */
    public List<String> getAvailableSortingAlgorithms() {
        SortingConfigAdapter sortingConfigAdapter = new SortingConfigAdapter();
        return sortingConfigAdapter.getAllSortingAlgorithmsNames();
    }


    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }


    @Override
    public String toString() {
        StringBuilder skillsString = new StringBuilder();
        for (Skill skill : skills) {
            skillsString.append(skill.toString()).append(", ");
        }

        // Remove the last comma and space if skillsString is not empty
        if (skillsString.length() > 0) {
            skillsString.setLength(skillsString.length() - 2);
        }

        return "Employee{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", admissionDate=" + admissionDate +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", idDocType='" + idDocType + '\'' +
                ", idDocNumber='" + idDocNumber + '\'' +
                ", taxpayerId='" + taxpayerId + '\'' +
                ", job=" + job +
                ", skills=[" + skillsString.toString() + "]" +
                '}';
    }

    public boolean hasThisEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    @Override
    public int compareTo(Employee other) {
        return this.email.compareToIgnoreCase(other.email);
    }


}

```

### Class Employee

```java

/**
 * Represents an employee in an organization.
 */
public class Employee implements Comparable<Employee>, Serializable {
    private String name;
    private LocalDate birthdate;
    private LocalDate admissionDate;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    private String email;
    private String idDocType;
    private String idDocNumber;
    private String taxpayerId;
    private Job job;
    private List<Skill> skills = new ArrayList<>();

    /**
     * Constructs an Employee object with the given details.
     *
     * @param name          Employee's name.
     * @param birthdate     Employee's birthdate.
     * @param admissionDate Employee's admission date.
     * @param street        Employee's street address.
     * @param city          Employee's city.
     * @param zipCode       Employee's zip code.
     * @param phone         Employee's phone number.
     * @param email         Employee's email.
     * @param idDocType     Employee's ID document type.
     * @param idDocNumber   Employee's ID document number.
     * @param taxpayerId    Employee's taxpayer ID.
     * @param job           Employee's job.
     * @throws IllegalArgumentException If any of the parameters are invalid.
     */
    public Employee(String name, LocalDate birthdate, LocalDate admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) {
        setName(name);
        setBirthdate(birthdate);
        setAdmissionDate(admissionDate);
        setStreet(street);
        setCity(city);
        setZipCode(zipCode);
        setPhone(phone);
        setEmail(email);
        setIdDocType(idDocType);
        setIdDocNumber(idDocNumber);
        setTaxpayerId(taxpayerId);
        this.job = job;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        this.name = name.trim();
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        if (birthdate == null || birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid birthdate");
        }
        this.birthdate = birthdate;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
    public void setAdmissionDate(LocalDate admissionDate) {
        if (admissionDate == null || admissionDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid admission date");
        }
        if (birthdate != null && admissionDate.isBefore(birthdate.plusYears(15))) {
            throw new IllegalArgumentException("Admission date must be at least 15 years after birthdate");
        }
        this.admissionDate = admissionDate;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{4}-\\d{3}")) {
            throw new IllegalArgumentException("Invalid zip code format. Should be in format xxxx-xxx");
        }
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid phone number format. Should contain 9 digits");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public String getIdDocType() {
        return idDocType;
    }

    public void setIdDocType(String idDocType) {
        if (!idDocType.equalsIgnoreCase("CC") && !idDocType.equalsIgnoreCase("BI") && !idDocType.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Invalid ID document type");
        }
        this.idDocType = idDocType;
    }

    public String getIdDocNumber() {
        return idDocNumber;
    }

    public void setIdDocNumber(String idDocNumber) {
        if ((idDocType.equalsIgnoreCase("CC") && (idDocNumber == null || !idDocNumber.matches("\\d{8}"))) ||
                (idDocType.equalsIgnoreCase("BI") && (idDocNumber == null || !idDocNumber.matches("\\d{8}"))) ||
                (idDocType.equalsIgnoreCase("Other") && (idDocNumber == null || idDocNumber.isEmpty()))) {
            throw new IllegalArgumentException("Invalid ID document number");
        }
        this.idDocNumber = idDocNumber;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        if (taxpayerId == null || !taxpayerId.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid taxpayer ID");
        }
        this.taxpayerId = taxpayerId;
    }

    public Job getJob() {
        return job;
    }

    public void assignSkill(Skill skill) {
        if (!hasSkill(skill)) {
            skills.add(skill);
        } else {
            throw new IllegalArgumentException("The employee already has the skill: " + skill);
        }
    }

    public boolean hasSkill(Skill skill) {
        if (skills == null) {
            return false;
        }

        for (Skill skillTest : skills) {
            if (skillTest.getName().equals(skill.getName())) {
                return true;
            }
        }

        return false;
    }


    public GreenSpace createGreenSpace(String name, SizeClassification sizeClassification,
                                       double area, String address, String email) {
        return new GreenSpace(name, sizeClassification, area, address, email);
    }


    public Task createTask(String title, String description, GreenSpace greenSpace, Urgency urgency, Duration duration, String email) {
        return new Task(title, greenSpace, description, urgency, duration, email);
    }


    public Employee clone() {
        return new Employee(this.name, this.birthdate, this.admissionDate, this.street, this.city, this.zipCode, this.phone, this.email, this.idDocType, this.idDocNumber, this.taxpayerId, this.job);
    }

    public List<Skill> getSkills() {
        return skills;
    }


    public void planTaskInAgenda(Task task, LocalDate startDate) {
        task.planTaskInAgenda(startDate);
    }

    public void completeTask(Task task) {
        task.completeTask();
    }

    /**
     * Updates the task with the given list of vehicles.
     *
     * @param task     The task to be updated.
     * @param vehicles The list of vehicles to be assigned to the task.
     * @return
     * @throws IllegalArgumentException If the task or vehicles are invalid.
     */
    public Boolean addUpdatedTaskVehicles(Task task, List<Vehicle> vehicles) {

        validateTask(task, vehicles);

        return task.setVehicles(vehicles);
    }

    /**
     * Validates the task and the list of vehicles.
     *
     * @param task     The task to be validated.
     * @param vehicles The list of vehicles to be validated.
     * @throws IllegalArgumentException If the task or vehicles are invalid.
     */
    public void validateTask(Task task, List<Vehicle> vehicles) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if (vehicles == null || vehicles.isEmpty()) {
            throw new IllegalArgumentException("Vehicle list cannot be null or empty");
        }

    }
    public List<Task> listThisGsmTasksInAgenda(String userEmail) {
        Tasks taskManager = new Tasks();
        return taskManager.filterThisGsmTasksInAgenda(userEmail);
    }

    public List<Vehicle> filterVehiclesNotAssignedByDateOfTasks(Task task, List<Vehicle> vehicles) {
        Tasks taskManager = new Tasks();
        return taskManager.filterVehiclesNotAssignedByDateOfTask(task, vehicles);
    }


    public List<GreenSpace> getGreenSpacesManagedByMe() {
        GreenSpaces greenSpaces = new GreenSpaces();

        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        UserSession userSession = authenticationRepository.getCurrentUserSession();

        return greenSpaces.getGreenSpacesManagedByMe(userSession.getUserId().getEmail());
    }
    /**
     * Sorts the given list of green spaces managed by me by areas using the specified algorithm name.
     *
     * @param algorithmName The name of the sorting algorithm to be used.
     * @return The sorted list of green spaces.
     */
    public List<GreenSpace> sortGreenSpaces(String algorithmName)  {
        List<GreenSpace> greenSpaces = getGreenSpacesManagedByMe();
        SortingConfigAdapter sortingConfigAdapter = new SortingConfigAdapter();
        List<GreenSpace> sortedGreenSpaces = sortingConfigAdapter.getSortedGreenSpaces(algorithmName,greenSpaces);

        return sortedGreenSpaces;
    }
    /**
     * Retrieves the names of all available sorting algorithms.
     *
     * @return The list of available sorting algorithm names.
     */
    public List<String> getAvailableSortingAlgorithms() {
        SortingConfigAdapter sortingConfigAdapter = new SortingConfigAdapter();
        return sortingConfigAdapter.getAllSortingAlgorithmsNames();
    }


    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }


    @Override
    public String toString() {
        StringBuilder skillsString = new StringBuilder();
        for (Skill skill : skills) {
            skillsString.append(skill.toString()).append(", ");
        }

        // Remove the last comma and space if skillsString is not empty
        if (skillsString.length() > 0) {
            skillsString.setLength(skillsString.length() - 2);
        }

        return "Employee{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", admissionDate=" + admissionDate +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", idDocType='" + idDocType + '\'' +
                ", idDocNumber='" + idDocNumber + '\'' +
                ", taxpayerId='" + taxpayerId + '\'' +
                ", job=" + job +
                ", skills=[" + skillsString.toString() + "]" +
                '}';
    }

    public boolean hasThisEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    @Override
    public int compareTo(Employee other) {
        return this.email.compareToIgnoreCase(other.email);
    }


}

```

### Class Skill

```java
/**
 * Class representing a skill with a unique ID and a name.
 * Implements Comparable to allow comparison based on the skill name.
 */
public class Skill implements Comparable<Skill>, Serializable {
    private String id;
    private String name;

/**
 * Constructor for Skill.
 * Generates a unique ID and sets the skill name.
 *
 * @param name The name of the skill.
 */
    public Skill(String name) {
        this.id = generateId();
        setSkillName(name);
    }

/**
 * Sets the skill name after validating it.
 *
 * @param name The name of the skill.
 * @throws IllegalArgumentException If the name is empty, contains special characters or digits, or doesn't contain at least one word.
 */

    public void setSkillName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The skill name cannot be empty.");
        }

        if (!name.matches("^[a-zA-Z ]+$")) {
            throw new IllegalArgumentException("The skill name cannot contain special characters or digits.");
        }

        if (name.split(" ").length < 1) {
            throw new IllegalArgumentException("The skill name must contain at least one word.");
        }
        this.name = name;
    }

/**
 * Generates a universally unique identifier (UUID) for the skill.
 *
 * @return A string representing a random UUID.
 */
    private String generateId() {
        return UUID.randomUUID().toString();
    }

/**
 * Gets the unique ID of the skill.
 *
 * @return The skill ID.
 */
    public String getId() {
        return id;
    }

/**
 * Gets the name of the skill.
 *
 * @return The skill name.
 */
    public String getName() {
        return name;
    }


/**
 * Returns a string representation of the skill.
 *
 * @return A string representation of the skill, including its ID and name.
 */
    @Override
    public String toString() {
        return "Skill{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


/**
 * Compares this skill to another skill based on their names.
 *
 * @param skill The skill to be compared with.
 * @return A negative integer, zero, or a positive integer as this skill name is less than, equal to, or greater than the specified skill name.
 */
    @Override
    public int compareTo(Skill skill) {
        return this.name.compareTo(skill.name);
    }
}

```  

