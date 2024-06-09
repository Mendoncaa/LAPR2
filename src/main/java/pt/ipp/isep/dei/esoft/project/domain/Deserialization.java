package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.*;

public class Deserialization {

    Repositories repositories = Repositories.getInstance();

    public void greenSpaceDeserialization() {
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            System.out.println(greenSpace);
        }

        try (
            FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\greenspace.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            GreenSpace greenSpace;
            try {
                while ((greenSpace = (GreenSpace) in.readObject()) != null) {
                    greenSpaceRepository.addGreenSpace(greenSpace);
                }
            } catch (EOFException e) {

            }
            System.out.println("Green Spaces were deserialized and added to the repository");
            System.out.println(greenSpaceRepository);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            System.out.println(greenSpace);
        }
    }

    public void jobDeserialization() {
        JobRepository jobRepository = repositories.getJobRepository();

        for (Job job : jobRepository.listAllJobs()) {
            System.out.println(job);
        }

        try (
            FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\job.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Job job;
            try {
                while ((job = (Job) in.readObject()) != null) {
                    jobRepository.addJob(job);
                }
            } catch (EOFException e) {

            }
            System.out.println("Jobs were deserialized and added to the repository");
            System.out.println(jobRepository);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Job job : jobRepository.listAllJobs()) {
            System.out.println(job);
        }
    }


    public void employeeDeserialization() {
        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();

        for (Employee employee : employeeRepository.listEmployees()) {
            System.out.println(employee);
        }

        try (
                FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\employee.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Employee employee;
            try {
                while ((employee = (Employee) in.readObject()) != null) {
                    employeeRepository.addEmployee(employee);
                }
            } catch (EOFException e) {

            }
            System.out.println("Employees were deserialized and added to the repository");
            System.out.println(employeeRepository);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Employee employee : employeeRepository.listEmployees()) {
            System.out.println(employee);
        }
    }


    public void skillDeserialization() {
        SkillRepository skillRepository = repositories.getSkillRepository();

        for (Skill skill : skillRepository.listAllSkills()) {
            System.out.println(skill);
        }

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\skill.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Skill skill = (Skill) in.readObject();
                    skillRepository.addSkill(skill);
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("Skills were deserialized and added to the repository");
            System.out.println(skillRepository);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Skill skill : skillRepository.listAllSkills()) {
            System.out.println(skill);
        }
    }


    public void teamDeserialization() {
        TeamRepository teamRepository = repositories.getTeamRepository();

        for (Team team : teamRepository.getTeams()) {
            System.out.println(team);
        }

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\team.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Team team = (Team) in.readObject();
                    teamRepository.addTeam(team);
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("Teams were deserialized and added to the repository");
            System.out.println(teamRepository);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Team team : teamRepository.getTeams()) {
            System.out.println(team);
        }
    }

    public void taskDeserialization() {
        TaskRepository taskRepository = repositories.getTaskRepository();

        for (Task task : taskRepository.getTasks()) {
            System.out.println(task);
        }

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\task.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Task task = (Task) in.readObject();
                    taskRepository.addTask(task);
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("Tasks were deserialized and added to the repository");
            System.out.println(taskRepository);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Task task : taskRepository.getTasks()) {
            System.out.println(task);
        }
    }



    public void vehicleDeserialization() {
        VehicleRepository vehicleRepository = repositories.getVehicleRepository();

        for (Vehicle vehicle : vehicleRepository.getVehicles()) {
            System.out.println(vehicle);
        }

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\vehicle.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            while (true) {
                try {
                    Vehicle vehicle = (Vehicle) in.readObject();
                    vehicleRepository.addVehicle(vehicle);
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("Vehicles were deserialized and added to the repository");
            System.out.println(vehicleRepository);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Vehicle vehicle : vehicleRepository.getVehicles()) {
            System.out.println(vehicle);
        }
    }



}
