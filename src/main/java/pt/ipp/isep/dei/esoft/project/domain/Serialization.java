package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

    Repositories repositories = Repositories.getInstance();
    public void greenSpaceSerialization() {
        GreenSpaceRepository greenSpaceRepository = repositories.getGreenSpaceRepository();

        for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
            System.out.println(greenSpace);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\greenspace.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (GreenSpace greenSpace : greenSpaceRepository.listGreenSpaces()) {
                out.writeObject(greenSpace);
            }
            out.writeObject(null);
            System.out.println("Green Spaces serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    public void jobSerialization() {
        JobRepository jobRepository = repositories.getJobRepository();

        for (Job job : jobRepository.listAllJobs()) {
            System.out.println(job);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\job.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Job job : jobRepository.listAllJobs()) {
                out.writeObject(job);
            }
            // out.writeObject(null);
            System.out.println("Jobs serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    /*public void employeeSerialization() {
        EmployeeRepository employeeRepository = repositories.getEmployeeRepository();

        for (Employee employee : employeeRepository.listEmployees()) {
            System.out.println(employee);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Employee employee : employeeRepository.listEmployees()) {
                out.writeObject(employee);
            }
            out.writeObject(null);
            System.out.println("Employees serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    public void skillSerialization() {
        SkillRepository skillRepository = repositories.getSkillRepository();

        for (Skill skill : skillRepository.listAllSkills()) {
            System.out.println(skill);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\skill.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Skill skill : skillRepository.listAllSkills()) {
                out.writeObject(skill);
            }
            //out.writeObject(null);
            System.out.println("Skills serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void teamSerialization() {
        TeamRepository teamRepository = repositories.getTeamRepository();

        for (Team team : teamRepository.getTeams()) {
            System.out.println(team);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\team.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Team team : teamRepository.getTeams()) {
                out.writeObject(team);
            }
            //out.writeObject(null);
            System.out.println("Teams serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void taskSerialization() {
        TaskRepository taskRepository = repositories.getTaskRepository();

        for (Task task : taskRepository.getTasks()) {
            System.out.println(task);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\task.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Task task : taskRepository.getTasks()) {
                out.writeObject(task);
            }
            //out.writeObject(null);
            System.out.println("Tasks serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void teamMemberSerialization() {
        TeamMemberRepository teamMemberRepository = repositories.getTeamMemberRepository();

        for (TeamMember teamMember : teamMemberRepository.getTeamMembers()) {
            System.out.println(teamMember);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\teammember.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (TeamMember teamMember : teamMemberRepository.getTeamMembers()) {
                out.writeObject(teamMember);
            }
            //out.writeObject(null);
            System.out.println("Team Members serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void organizationSerialization() {
        OrganizationRepository organizationRepository = repositories.getOrganizationRepository();

        for (Organization organization : organizationRepository.getOrganizations()) {
            System.out.println(organization);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\organization.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Organization organization : organizationRepository.getOrganizations()) {
                out.writeObject(organization);
            }
            System.out.println("Organizations serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void vehicleSerialization() {
        VehicleRepository vehicleRepository = repositories.getVehicleRepository();

        for (Vehicle vehicle : vehicleRepository.getVehicles()) {
            System.out.println(vehicle);
        }

        try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\franc\\Desktop\\working_project\\working_project\\src\\main\\resources\\vehicle.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            for (Vehicle vehicle : vehicleRepository.getVehicles()) {
                out.writeObject(vehicle);
            }
            System.out.println("Vehicles serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/






}
