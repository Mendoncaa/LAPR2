package pt.ipp.isep.dei.esoft.project.domain;

import java.util.UUID;

public class Vehicle {
    private String plateID;
    private String brand;
    private String model;
    private String type;
    private int tare;
    private int grossWeight;
    private int currentKms;
    private String registerDate;
    private String acquisitionDate;
    private int checkUpFrequencyInKms;


    public Vehicle(String plateID, String brand, String model, String type, int tare, int grossWeight,
                   int currentKms, String registerDate,String acquisitionDate, int checkUpFrequencyInKms){
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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public int getCheckUpFrequencyInKms() {
        return checkUpFrequencyInKms;
    }

    public void setCheckUpFrequencyInKms(int checkUpFrequencyInKms) {
        this.checkUpFrequencyInKms = checkUpFrequencyInKms;
    }



}
