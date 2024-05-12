package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.repository.application.controller.CreateEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Job;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

    /**
     * Create Job UI (console).
     */
    public class CreateEmployeeUI implements Runnable {

        private final CreateEmployeeController controller;
        private String name;
        private Date birthdate;
        private Date admissionDate;
        private String street;
        private String city;
        private String zipCode;
        private String phone;
        private String email;
        private String idDocType;
        private String idDocNumber;
        private String taxpayerId;
        private Job job;

        public CreateEmployeeUI() { controller = new CreateEmployeeController();}

        private CreateEmployeeController getController() {return controller;}

        public void run() {
            System.out.println("\n\n--- Create Employee ------------------------");

            jobName = displayAndSelectJob();

            requestData();

            submitData();
        }

        private void submitData() {
            Optional<Employee> employee = getController().createEmployee(name,birthdate,admissionDate,street,city,zipCode,phone,email,idDocType,idDocNumber,taxpayerId, job);

            if (employee.isPresent()) {
                System.out.println("\nEmployee successfully created!");
            } else {
                System.out.println("\nEmployee not created!");
            }
        }

        private void requestData() {

            // Request the Job Name from the console
            name = requestName();

        }

        private String requestName() {
            Scanner input = new Scanner(System.in);
            System.out.print("Job Name: ");
            return input.nextLine();
        }

        private String displayAndSelectJob() {
            // Display the list of Jobs
            List<Job> job = controller.getAllJobs();

            int listSize = job.size();
            int answer = -1;

            Scanner input = new Scanner(System.in);

            while (answer < 1 || answer > listSize) {
                displayJobOptions(job);
                System.out.print("Select a task category: ");
                answer = input.nextInt();
            }

            String description = job.get(answer - 1).getJobName();
            return description;
        }

        private void displayJobOptions(List<Job> jobs) {
            // Display jobs as a menu with number options to select
            int i = 1;
            for (Job job : jobs) {
                System.out.println("  " + i + " - " + job.getJobName());
                i++;
            }
        }
    }

}
