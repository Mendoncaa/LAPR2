package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;

/**
 * Representa um funcionário de uma organização.
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private Date birthdate;
    private Date admissionDate;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    private String email;
    private String idDocType;
    private String idDocNumber;
    private String taxpayerId;
    private Job job;

    /**
     * Constrói um objeto Employee com os detalhes fornecidos.
     *
     * @param name          O nome do funcionário.
     * @param birthdate     A data de nascimento do funcionário.
     * @param admissionDate A data de admissão do funcionário.
     * @param street        O nome da rua do endereço do funcionário.
     * @param city          A cidade do endereço do funcionário.
     * @param zipCode       O código postal do endereço do funcionário.
     * @param phone         O número de telefone do funcionário.
     * @param email         O endereço de e-mail do funcionário.
     * @param idDocType     O tipo de documento de identificação do funcionário.
     * @param idDocNumber   O número do documento de identificação do funcionário.
     * @param taxpayerId    O número de identificação fiscal do funcionário.
     * @param job           O cargo do funcionário.
     * @throws IllegalArgumentException Se algum dos parâmetros for inválido.
     */
    public Employee(String name, Date birthdate, Date admissionDate, String street, String city, String zipCode, String phone, String email, String idDocType, String idDocNumber, String taxpayerId, Job job) {
        this.name = name;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.idDocType = idDocType;
        this.idDocNumber = idDocNumber;
        this.taxpayerId = taxpayerId;
        this.job = job;
    }

    public Employee(String email) {
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

    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @throws IllegalArgumentException Se a data de nascimento for nula ou no futuro.
     */
    public void setBirthdate(Date birthdate) {
        if (birthdate == null || birthdate.after(new Date())) {
            throw new IllegalArgumentException("Invalid birthdate");
        }
        this.birthdate = birthdate;
    }


    public Date getAdmissionDate() {
        return admissionDate;
    }

    /**
     * @throws IllegalArgumentException Se a data de admissão for nula ou no futuro.
     */
    public void setAdmissionDate(Date admissionDate) {
        if (admissionDate == null || admissionDate.after(new Date())) {
            throw new IllegalArgumentException("Invalid admission date");
        }
        this.admissionDate = admissionDate;
    }


    public String getStreet() {
        return street;
    }

    /**
     * @throws IllegalArgumentException Se o nome da rua for nulo ou vazio.
     */
    public void setStreet(String street) {
        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    /**
     * @throws IllegalArgumentException Se a cidade for nula ou vazia.
     */
    public void setCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    /**
     * Define o código postal do endereço do funcionário.
     *
     * @param zipCode O novo código postal do endereço do funcionário.
     * @throws IllegalArgumentException Se o código postal for nulo ou mal formatado.
     */
    public void setZipCode(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{4}-\\d{3}")) {
            throw new IllegalArgumentException("Invalid zip code format. Should be in format xxxx-xxx");
        }
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    /**
     * Define o número de telefone do funcionário.
     *
     * @param phone O novo número de telefone do funcionário.
     * @throws IllegalArgumentException Se o número de telefone for nulo ou vazio.
     */
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid phone number format. Should contain 9 digits");
        }
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do funcionário.
     *
     * @param email O novo endereço de e-mail do funcionário.
     * @throws IllegalArgumentException Se o endereço de e-mail for nulo ou inválido.
     */
    public void setEmail(String email) {
        if (email == null || !email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    /**
     * Obtém o tipo de documento de identificação do funcionário.
     *
     * @return O tipo de documento de identificação do funcionário.
     */
    public String getIdDocType() {
        return idDocType;
    }

    /**
     * Define o tipo de documento de identificação do funcionário.
     *
     * @param idDocType O novo tipo de documento de identificação do funcionário.
     * @throws IllegalArgumentException Se o tipo de documento for inválido.
     */
    public void setIdDocType(String idDocType) {
        if (!idDocType.equalsIgnoreCase("CC") && !idDocType.equalsIgnoreCase("BI") && !idDocType.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Invalid ID document type");
        }
        this.idDocType = idDocType;
    }

    /**
     * Obtém o número do documento de identificação do funcionário.
     *
     * @return O número do documento de identificação do funcionário.
     */
    public String getIdDocNumber() {
        return idDocNumber;
    }

    /**
     * Define o número do documento de identificação do funcionário.
     *
     * @param idDocNumber O novo número do documento de identificação do funcionário.
     * @throws IllegalArgumentException Se o número do documento for inválido.
     */
    public void setIdDocNumber(String idDocNumber) {
        if ((idDocType.equalsIgnoreCase("CC") && (idDocNumber == null || !idDocNumber.matches("\\d{9}"))) ||
                (idDocType.equalsIgnoreCase("BI") && (idDocNumber == null || !idDocNumber.matches("\\d{9}"))) ||
                (idDocType.equalsIgnoreCase("Other") && (idDocNumber == null || idDocNumber.isEmpty()))) {
            throw new IllegalArgumentException("Invalid ID document number");
        }
        this.idDocNumber = idDocNumber;
    }

    /**
     * Obtém o número de identificação fiscal do funcionário.
     *
     * @return O número de identificação fiscal do funcionário.
     */
    public String getTaxpayerId() {
        return taxpayerId;
    }

    /**
     * Define o número de identificação fiscal do funcionário.
     *
     * @param taxpayerId O novo número de identificação fiscal do funcionário.
     * @throws IllegalArgumentException Se o número de identificação fiscal for inválido.
     */
    public void setTaxpayerId(String taxpayerId) {
        if (taxpayerId == null || !taxpayerId.matches("\\d{9}")) {
            throw new IllegalArgumentException("Invalid taxpayer ID");
        }
        this.taxpayerId = taxpayerId;
    }

    /**
     * Obtém o cargo do funcionário.
     *
     * @return O cargo do funcionário.
     */
    public Job getJob() {
        return job;
    }

    /**
     * Define o cargo do funcionário.
     *
     * @param job O novo cargo do funcionário.
     * @throws IllegalArgumentException Se o cargo for nulo.
     */
    public void setJob(Job job) {
        if (job == null) {
            throw new IllegalArgumentException("Job cannot be null");
        }
        this.job = job;
    }

    /**
     * Retorna uma cópia deste objeto Employee.
     *
     * @return Uma cópia deste objeto.
     */
    public Employee clone() {
        return new Employee(this.name, this.birthdate, this.admissionDate, this.street, this.city, this.zipCode, this.phone, this.email, this.idDocType, this.idDocNumber, this.taxpayerId, this.job);
    }

    /**
     * Retorna uma representação em forma de string deste objeto Employee.
     *
     * @return Uma string representando este objeto.
     */
    @Override
    public String toString() {
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
                '}';

    }

    /**
     * Verifica se o funcionário possui o email especificado.
     *
     * @param email O email a ser verificado.
     * @return true se o funcionário possui o email especificado, false caso contrário.
     */
    public boolean hasThisEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    @Override
    public int compareTo(Employee other) {
        return this.taxpayerId.compareTo(other.taxpayerId);
    }
}






