package pt.ipp.isep.dei.esoft.project.ui.console.menu;


import pt.ipp.isep.dei.esoft.project.ui.console.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;



public class HrmUI implements Runnable {
    public HrmUI() {
    }

    public void run() {

        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create Skill", new CreateSkillUI()));
        options.add(new MenuItem("Create Job", new CreateJobUI()));
        options.add(new MenuItem("Create Employee", new CreateEmployeeUI()));
        options.add(new MenuItem("Assign skills to a collaborator", new AssignSkillUI()));
        options.add(new MenuItem("Generate Team", new GenerateTeamUI()));


        int option;
        do {

            option = Utils.showAndSelectIndex(options, "\n\n--- HRM MENU -------------------------");

            if ((option >= 0) && (option < options.size())) {

                options.get(option).run();

            }

        } while (option != -1);
    }
}