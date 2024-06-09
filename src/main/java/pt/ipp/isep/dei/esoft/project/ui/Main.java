package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;

public class Main {

    public static void main(String[] args) {

        Deserialization deserialization = new Deserialization();
        deserialization.greenSpaceDeserialization();
        deserialization.jobDeserialization();
        deserialization.employeeDeserialization();
        deserialization.skillDeserialization();
        deserialization.teamDeserialization();
        deserialization.taskDeserialization();
        deserialization.teamMemberDeserialization();
        deserialization.organizationDeserialization();
        deserialization.vehicleDeserialization();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        
        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Serialization serialization = new Serialization();
        serialization.greenSpaceSerialization();
        serialization.jobSerialization();
        serialization.employeeSerialization();
        serialization.skillSerialization();
        serialization.teamSerialization();
        serialization.taskSerialization();
        serialization.teamMemberSerialization();
        serialization.organizationSerialization();
        serialization.vehicleSerialization();
    }
}