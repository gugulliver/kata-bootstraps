public enum ORIENTATION {
    NORTH,
    EST,
    SOUTH,
    WEST;

    // to represent a turn we go one step into the enum (which is sorted)
    // If it reaching the end of it the return value is taken by the one from the other side 
    public ORIENTATION turnRight() { 
        return this.ordinal() < ORIENTATION.values().length - 1
        ? ORIENTATION.values()[this.ordinal() + 1]
        : NORTH;

    }
    
    public ORIENTATION turnLeft() {
        return this.ordinal() > 0
        ? ORIENTATION.values()[this.ordinal() - 1]
        : WEST;

    }
}
