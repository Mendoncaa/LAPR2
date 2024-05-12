import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.CheckUp;

public class CheckUpTest {

    @Test
    void testCheckUpEquals() {
        CheckUp checkUp1 = new CheckUp("ABC123", "2024-05-11", 10000);
        CheckUp checkUp2 = new CheckUp("ABC123", "2024-05-11", 10000);
        assertEquals(checkUp1, checkUp2);
    }

}
