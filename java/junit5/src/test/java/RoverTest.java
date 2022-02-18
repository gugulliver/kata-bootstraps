import org.junit.jupiter.api.Test;
import org.javatuples.Pair;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

public class RoverTest {

    // BASIC TEST
    // "You are given the initial starting point (x,y) of a rover and the direction
    // (N,S,E,W) it is facing."

    // The rover should be present at it's initial spot when created
    @Test
    void rover_have_landed() {
        Rover firstRover = new Rover();
        Pair<Integer, Integer> position = firstRover.getPosition();
        Pair<Integer, Integer> expectedPosition = Pair.with(0, 0);
        assertEquals(expectedPosition, position);
    }

    // The rover should be present at it's specified initial spot when created
    @Test
    void rover_have_landed_specify() {
        Pair<Integer, Integer> expectedPosition = Pair.with(2, 3);
        Rover secondRover = new Rover(expectedPosition, ORIENTATION.NORTH);
        Pair<Integer, Integer> position = secondRover.getPosition();
        ORIENTATION orientation = secondRover.getOrientation();
        assertEquals(position, expectedPosition);
        assertEquals(orientation, ORIENTATION.NORTH);
    }

    // The rover should be able to go forward
    @Test
    void rover_advance() {
        Rover firstRover = new Rover();
        try {
            firstRover.goForward(1);
        } catch (ObstacleEnconterException e) {
            e.printStackTrace();
        }
        Pair<Integer, Integer> position = firstRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(1, 0);
        assertEquals(expectedPosition, position);
    }

    // The rover should be able to go backward
    @Test
    void rover_retreat() {
        Rover firstRover = new Rover();
        try {
            firstRover.goBackward(1);
        } catch (ObstacleEnconterException e) {
            e.printStackTrace();
        }
        Pair<Integer, Integer> position = firstRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(-1, 0);
        assertEquals(expectedPosition, position);
    }

    // The rover should be able to go forward
    @Test
    void rover_advance_multiple() {
        Rover firstRover = new Rover();
        try {
            firstRover.goForward(5);
        } catch (ObstacleEnconterException e) {
            e.printStackTrace();
        }
        Pair<Integer, Integer> position = firstRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(5, 0);
        assertEquals(expectedPosition, position);
    }

    // The rover should be able to go backward
    @Test
    void rover_retreat_multiple() {
        Rover firstRover = new Rover();
        try {
            firstRover.goBackward(5);
        } catch (ObstacleEnconterException e) {
            e.printStackTrace();
        }
        Pair<Integer, Integer> position = firstRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(-5, 0);
        assertEquals(expectedPosition, position);
    }

    // The rover should be able to turn Left
    @Test
    void rover_turn_left() {
        Pair<Integer, Integer> expectedPosition = Pair.with(1, 1);
        Rover secondRover = new Rover(expectedPosition, ORIENTATION.NORTH);
        secondRover.turnLeft();
        ORIENTATION orientation = secondRover.getOrientation();

        assertEquals(orientation, ORIENTATION.WEST);
    }

    @Test
    void rover_turn_left_2() {
        Pair<Integer, Integer> expectedPosition = Pair.with(1, 1);
        Rover secondRover = new Rover(expectedPosition, ORIENTATION.SOUTH);
        secondRover.turnLeft();
        ORIENTATION orientation = secondRover.getOrientation();

        assertEquals(ORIENTATION.EST, orientation);
    }

    // The rover should be able to turn Right
    @Test
    void rover_turn_right() {
        Pair<Integer, Integer> expectedPosition = Pair.with(1, 1);
        Rover secondRover = new Rover(expectedPosition, ORIENTATION.NORTH);
        secondRover.turnRight();
        ORIENTATION orientation = secondRover.getOrientation();

        assertEquals(orientation, ORIENTATION.EST);
    }

    // The rover interpret command from earth
    @Test
    void rover_folow_instruction() {
        Rover thirdRover = new Rover(); // 0,0 S
        thirdRover.receiveCommands("FLF");
        ORIENTATION curentOrientation = thirdRover.getOrientation();
        Pair<Integer, Integer> curentPosition = thirdRover.getPosition();

        Pair<Integer, Integer> expectedPosition = new Pair<>(1, 1);

        assertEquals(curentOrientation, ORIENTATION.EST);
        assertEquals(curentPosition, expectedPosition);
    }

    // The rover can not interpret command from earth
    @Test
    void rover_fail_to_folow_instruction() {
        Rover thirdRover = new Rover(); // 0,0 S

        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> thirdRover.receiveCommands("FAIL"),
                "Expected receiveCommands() to throw");

        assertTrue(thrown.getMessage().contains("The string A could not be treated"));
    }
}
