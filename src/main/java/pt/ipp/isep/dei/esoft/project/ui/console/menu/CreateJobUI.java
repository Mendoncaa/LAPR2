package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.CreateJobController;


import java.util.Optional;
import java.util.Scanner;



public class CreateJobUI implements Runnable {

    private final CreateJobController controller;
    private String jobName;
    public CreateJobUI() {
        controller = new CreateJobController();
    }
    private CreateJobController getController() {
        return controller;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter the job name: ");
            jobName = scanner.nextLine();
            System.out.println("The entered job name is: " + jobName);

            System.out.print("Are you sure you want to create this job? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                submitData();
            } else {
                System.out.println("Operation canceled by the user.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the job: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void submitData() {
        Optional<Job> job = getController().createJob(jobName);
        if (job.isPresent()) {
            System.out.println("\nJob successfully created!");
        } else {
            System.out.println("\nJob not created!");
        }
    }
}



