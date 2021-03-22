package com.edu.grupo6.models;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.MoveCalculation;

import java.util.ArrayList;
// -------------------------------------------------------------------------

/**
 * Class to represent the Bishop piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece {
    public Bishop(ChessGameBoard board) {
        super(board);
    }
    /**
     * Creates a new Bishop object.
     *
     * @param board board the board to create the bishop on
     * @param row   row location of the Bishop
     * @param col   col location of the Bishop
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
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
        ArrayList<String> northEastMoves = mc.calculateNorthEastMoves(board, 8);
        ArrayList<String> northWestMoves = mc.calculateNorthWestMoves(board, 8);
        ArrayList<String> southEastMoves = mc.calculateSouthEastMoves(board, 8);
        ArrayList<String> southWestMoves = mc.calculateSouthWestMoves(board, 8);
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northEastMoves);
        allMoves.addAll(northWestMoves);
        allMoves.addAll(southEastMoves);
        allMoves.addAll(southWestMoves);
        return allMoves;
    }

    @Override
    public String getPieceName() {
        return "BISHOP";
    }
}
