package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

public class GreenSpace {

    private String name;
    private SizeClassification sizeClassification;
    private double area;
    private String address;
    private Email managedBy;


    public GreenSpace(String name, SizeClassification sizeClassification, double area, String address) {
        this.name = name;
        this.sizeClassification = sizeClassification;
        this.area = area;
        this.address = address;
        setManagedBy();
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


        this.managedBy = userSession.getUserId();
    }

    public Email getManagedBy() {
        return managedBy;
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
