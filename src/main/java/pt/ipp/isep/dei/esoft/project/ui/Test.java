package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.ui.console.GenerateTeamUI;

public class Test {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            GenerateTeamUI menu = new GenerateTeamUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
