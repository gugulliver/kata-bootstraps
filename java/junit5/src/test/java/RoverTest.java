import org.junit.jupiter.api.Test;
import org.javatuples.Pair;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    // BASIC TEST
    // "You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing."

    // The rover should be present at it's initial spot when created
    @Test
    void rover_have_landed() {
        Rover firstRover = new Rover();
        Pair<Integer, Integer> position = firstRover.getPosition();
        Pair<Integer, Integer> expectedPosition = new Pair<>(0,0);
        assertEquals(expectedPosition, position);
    }

    @Test
    void it_should_not_fail() {
        assertTrue(true);
    }
}
