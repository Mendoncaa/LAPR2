package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

public class RegisterGSUI implements Runnable {

    private final Scanner scan = new Scanner(System.in);

    public void run() {

        String name = Utils.readLineFromConsole("Name: ");

        System.out.println("Choose the size classification:");
        System.out.println("1 - GARDEN");
        System.out.println("2 - MEDIUM SIZED PARK");
        System.out.println("3 - LARGE SIZED PARK");
        System.out.print("Type your option: ");


        double area = Utils.readDoubleFromConsole("Area(m2): ");


    }

}
