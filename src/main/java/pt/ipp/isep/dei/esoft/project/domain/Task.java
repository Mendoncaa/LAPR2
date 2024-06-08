package pt.ipp.isep.dei.esoft.project.domain;

import java.time.Duration;
import java.time.LocalDate;

public class Task {
    private String title;
    private GreenSpace greenSpace;
    private String description;
    private Status status;
    private Urgency urgency;
    private LocalDate startDate;
    private Duration duration;


    public Task (String title, GreenSpace greenSpace, String description, Urgency urgency, Duration duration) {
        this.title = title;
        this.greenSpace = greenSpace;
        this.description = description;
        this.status = Status.PENDING;
        this.urgency = urgency;
        this.duration = duration;
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
}
