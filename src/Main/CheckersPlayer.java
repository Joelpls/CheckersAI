package Main;

public class CheckersPlayer {

    private boolean isHuman;

    public CheckersPlayer(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public CheckersPlayer(CheckersPlayer playerCopy){
        this.isHuman = playerCopy.isHuman();
    }

    public boolean isHuman() {
        return isHuman;
    }

    public boolean isAi(){
        return !isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }
}
