package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.controller.CreateEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Job;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

    /**
     * Create Job UI (console).
     */
    public class CreateEmployeeUI implements Runnable {

        private final CreateEmployeeController controller;
        private String name;
        private LocalDate birthdate;
        private LocalDate admissionDate;
        private String street;
        private String city;
        private String zipCode;
        private String phone;
        private String email;
        private String idDocType;
        private String idDocNumber;
        private String taxpayerId;
        private Job selectedjob;

        public CreateEmployeeUI() { controller = new CreateEmployeeController();}

        private CreateEmployeeController getController() {return controller;}

        public void run() {
            System.out.println("\n\n--- Create Employee ------------------------");

            try{
                selectedjob = displayAndSelectJob();
                requestData();
                if (reviewData()) {
                    submitData();
                } else {
                    System.out.println("\nEmployee creation cancelled.");
                }
            }
            catch (Exception e) {
                System.out.println("An error occurred while creating the job: " + e.getMessage());
            }

        }

        private void submitData() {
            Optional<Employee> employee = getController().createEmployee(name,birthdate,admissionDate,street,city,zipCode,phone,email,idDocType,idDocNumber,taxpayerId, selectedjob);

            if (employee.isPresent()) {
                System.out.println("\nEmployee successfully created!");
            } else {
                System.out.println("\nEmployee not created!");
            }
        }

        private void requestData() {
                // Request each parameter from the console
                name = requestString("Name");
                birthdate = requestDate("Birthdate (yyyy-MM-dd)");
                admissionDate = requestDate("Admission Date (yyyy-MM-dd)");
                street = requestString("Street");
                city = requestString("City");
                zipCode = requestString("Zip Code (xxxx-xxx)");
                phone = requestString("Phone(9 Digits)");
                email = requestString("Email");
                idDocType = requestString("ID Document Type (CC/BI/Other)");
                idDocNumber = requestString("ID Document Number (CC/BI (8 Digits)");
                taxpayerId = requestString("Taxpayer ID (9 Digits)");
            }

            private String requestString(String prompt) {
                Scanner input = new Scanner(System.in);
                System.out.print(prompt + ": ");
                return input.nextLine();
            }

            private LocalDate requestDate(String prompt) {
                Scanner input = new Scanner(System.in);
                System.out.print(prompt + ": ");
                String dateString = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(dateString, formatter);
            }

        private Job displayAndSelectJob() {
            // Display the list of Jobs
            List<Job> job = controller.listAllJobs();

            int listSize = job.size();
            int answer = -1;

            Scanner input = new Scanner(System.in);

            while (answer < 1 || answer > listSize) {
                displayJobOptions(job);
                System.out.print("Select a job: ");
                answer = input.nextInt();
            }

            return job.get(answer - 1);
        }

        private void displayJobOptions(List<Job> jobs) {
            // Display jobs as a menu with number options to select
            int i = 1;
            for (Job job : jobs) {
                System.out.println("  " + i + " - " + job.getJobName());
                i++;
            }
        }

        private boolean reviewData() {
            Scanner input = new Scanner(System.in);
            System.out.println("\n--- Review Employee Data ---");
            System.out.println("Name: " + name);
            System.out.println("Birthdate: " + birthdate);
            System.out.println("Admission Date: " + admissionDate);
            System.out.println("Street: " + street);
            System.out.println("City: " + city);
            System.out.println("Zip Code: " + zipCode);
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
            System.out.println("ID Document Type: " + idDocType);
            System.out.println("ID Document Number: " + idDocNumber);
            System.out.println("Taxpayer ID: " + taxpayerId);
            System.out.println("Job: " + selectedjob);
            System.out.print("\nIs the above information correct? (Y/N): ");
            String answer = input.nextLine().trim().toLowerCase();
            return answer.equals("y");
        }
    }