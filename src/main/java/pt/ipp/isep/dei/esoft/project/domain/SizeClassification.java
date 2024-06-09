package pt.ipp.isep.dei.esoft.project.domain;

public enum SizeClassification {
    GARDEN, MEDIUM_SIZED_PARK, LARGE_SIZED_PARK;

    public static SizeClassification getByIndex(int index) {
        // Values method returns an array of all enum constants
        SizeClassification[] values = SizeClassification.values();
        if (index < 0 || index >= values.length) {
            throw new IllegalArgumentException("Invalid index for SizeClassification enum: " + index);
        }
        return values[index];
    }
}
