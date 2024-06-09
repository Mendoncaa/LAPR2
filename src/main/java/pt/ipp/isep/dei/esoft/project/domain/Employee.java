package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an employee in an organization.
 */
public class Employee implements Comparable<Employee>, Serializable {
    private static final long serialVersionUID = -6497430675401438213L;
    private String name;
    private LocalDate birthdate;
    private LocalDate admissionDate;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    private String email;
    //private String password;
    private String idDocType;
    private String idDocNumber;
    private String taxpayerId;
    private Job job;
    private List<Skill> skills = new ArrayList<>();
    private Team team;

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
        //this.password = generatePassword();
        setIdDocType(idDocType);
        setIdDocNumber(idDocNumber);
        setTaxpayerId(taxpayerId);
        this.job = job;
    }

    /**
     * Gets the name of the employee.
     *
     * @return Employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name Employee's name.
     * @throws IllegalArgumentException If the name is null or empty.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        this.name = name.trim();
    }

    /**
     * Gets the birthdate of the employee.
     *
     * @return Employee's birthdate.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the employee.
     *
     * @param birthdate Employee's birthdate.
     * @throws IllegalArgumentException If the birthdate is null or in the future.
     */
    public void setBirthdate(LocalDate birthdate) {
        if (birthdate == null || birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid birthdate");
        }
        this.birthdate = birthdate;
    }


    /**
     * Gets the admission date of the employee.
     *
     * @return Employee's admission date.
     */
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Sets the admission date of the employee.
     *
     * @param admissionDate Employee's admission date.
     * @throws IllegalArgumentException If the admission date is null, in the future, or less than 15 years after the birthdate.
     */
    public void setAdmissionDate(LocalDate admissionDate) {
        if (admissionDate == null || admissionDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid admission date");
        }
        if (birthdate != null && admissionDate.isBefore(birthdate.plusYears(15))) {
            throw new IllegalArgumentException("Admission date must be at least 15 years after birthdate");
        }
        this.admissionDate = admissionDate;
    }

    /**
     * Gets the street address of the employee.
     *
     * @return Employee's street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address of the employee.
     *
     * @param street Employee's street address.
     * @throws IllegalArgumentException If the street is null or empty.
     */
    public void setStreet(String street) {
        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        this.street = street;
    }

    /**
     * Gets the city of the employee.
     *
     * @return Employee's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the employee.
     *
     * @param city Employee's city.
     * @throws IllegalArgumentException If the city is null or empty.
     */
    public void setCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }


    /**
     * Gets the zip code of the employee.
     *
     * @return Employee's zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the employee.
     *
     * @param zipCode Employee's zip code.
     * @throws IllegalArgumentException If the zip code is null or not in the format xxxx-xxx.
     */
    public void setZipCode(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{4}-\\d{3}")) {
            throw new IllegalArgumentException("Invalid zip code format. Should be in format xxxx-xxx");
        }
        this.zipCode = zipCode;
    }


    /**
     * Gets the phone number of the employee.
     *
     * @return Employee's phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the employee.
     *
     * @param phone Employee's phone number.
     * @throws IllegalArgumentException If the phone number is null or not 9 digits.
     */
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid phone number format. Should contain 9 digits");
        }
        this.phone = phone;
    }

    /**
     * Gets the email of the employee.
     *
     * @return Employee's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the employee.
     *
     * @param email Employee's email.
     * @throws IllegalArgumentException If the email is null or not in a valid format.
     */
    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    /**
     * Gets the ID document type of the employee.
     *
     * @return Employee's ID document type.
     */
    public String getIdDocType() {
        return idDocType;
    }


    /**
     * Sets the ID document type of the employee.
     *
     * @param idDocType Employee's ID document type.
     * @throws IllegalArgumentException If the ID document type is not CC, BI, or Other.
     */
    public void setIdDocType(String idDocType) {
        if (!idDocType.equalsIgnoreCase("CC") && !idDocType.equalsIgnoreCase("BI") && !idDocType.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Invalid ID document type");
        }
        this.idDocType = idDocType;
    }


    /**
     * Gets the ID document number of the employee.
     *
     * @return Employee's ID document number.
     */
    public String getIdDocNumber() {
        return idDocNumber;
    }

    /**
     * Sets the ID document number of the employee.
     *
     * @param idDocNumber Employee's ID document number.
     * @throws IllegalArgumentException If the ID document number is invalid for the given ID document type.
     */
    public void setIdDocNumber(String idDocNumber) {
        if ((idDocType.equalsIgnoreCase("CC") && (idDocNumber == null || !idDocNumber.matches("\\d{8}"))) ||
                (idDocType.equalsIgnoreCase("BI") && (idDocNumber == null || !idDocNumber.matches("\\d{8}"))) ||
                (idDocType.equalsIgnoreCase("Other") && (idDocNumber == null || idDocNumber.isEmpty()))) {
            throw new IllegalArgumentException("Invalid ID document number");
        }
        this.idDocNumber = idDocNumber;
    }

    /**
     * Gets the taxpayer ID of the employee.
     *
     * @return Employee's taxpayer ID.
     */
    public String getTaxpayerId() {
        return taxpayerId;
    }

    /**
     * Sets the taxpayer ID of the employee.
     *
     * @param taxpayerId Employee's taxpayer ID.
     * @throws IllegalArgumentException If the taxpayer ID is null or not 9 digits.
     */
    public void setTaxpayerId(String taxpayerId) {
        if (taxpayerId == null || !taxpayerId.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid taxpayer ID");
        }
        this.taxpayerId = taxpayerId;
    }


    /**
     * Gets the job of the employee.
     *
     * @return Employee's job.
     */
    public Job getJob() {
        return job;
    }


    /**
     * Assigns a skill to the employee.
     *
     * @param skill The skill to be assigned.
     * @throws IllegalArgumentException If the employee already has the skill.
     */
    public void assignSkill(Skill skill) {
        if (!hasSkill(skill)) {
            skills.add(skill);
        } else {
            throw new IllegalArgumentException("The employee already has the skill: " + skill);
        }
    }

    /**
     * Checks if the employee has a specific skill.
     *
     * @param skill The skill to be checked.
     * @return True if the employee has the skill, false otherwise.
     */
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


    /**
     * Creates a green space managed by the employee.
     *
     * @param name              The name of the green space.
     * @param sizeClassification The size classification of the green space.
     * @param area              The area of the green space.
     * @param address           The address of the green space.
     * @param email             The email of the green space.
     * @return The created green space.
     */
    public GreenSpace createGreenSpace(String name, SizeClassification sizeClassification,
                                       double area, String address, String email) {
        return new GreenSpace(name, sizeClassification, area, address, email);
    }


    /**
     * Creates a task for the employee.
     *
     * @param title       The title of the task.
     * @param description The description of the task.
     * @param greenSpace  The green space associated with the task.
     * @param urgency     The urgency of the task.
     * @param duration    The duration of the task.
     * @param email       The email of the task.
     * @return The created task.
     */
    public Task createTask(String title, String description, GreenSpace greenSpace, Urgency urgency, Duration duration, String email) {
        return new Task(title, greenSpace, description, urgency, duration, email);
    }


    /**
     * Adds a team to a task.
     *
     * @param team The team to be added.
     * @param task The task to which the team will be added.
     */
    public void addTeamToEntry(Team team, Task task) {
        task.setTeam(team);
    }

    /**
     * Clones the employee.
     *
     * @return A clone of the employee.
     */
    public Employee clone() {
        return new Employee(this.name, this.birthdate, this.admissionDate, this.street, this.city, this.zipCode, this.phone, this.email, this.idDocType, this.idDocNumber, this.taxpayerId, this.job);
    }


    /**
     * Gets the skills of the employee.
     *
     * @return A list of the employee's skills.
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Plans a task in the agenda of the employee.
     *
     * @param task      The task to be planned.
     * @param startDate The start date of the task.
     */
    public void planTaskInAgenda(Task task, LocalDate startDate) {
        task.planTaskInAgenda(startDate);
    }

    /**
     * Completes a task.
     *
     * @param task The task to be completed.
     */
    public void completeTask(Task task) {
        task.completeTask();
    }

    /**
     * Postpones a task.
     *
     * @param task The task to be postponed.
     */
    public void postponeTask(Task task) {
        task.postponeTask();
    }

    /**
     * Cancels a task.
     *
     * @param task The task to be canceled.
     */
    public void cancelTask(Task task) {
        task.cancelTask();
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

    /**
     * Lists the tasks in the agenda of the employee.
     *
     * @param userEmail The email of the user.
     * @return A list of tasks in the agenda.
     */
    public List<Task> listThisGsmTasksInAgenda(String userEmail) {
        Tasks taskManager = new Tasks();
        return taskManager.filterThisGsmTasksInAgenda(userEmail);
    }

    /**
     * Filters vehicles that are not assigned by the date of tasks.
     *
     * @param task     The task to check.
     * @param vehicles The list of vehicles to be filtered.
     * @return A list of vehicles that are not assigned.
     */
    public List<Vehicle> filterVehiclesNotAssignedByDateOfTasks(Task task, List<Vehicle> vehicles) {
        Tasks taskManager = new Tasks();
        return taskManager.filterVehiclesNotAssignedByDateOfTask(task, vehicles);
    }

    /**
     * Gets the green spaces managed by the employee.
     *
     * @return A list of green spaces managed by the employee.
     */
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

    /**
     * Adds a skill to the employee.
     *
     * @param skill The skill to be added.
     */
    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }


    /*private String generatePassword() {

        String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
        String DIGITS = "0123456789";

        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();


        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(UPPERCASE.length());
            password.append(UPPERCASE.charAt(index));
        }


        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(DIGITS.length());
            password.append(DIGITS.charAt(index));
        }


        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(LOWERCASE.length());
            password.append(LOWERCASE.charAt(index));
        }


        List<Character> passwordChars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            passwordChars.add(c);
        }
        Collections.shuffle(passwordChars);


        StringBuilder shuffledPassword = new StringBuilder();
        for (char c : passwordChars) {
            shuffledPassword.append(c);
        }

        return shuffledPassword.toString();
    }*/


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
                //", password='" + password + '\'' +
                ", idDocType='" + idDocType + '\'' +
                ", idDocNumber='" + idDocNumber + '\'' +
                ", taxpayerId='" + taxpayerId + '\'' +
                ", job=" + job +
                ", skills=[" + skillsString.toString() + "]" +
                '}';
    }

    /**
     * Checks if the employee has the given email.
     *
     * @param email The email to be checked.
     * @return True if the employee has the email, false otherwise.
     */
    public boolean hasThisEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    /**
     * Compares the employee with another employee based on their email.
     *
     * @param other The other employee to be compared with.
     * @return A negative integer, zero, or a positive integer as this employee's email is less than, equal to, or greater than the specified employee's email.
     */
    @Override
    public int compareTo(Employee other) {
        return this.email.compareToIgnoreCase(other.email);
    }


}







