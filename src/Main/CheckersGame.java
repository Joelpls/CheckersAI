package Main;

import aima.core.search.adversarial.Game;

import java.util.ArrayList;
import java.util.List;

public class CheckersGame implements Game<CheckersState, CheckersMove, String> {

    CheckersState initialState = new CheckersState();

    @Override
    public CheckersState getInitialState() {
        return initialState;
    }

    @Override
    public String[] getPlayers() {
        return new String[] {CheckersState.HUMAN, CheckersState.AI};
    }

    @Override
    public String getPlayer(CheckersState state) {
        return state.getPlayerToMove();
    }

    @Override
    public List<CheckersMove> getActions(CheckersState state) {
        List<CheckersMove> moves = state.everyMove();
        List<CheckersMove> legalMoves = new ArrayList<>();

        //see if there's any jumps
        for(CheckersMove m : moves){
            if(m.canJump()){
                legalMoves.add(m);
            }
        }
        if(!legalMoves.isEmpty()){
            return legalMoves;
        }
        else{
            return moves;
        }
    }

    @Override
    public CheckersState getResult(CheckersState checkersState, CheckersMove checkersMove) {
        CheckersState result = checkersState.clone();
        System.out.println("move: " +checkersMove.getStartCoordinate().getRow() + " " + checkersMove.getStartCoordinate().getColumn());
        result.takeMove(checkersMove);
        return result;
    }

    @Override
    public double getUtility(CheckersState checkersState, String player) {
        //double result = state.
        return 0;
    }

    @Override
    public boolean isTerminal(CheckersState checkersState) {
        return false;
    }




}
