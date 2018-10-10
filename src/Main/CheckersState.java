package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckersState implements Cloneable{
    public static final String AI = "W";
    public static final String HUMAN = "R";
    public static final String EMPTY = ".";
//    public CheckersBoard board = new CheckersBoard(true);
    public CheckersBoard board = new CheckersBoard();
    //TODO change for testing
    private String playerToMove = HUMAN;
//    private CheckersPlayer currentPlayer;
    private List<CheckersMove> moveList = new ArrayList<>();

    public CheckersState(/*CheckersPlayer currentPlayer*/){
//        this.currentPlayer = currentPlayer;
    }

    public String getPlayerToMove(){
        return playerToMove;
    }

    public List<CheckersMove> everyMove(){
        //for each AI piece, get their moves
        CheckersPiece[][] currboard = board.getBoard();
        for(int i = 0; i < currboard.length; i++){
            for(int j = 0; j < currboard[0].length; j++){
                if (currboard[i][j] != null && currboard[i][j].isAi()){
                    movePiece(i,j,currboard[i][j].isKing());
                }
            }
        }
        return moveList;
    }

    public List<CheckersMove> movePiece(int row, int col, boolean isKing ){

        boolean canJump = false;

        //this is not a player
        if(board.spotIsNull(row, col)){
            return null;
        }

        System.out.println(playerToMove);
        System.out.println(board.spotIsHuman(row,col));

        if(playerToMove.equals(AI) && board.spotIsHuman(row, col)
            || playerToMove.equals(HUMAN) && board.spotIsAi(row, col)){
            return null;
        }

        CheckersMove.Coordinate startCoordinate = new CheckersMove.Coordinate(row, col);
        int y = 1;
        if(board.spotIsHuman(row, col)){
            y = -1;
        }


        if(!isKing){
            if(row+y < 8 && row+y >= 0 && col+1 < 8 &&
                    ((playerToMove.equals(AI) && board.spotIsHuman(row+y,col+1)) ||  ((playerToMove.equals(HUMAN) && board.spotIsAi(row+y,col+1))))){
                if(row+y+y < 8 && row+y+y >= 0 && col+2 < 8 && board.spotIsNull(row+y+y, col+2)){
                    //jump piece
                    canJump = true;
                    addToMoveList(row+y+y, col+2, startCoordinate, canJump);
                    //movePiece(row+y+y, col+2, false);
                }
            }
            if(row+y < 8 && row+y >= 0 && col-1 >= 0 &&
                    ((playerToMove.equals(AI) && board.spotIsHuman(row+y,col-1)) || ((playerToMove.equals(HUMAN) && board.spotIsAi(row+y,col-1))))){
                if(row+y+y < 8 && row+y+y >= 0 && col-2 >= 0 && board.spotIsNull(row+y+y, col-2)){
                    //jump piece
                    canJump = true;
                    addToMoveList(row+y+y, col-2, startCoordinate, canJump);
                    //movePiece(row+y+y, col-2, false);
                }
            }

            //only look at these kinds of moves if there are no jump moves.
            if(canJump == false) {
                if (row + y < 8 && row + y >= 0 && col + 1 < 8 && board.spotIsNull(row + y, col + 1)) {
                    addToMoveList(row + y, col + 1, startCoordinate, canJump);
                }
                if (row + y < 8 && row + y >= 0 && col - 1 >= 0 && board.spotIsNull(row + y, col - 1)) {
                    addToMoveList(row + y, col - 1, startCoordinate, canJump);
                }
            }
        }

        return moveList;

    }

    public void takeMove(CheckersMove move){
        CheckersMove.Coordinate start = move.startCoordinate;
        int startRow = start.getRow();
        int startCol = start.getColumn();
        CheckersMove.Coordinate end = move.endCoordinate;
        int endRow = end.getRow();
        int endCol = end.getColumn();
        CheckersPiece currPlayer = board.getSpotOnBoard(startRow, startCol);

        //not a jump
        if(!move.canJump()) {

            board.setSpot(startRow, startCol, null);

            board.setSpot(endRow, endCol, currPlayer);
        }
        else{
            board.setSpot(startRow, startCol, null);

            //jumped piece gone
            int y;
            if(currPlayer.isAi()){
                y = endRow - startRow - 1;
            }
            else{
                y = endRow - startRow + 1;
            }
            if(endCol > startCol) {
                int x = endCol - startCol - 1;
                board.setSpot(startRow + y, startCol + x, null);
            }
            else{
                int x = endCol - startCol + 1;
                board.setSpot(startRow + y, startCol + x, null);
            }

            board.setSpot(endRow, endCol, currPlayer);
        }

        moveList.clear();

        playerToMove = (playerToMove.equals(HUMAN) ? AI : HUMAN);
    }

    @Override
    public CheckersState clone(){
        CheckersState copy = null;
        try {
            copy = (CheckersState) super.clone();
            copy.board = new CheckersBoard(board);
//            copy.currentPlayer = new CheckersPlayer(currentPlayer);
            //copy.moveList = new ArrayList<CheckersMove>(moveList);
            copy.moveList = new ArrayList<CheckersMove>();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return copy;
    }

    private void addToMoveList(int row, int col, CheckersMove.Coordinate startCoordinate, boolean canJump){
        CheckersMove.Coordinate endCoordinate =  new CheckersMove.Coordinate(row, col);
        CheckersMove move = new CheckersMove(startCoordinate, endCoordinate, canJump);
        moveList.add(move);
    }

}
