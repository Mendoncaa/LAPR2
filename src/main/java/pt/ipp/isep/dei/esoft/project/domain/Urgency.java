package pt.ipp.isep.dei.esoft.project.domain;

public enum Urgency {
    LOW, MEDIUM, HIGH;

    public static Urgency getByIndex(int index) {
        // Values method returns an array of all enum constants
        Urgency[] values = Urgency.values();
        if (index < 0 || index >= values.length) {
            throw new IllegalArgumentException("Invalid index for SizeClassification enum: " + index);
        }
        return values[index];
    }
}