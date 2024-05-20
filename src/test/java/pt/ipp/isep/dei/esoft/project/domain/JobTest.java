package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JobTest {

    @Test
    public void testValidJobName() {
        Job job = new Job("Software Developer");
        assertEquals("Software Developer", job.getJobName());
    }

    @Test
    public void testInvalidJobNameWithSpecialCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Job("Software Developer!");
        });

        String expectedMessage = "The job name cannot contain special characters or digits.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testInvalidJobNameWithDigits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Job("Developer123");
        });

        String expectedMessage = "The job name cannot contain special characters or digits.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testEmptyJobName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Job("");
        });

        String expectedMessage = "The job name cannot be empty.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testJobNameWithSpacesOnly() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Job("   ");
        });

        String expectedMessage = "The job name cannot be empty.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
