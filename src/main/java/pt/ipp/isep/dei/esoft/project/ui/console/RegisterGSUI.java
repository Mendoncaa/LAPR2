package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.controller.RegisterGSController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.SizeClassification;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.UserSession;

import java.util.Scanner;

public class RegisterGSUI implements Runnable {
    private static GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    private static EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
    private static RegisterGSController registerGSController = new RegisterGSController();
    private final Scanner scan = new Scanner(System.in);

    public void run() {

        String name = Utils.readLineFromConsole("Name: ");

        int option = 0;

        SizeClassification sizeClassification;

        do {

            System.out.println("Choose the size classification:");
            System.out.println("1 - Garden");
            System.out.println("2 - Medium-sized park");
            System.out.println("3 - Large-sized park");
            System.out.print("Type your option: ");

            option = scan.nextInt();

            sizeClassification = SizeClassification.getByIndex(option-1);

        } while (option < 0 || option > 3);


        double area = Utils.readDoubleFromConsole("Area(m2): ");
        String address = Utils.readLineFromConsole("Address: ");

        GreenSpace greenSpace = registerGSController.RegisterGreenSpace(name, sizeClassification, area, address);

        System.out.println(greenSpace);


        int accept;
        do {

            System.out.println("  1 - Create Green Space");
            System.out.println("  2 - Refuse Green Space");

            accept = scan.nextInt();

        } while (accept < 1 || accept > 2);


        if (accept == 1) {
            greenSpaceRepository.addGreenSpace(greenSpace);
        }

    }

}
