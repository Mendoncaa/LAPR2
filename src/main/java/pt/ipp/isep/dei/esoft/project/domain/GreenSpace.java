package pt.ipp.isep.dei.esoft.project.domain;

public class GreenSpace {
    public enum SizeClassification {
        GARDEN, MEDIUM_SIZED_PARK, LARGE_SIZED_PARK;
    }
    private String name;
    private SizeClassification sizeClassification;
    private float area;
    private String address;


    private GreenSpace(String name, SizeClassification sizeClassification, float area, String address) {
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


    public float getArea() {
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
