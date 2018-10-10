package Main;

import java.util.Arrays;

public class CheckersBoard {

    private CheckersPiece[][] board;

    public CheckersBoard(){

        board = new CheckersPiece[8][8];
        initializeBoard();

    }

    public CheckersBoard(boolean b){
        if(b){
            board = new CheckersPiece[8][8];
            testBoard();
        }
    }

    public CheckersBoard(CheckersBoard copyBoard){
        this.board = new CheckersPiece[8][8];
        this.board = Arrays.copyOf(copyBoard.board, copyBoard.board.length);
    }

    private void initializeBoard() {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                //
                if(row % 2 == 0){
                    if(row <= 2) {
                        col++;
                        board[row][col] = new CheckersPiece(false, false);
                    }
                    else if(row >= 5){
                        board[row][col+1] = new CheckersPiece(false, true);
                        col++;
                    }
                }
                //
                if(row % 2 == 1 ){
                    if(row <= 2) {
                        board[row][col] = new CheckersPiece(false, false);
                        col++;
                    }
                    else if(row >= 5){
                        col++;
                        board[row][col-1] = new CheckersPiece(false, true);
                    }
                }
            }
        }
    }

    public CheckersPiece[][] getBoard() {
        return board;
    }

    public void setBoard(CheckersPiece[][] board) {
        this.board = board;
    }

    public CheckersPiece getSpotOnBoard(int row, int col){
        return board[row][col];
    }

    public boolean spotIsNull(int row, int col){
        return board[row][col] == null;
    }

    public boolean spotIsHuman(int row, int col){
        return board[row][col] != null && board[row][col].isHuman();
    }

    public boolean spotIsAi(int row, int col){
        return board[row][col] != null && !board[row][col].isHuman();
    }

    public void setSpot(int row, int col, CheckersPiece piece){
        board[row][col] = piece;
    }

    public boolean isKing(int row, int col){
        return board[row][col].isKing();
    }

    public String printBoard(){
        String printedBoard = "";

        printedBoard += "   ";
        for(int i = 0; i < 8; i++){
            printedBoard += i + "  ";
        }
        printedBoard += "\n";
        for(int i = 0; i < board.length; i++){
            printedBoard += i + " ";
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == null && (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1 )){
                    printedBoard += " ■ ";
                }
                else if(board[i][j] == null){
                     printedBoard += " □ ";
                 }
                else if(board[i][j].isHuman()){
//                    printedBoard += " ● ";
                    printedBoard += " R ";
                }
                else if(!board[i][j].isHuman()){
//                    printedBoard += " ○ ";
                    printedBoard += " W ";
                }
            }

            printedBoard += "\n";
        }
        return printedBoard;
    }

    private void testBoard() {
        initializeBoard();
        board[2][3] = null;
        board[4][1] = new CheckersPiece(false, false);
        board[5][6] = null;
        board[3][4] = new CheckersPiece(false, true);
    }
}
