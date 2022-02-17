import org.junit.jupiter.api.Test;
import org.javatuples.Pair;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTestMars {

    // ADVENCE TEST
    // The rover is noww on Mars
    // "Implement wrapping from one edge of the grid to another. (planets are
    // spheres after all)"

    int[][] MARS = new int[6][6];

    // The rover should take into acount the spherical shape of Mars
    @Test
    void rover_cross_pole() {
        Pair<Integer, Integer> landingPosition = Pair.with(0, 2);

        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.NORTH, MARS);
        firstMarsRover.receiveCommands("F");

        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(0, 5);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.SOUTH);
    }

    // The rover should take into acount the spherical shape of Mars
    @Test
    void rover_make_a_circumnavigation() {
        Pair<Integer, Integer> landingPosition = Pair.with(1, 5);

        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.EST, MARS);
        firstMarsRover.receiveCommands("F");

        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(1, 0);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.EST);
    }
}
