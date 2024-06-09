package pt.ipp.isep.dei.esoft.project.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task implements Comparable<Task> {
    private String title;
    private GreenSpace greenSpace;
    private String description;
    private Status status;
    private Urgency urgency;
    private LocalDate startDate;
    private Duration duration;
    private String email;
    private List<Vehicle> vehicles = new ArrayList<>();



    public Task (String title, GreenSpace greenSpace, String description, Urgency urgency, Duration duration, String email) {
        this.title = title;
        this.greenSpace = greenSpace;
        this.description = description;
        this.status = Status.PENDING;
        this.urgency = urgency;
        this.duration = duration;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public GreenSpace getGreenSpace() {
        return greenSpace;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void planTaskInAgenda(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date must be provided");
        }
        this.startDate = startDate;
        this.status = Status.PLANNED;
    }

    public void completeTask() {
        this.status = Status.DONE;
    }


    public String getEmail() {
        return email;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Boolean setVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            throw new IllegalArgumentException("Vehicle list cannot be null or empty");
        }
        this.vehicles = vehicles;
        return true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", greenSpace=" + greenSpace +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", urgency=" + urgency +
                ", startDate=" + startDate +
                ", duration=" + duration +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        return this.startDate.compareTo(o.startDate);
    }

}
