package pt.ipp.isep.dei.esoft.project.domain;

public class GreenSpace {

    private String name;
    private SizeClassification sizeClassification;
    private double area;
    private String address;


    public GreenSpace(String name, SizeClassification sizeClassification, double area, String address) {
        this.name = name;
        this.sizeClassification = sizeClassification;
        this.area = area;
        this.address = address;
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
