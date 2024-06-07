package pt.ipp.isep.dei.esoft.project.domain;

public class Task {
    private String title;
    private GreenSpace greenSpace;
    private String description;
    private Status status;
    private Urgency urgency;
    private int days;
    private int hours;


    public Task (String title, GreenSpace greenSpace, String description, Urgency urgency, int days, int hours) {
        this.title = title;
        this.greenSpace = greenSpace;
        this.description = description;
        this.status = Status.PENDING;
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

    public int getDays() {
        return days;
    }


    public int getHours() {
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
