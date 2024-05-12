// CheckUp.java
package pt.ipp.isep.dei.esoft.project.domain;

public class CheckUp {
    private String plateID;
    private String scheduleDate;
    private int currentKms;

    public CheckUp(String plateID, String scheduleDate, int currentKms) {
        this.plateID = plateID;
        this.scheduleDate = scheduleDate;
        this.currentKms = currentKms;
    }


}
