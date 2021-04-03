package com.edu.grupo6.models;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.MoveCalculation;
import com.edu.grupo6.interfaces.IMoveStrategy;
import com.edu.grupo6.strategies.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// -------------------------------------------------------------------------

/**
 * Represents a King game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class King extends ChessGamePiece {

    IMoveStrategy strategy;
    // ----------------------------------------------------------
    public King(ChessGameBoard board) {
        super(board);
    }
    /**
     * Create a new King object.
     *
     * @param board the board to create the king on
     * @param row   the row to create the king on
     * @param col   the column to create the king on
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public King(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color, false);
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible
     * moves, including illegal (but at the same time valid) moves.
     *
     * @param board the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        MoveCalculation mc = new MoveCalculation(this);

        ArrayList<String> allMoves = new ArrayList<String>();
        MoveContext context = new MoveContext();
        List<IMoveStrategy> strategies = Arrays.asList(
                new NorthEastMovesStrategy(),
                new NorthWestMovesStrategy(),
                new SouthWestMovesStrategy(),
                new SouthEastMovesStrategy(),
                new NorthMovesStrategy(),
                new SouthMovesStrategy(),
                new EastMovesStrategy(),
                new WestMovesStrategy()
        );

        for (IMoveStrategy strategy: strategies) {
            context.setStrategy(strategy);
            // MoveContext context = new MoveContext(strategy);
            allMoves.addAll(context.calculate(board, this,1));
        }

        return allMoves;
    }

    /**
     * Determines if this King is checked.
     *
     * @param board the board to check on
     * @return true if checked, false if not checked
     */
    public boolean isChecked(ChessGameBoard board) {
        return getCurrentAttackers(board).size() > 0;
    }

    @Override
    public String getPieceName() {
        return "KING";
    }
}
