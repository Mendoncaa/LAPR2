package pt.ipp.isep.dei.esoft.project.domain;

public enum Status {
    PLANNED, POSTPONED, CANCELED, DONE, PENDING;

    public static Status getByIndex(int index) {
        Status[] values = Status.values();
        if (index < 0 || index >= values.length) {
            throw new IllegalArgumentException("Invalid index for SizeClassification enum: " + index);
        }
        return values[index];
    }
}
