import java.security.InvalidParameterException;

import org.javatuples.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rover {
    private static final Logger LOGGER = LoggerFactory.getLogger(Rover.class);
    private Integer X = 0;
    private Integer Y = 0;
    private ORIENTATION orientation = ORIENTATION.SOUTH;
    private int[][] planete = { {}, {} };

    public Rover() {
    }

    // The initial seting is the landing site
    public Rover(Pair<Integer, Integer> landingPoint, ORIENTATION landingOrientation) {
        this.X = landingPoint.getValue0();
        this.Y = landingPoint.getValue1();
        this.orientation = landingOrientation;
    }

    // The initial seting is the landing site on the targeted planete
    public Rover(Pair<Integer, Integer> landingPoint, ORIENTATION landingOrientation, int[][] planete) {
        this.X = landingPoint.getValue0();
        this.Y = landingPoint.getValue1();
        this.orientation = landingOrientation;
        this.planete = planete;
    }

    public Pair<Integer, Integer> getPosition() {
        return Pair.with(this.X, this.Y);
    }

    public ORIENTATION getOrientation() {
        return this.orientation;
    }

    private void setOrientation(ORIENTATION orientation) {
        this.orientation = orientation;
    }

    public void goForward(int i) throws ObstacleEnconterException {
        Pair<Integer, Integer> previousPosition = this.getPosition();
        switch (this.orientation) {
            case NORTH:
                this.X -= i;
                break;
            case SOUTH:
                this.X += i;
                break;
            case WEST:
                this.Y -= i;
                break;
            case EST:
                this.Y += i;
                break;
        }

        // we check if we are on test on Earth or in real mission on Mars
        if (this.planete.length > 0) {
            this.civconvolutionCheck();
            if (this.planete[this.X][this.Y] == 1) { // obstacle

                this.X = previousPosition.getValue0();
                this.Y = previousPosition.getValue1();
                throw new ObstacleEnconterException("Obstacle encounter");

            }
        }
    }

    private void civconvolutionCheck() {
        int circonference = this.planete[0].length;
        int polarCirconference = this.planete.length;

        if (this.X < 0) { // crossing North pole
            this.X = 0;
            int newY = (circonference / 2 + this.Y) % circonference;
            this.Y = newY;
            this.orientation = ORIENTATION.SOUTH; // once cross we are facing oposite direction
        }
        if (this.X >= polarCirconference) { // crossing South pole
            this.X = polarCirconference - 1;
            int newY = (circonference / 2 + this.Y) % circonference;
            this.Y = newY;
            this.orientation = ORIENTATION.NORTH; // once cross we are facing oposite direction
        }

        if (this.Y < 0) { // circonvolution West
            this.Y = circonference - 1;
        }
        if (this.Y >= circonference) { // circonvolution Est
            this.Y = 0;
        }
    }

    public void goBackward(int i) throws ObstacleEnconterException {
        this.goForward(-i);
    }

    public void turnRight() {
        this.setOrientation(this.getOrientation().turnRight());
    }

    public void turnLeft() {
        this.setOrientation(this.getOrientation().turnLeft());
    }

    public void receiveCommands(String command) {
        for(String c: command.split("")){
            try {
                this.consumeSingleCommand(c);
            } catch (ObstacleEnconterException e) {
                LOGGER.warn("Obstacle enconter");
                return;
            }
        }
    }

    public void consumeSingleCommand(String command) throws ObstacleEnconterException {
        switch (command) {
            case "F":
                this.goForward(1);

                break;
            case "B":
                this.goBackward(1);
                break;
            case "R":
                this.turnRight();
                break;
            case "L":
                this.turnLeft();
                break;
            default:
                throw new InvalidParameterException(String.format("The string %s could not be treated", command));
        }
    }

}
