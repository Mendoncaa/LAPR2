package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GreenSpace implements Serializable {

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
