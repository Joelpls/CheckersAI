package Main;

public class CheckersPiece {

    private boolean isKing;
    private boolean isHuman;

    public CheckersPiece(boolean isKing, boolean isHuman) {
        this.isKing = isKing;
        this.isHuman = isHuman;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public boolean isAi() {
        return !isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }
}
