package Main;

import aima.core.search.adversarial.AdversarialSearch;
import aima.core.search.adversarial.AlphaBetaSearch;
import aima.core.search.adversarial.IterativeDeepeningAlphaBetaSearch;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CheckersState state = new CheckersState();

        CheckersBoard board = new CheckersBoard();
        System.out.println(state.board.printBoard());

        Scanner scan = new Scanner(System.in);
        System.out.println("Type \"exit\" to quit");
        System.out.println("Choose checker to move");
//        System.out.print("Choose a row: ");
        while(scan.hasNextLine()){
//            String input = scan.nextLine();
            System.out.print("Choose a row: ");
            int row = scan.nextInt();
            System.out.print("Choose a column: ");
            int col = scan.nextInt();
            System.out.println("You chose: " + "["+row+", "+col+"]");

            System.out.print("Is this correct? [y, n]");
            String correct = scan.next().toLowerCase();
            System.out.println(correct);
            if(!correct.equals("y")){
                continue;
            }

            List<CheckersMove> moveList = state.movePiece(row, col, state.board.isKing(row, col));
            if(moveList == null || moveList.isEmpty()){
                System.out.println("Please make a valid choice");
                continue;
            }

            System.out.println(state.board.printBoard());
            System.out.println("Choose a move: ");
            int moveCounter = 1;
            for(CheckersMove m : moveList){
                System.out.println(moveCounter + ": " +"(" + row + ", " + col + ") -> (" +m.getEndCoordinate().getRow() + ", " + m.getEndCoordinate().getColumn()+")");
                moveCounter++;
            }
            System.out.print("Move: ");
            int moveNum = scan.nextInt();
            System.out.print("you chose: " + moveNum);
            System.out.println();
            state.takeMove(moveList.get(moveNum-1));
            System.out.println(state.board.printBoard());


        }

        scan.close();

        /*
        CheckersGame game = new CheckersGame();
        CheckersState currState = game.getInitialState();

        AdversarialSearch<CheckersState, CheckersMove> search;
        search = AlphaBetaSearch.createFor(game);

        CheckersMove move = search.makeDecision(currState);
        System.out.println(move.getEndCoordinate().getRow() + " "+ move.getEndCoordinate().getColumn());
*/
    }

}
