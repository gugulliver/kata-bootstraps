import org.javatuples.Pair;

public class Rover {

    private Integer X = 0;
    private Integer Y = 0;
    private ORIENTATION orientation = ORIENTATION.SOUTH;

    public Rover() {
    }
    // The initial seting is the landing one
    public Rover (Pair<Integer, Integer> landingPoint, ORIENTATION landingOrientation) {
        this.X = landingPoint.getValue0();
        this.Y = landingPoint.getValue1();
        this.orientation = landingOrientation;
    }


    public Pair<Integer, Integer> getPosition() {
        return Pair.with(this.X, this.Y);
    }

    public ORIENTATION getOrientation() {
        return this.orientation;
    }

    public void goForward(int i) {
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
    }

    public void goBackward(int i) {
        this.goForward(-i);
    }

}
