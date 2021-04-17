package com.edu.grupo6.strategies;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.interfaces.IMoveStrategy;

import java.util.ArrayList;

public class MoveContext {

    private IMoveStrategy strategy;

    public MoveContext() {}

    public MoveContext(IMoveStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IMoveStrategy strategy) {
        this.strategy = strategy;
    }

    public ArrayList<String> calculate(ChessGameBoard board, ChessGamePiece piece, int numMoves) {
        return this.strategy.calculateMoves(board, piece, numMoves);
    }
}
