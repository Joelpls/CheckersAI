package Test;

import static org.junit.Assert.*;

import Main.CheckersMove;
import Main.CheckersPlayer;
import Main.CheckersState;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckersStateTest {

    CheckersState state;
    List<CheckersMove> testList;
    @Before
    public void initialize(){
        state = new CheckersState();

    }

    @org.junit.Test
    public void movePiece() {

        List<CheckersMove> moveList = state.movePiece(2,5,false);
        System.out.println(state.board.printBoard());
        for(CheckersMove m : moveList){
            System.out.println(m.getEndCoordinate().getRow() + " " + m.getEndCoordinate().getColumn());
        }
        state.takeMove(moveList.get(0));
        System.out.println(state.board.printBoard());
    }

}