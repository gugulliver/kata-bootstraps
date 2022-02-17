public enum ORIENTATION {
    NORTH,
    EST,
    SOUTH,
    WEST;

    public ORIENTATION turnRight() {
        return this.ordinal() < ORIENTATION.values().length - 1
        ? ORIENTATION.values()[this.ordinal() + 1]
        : NORTH;

    }
    
    public ORIENTATION turnLeft() {
        return this.ordinal() < 0
        ? ORIENTATION.values()[this.ordinal() - 1]
        : WEST;

    }
}
