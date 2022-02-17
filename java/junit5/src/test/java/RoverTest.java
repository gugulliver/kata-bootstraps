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

    // The rover should be able to go forward
    @Test
    void rover_advance() {
        Rover firstRover = new Rover();
        firstRover.goForward(1);
        Pair<Integer, Integer> position = firstRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(1,0);
        assertEquals(expectedPosition, position);
    }
    
    // The rover should be able to go backward
    @Test
    void rover_retreat() {
        Rover firstRover = new Rover();
        firstRover.goBackward(1);
        Pair<Integer, Integer> position = firstRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(-1,0);
        assertEquals(expectedPosition, position);
    }
}
