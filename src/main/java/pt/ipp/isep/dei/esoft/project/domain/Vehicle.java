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
    private String registerString;
    private String acquisitionString;
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
    public Vehicle(String plateID, String brand, String model, String type, int tare, int grossWeight,
                   int currentKms, String registerString,String acquisitionString, int checkUpFrequencyInKms){
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

    public String getRegisterString() {
        return registerString;
    }

    public void setRegisterString(String registerString) {
        if (registerString == null ) {
            throw new IllegalArgumentException("Invalid Aquisition String");
        }
        this.registerString = registerString;
    }

    public String getAcquisitionString() {

        return acquisitionString;
    }

    public void setAcquisitionString(String acquisitionString) {
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
