package pt.ipp.isep.dei.esoft.project.domain;

public class Task {
    private String title;
    private GreenSpace greenSpace;
    private String description;
    private Status status;
    private Urgency urgency;
    private String days;
    private String hours;


    public Task (String title, GreenSpace greenSpace, String description, Status status,
                 Urgency urgency, String days, String hours) {
        this.title = title;
        this.greenSpace = greenSpace;
        this.description = description;
        this.status = status;
        this.urgency = urgency;
        this.days = days;
        this.hours = hours;
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

    public String getDays() {
        return days;
    }


    public String getHours() {
        return hours;
    }


    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", greenSpace=" + greenSpace +
                ", description='" + description + '\'' +
                ", state='" + status + '\'' +
                ", urgency='" + urgency + '\'' +
                ", days='" + days + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
