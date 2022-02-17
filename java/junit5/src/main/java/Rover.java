import org.javatuples.Pair;


public class Rover {

    private Pair<Integer, Integer> position = new Pair<>(0,0);

    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
