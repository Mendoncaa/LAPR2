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

    public void postponeTask(Task task) {
        task.postponeTask();
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

    public boolean hasThisEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    @Override
    public int compareTo(Employee other) {
        return this.email.compareToIgnoreCase(other.email);
    }


}







