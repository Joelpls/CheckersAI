package Main;

public class CheckersMove {

    Coordinate startCoordinate;
    Coordinate endCoordinate;
    private boolean canJump;

    public CheckersMove(Coordinate startCoordinate, Coordinate endCoordinate, boolean canJump) {
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        this.canJump = canJump;
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    public void setStartCoordinate(Coordinate startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public boolean canJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public void setEndCoordinate(Coordinate endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    public static class Coordinate{
        int row;
        int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }
    }


}
