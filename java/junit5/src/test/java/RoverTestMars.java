import org.junit.jupiter.api.Test;
import org.javatuples.Pair;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTestMars {

    // ADVENCE TEST
    // The rover is now on Mars
    // "Implement wrapping from one edge of the grid to another. (planets are
    // spheres after all)"

    int[][] MARS = new int[6][6];

    // The rover should take into acount the spherical shape of Mars
    @Test
    void rover_cross_north_pole() {
        Pair<Integer, Integer> landingPosition = Pair.with(0, 2);

        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.NORTH, MARS);
        firstMarsRover.receiveCommands("F");

        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(0, 5);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.SOUTH);
    }

    @Test
    void rover_cross_south_pole() {
        Pair<Integer, Integer> landingPosition = Pair.with(5, 2);

        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.SOUTH, MARS);
        firstMarsRover.receiveCommands("F");

        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(5, 5);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.NORTH);
    } 

    @Test
    void rover_make_a_circumnavigation_est() {
        Pair<Integer, Integer> landingPosition = Pair.with(1, 5);

        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.EST, MARS);
        firstMarsRover.receiveCommands("F");

        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(1, 0);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.EST);
    }

    @Test
    void rover_make_a_circumnavigation_west() {
        Pair<Integer, Integer> landingPosition = Pair.with(5, 0);

        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.WEST, MARS);
        firstMarsRover.receiveCommands("FF");

        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(5, 4);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.WEST);
    }

    
    @Test
    void rover_enconter_obstacle() {
        MARS[3][4]=1;

        Pair<Integer, Integer> landingPosition = Pair.with(2, 3);
        Rover firstMarsRover = new Rover(landingPosition, ORIENTATION.SOUTH, MARS);

        firstMarsRover.receiveCommands("FLFRF"); // the second F shound enconter obstacle


        Pair<Integer, Integer> position = firstMarsRover.getPosition();
        ORIENTATION orientation = firstMarsRover.getOrientation();

        Pair<Integer, Integer> expectedPosition = Pair.with(3, 3);
        assertEquals(expectedPosition, position);
        assertEquals(orientation, ORIENTATION.EST);
    }
}
