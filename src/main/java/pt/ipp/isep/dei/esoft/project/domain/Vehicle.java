package pt.ipp.isep.dei.esoft.project.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;

public class Vehicle {
    private String plateID;
    private String brand;
    private String model;
    private String type;
    private double tare;
    private double grossWeight;
    private int currentKms;
    private LocalDate registerString;
    private LocalDate acquisitionString;
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
     * @param registerString              - Data de Registo do Veículo
     * @param acquisitionString           - Data de Aquisição
     * @param checkUpFrequencyInKms     - Frequência de km para revisão
     */
    public Vehicle(String plateID, String brand, String model, String type, double tare, double grossWeight,
                   int currentKms, LocalDate registerString,LocalDate acquisitionString, int checkUpFrequencyInKms){
        this.plateID = plateID;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.tare = tare;
        this.grossWeight = grossWeight;
        this.currentKms = currentKms;
        this.registerString = registerString;
        this.acquisitionString = acquisitionString;
        this.checkUpFrequencyInKms = checkUpFrequencyInKms;
    }

    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        if (plateID == null ) {
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

    public double getTare() {
        return tare;
    }

    public void setTare(int tare) {
        this.tare = tare;
    }

    public double getGrossWeight() {
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

    public LocalDate getRegisterString() {
        return registerString;
    }

    public void setRegisterString(LocalDate registerString) {
        if (registerString == null ) {
            throw new IllegalArgumentException("Invalid Aquisition String");
        }
        this.registerString = registerString;
    }

    public LocalDate getAcquisitionString() {

        return acquisitionString;
    }

    public void setAcquisitionString(LocalDate acquisitionString) {
        if (acquisitionString == null ) {
            throw new IllegalArgumentException("Invalid Aquisition String");
        }
        this.acquisitionString = acquisitionString;
    }

    public int getCheckUpFrequencyInKms() {
        return checkUpFrequencyInKms;
    }

    public void setCheckUpFrequencyInKms(int checkUpFrequencyInKms) {
        this.checkUpFrequencyInKms = checkUpFrequencyInKms;
    }

    public int calculateNextCheckup() {
        return checkUpFrequencyInKms - currentKms;
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
                ", registerString=" + registerString +
                ", acquisitionString=" + acquisitionString +
                ", checkUpFrequencyInKms=" + checkUpFrequencyInKms +
                '}';
    }

}