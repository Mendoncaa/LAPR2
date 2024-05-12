package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Date;
import java.util.UUID;

public class Vehicle {
    private String plateID;
    private String brand;
    private String model;
    private String type;
    private int tare;
    private int grossWeight;
    private int currentKms;
    private Date registerDate;
    private Date acquisitionDate;
    private int checkUpFrequencyInKms;


    /**
     *
     * @param plateID                   - Matricula do Veículo
     * @param brand                     - Marcada do Veículo
     * @param model                     - Modelo do Veículo
     * @param type                      - Tipologia do Veículo
     * @param tare                      - Tara do Veículo
     * @param grossWeight               - Peso Bruto do Veículo
     * @param currentKms                - km's atuais do Veículo
     * @param registerDate              - Data de Registo do Veículo
     * @param acquisitionDate           - Data de Aquisição
     * @param checkUpFrequencyInKms     - Frequência de km para revisão
     */
    public Vehicle(String plateID, String brand, String model, String type, int tare, int grossWeight,
                   int currentKms, Date registerDate,Date acquisitionDate, int checkUpFrequencyInKms){
        this.plateID = plateID;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.tare = tare;
        this.grossWeight = grossWeight;
        this.currentKms = currentKms;
        this.registerDate = registerDate;
        this.acquisitionDate = acquisitionDate;
        this.checkUpFrequencyInKms = checkUpFrequencyInKms;
    }

    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        if (plateID == null || plateID.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty");
        }
        this.plateID = plateID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTare() {
        return tare;
    }

    public void setTare(int tare) {
        this.tare = tare;
    }

    public int getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(int grossWeight) {
        this.grossWeight = grossWeight;
    }

    public int getCurrentKms() {
        return currentKms;
    }

    public void setCurrentKms(int currentKms) {
        this.currentKms = currentKms;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        if (registerDate == null || registerDate.after(new Date())) {
            throw new IllegalArgumentException("Invalid Aquisition Date");
        }
        this.registerDate = registerDate;
    }

    public Date getAcquisitionDate() {

        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        if (acquisitionDate == null || acquisitionDate.after(new Date())) {
            throw new IllegalArgumentException("Invalid Aquisition Date");
        }
        this.acquisitionDate = acquisitionDate;
    }

    public int getCheckUpFrequencyInKms() {
        return checkUpFrequencyInKms;
    }

    public void setCheckUpFrequencyInKms(int checkUpFrequencyInKms) {
        this.checkUpFrequencyInKms = checkUpFrequencyInKms;
    }

    public int calculateNextCheckup() {
        return currentKms - checkUpFrequencyInKms;
    }


    public String toString() {
        return "Vehicle{" +
                "plateID='" + plateID + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", tare=" + tare +
                ", grossWeight=" + grossWeight +
                ", currentKms=" + currentKms +
                ", registerDate=" + registerDate +
                ", acquisitionDate=" + acquisitionDate +
                ", checkUpFrequencyInKms=" + checkUpFrequencyInKms +
                '}';
    }

}
