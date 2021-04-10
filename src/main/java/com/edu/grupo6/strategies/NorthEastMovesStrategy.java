package com.edu.grupo6.strategies;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.interfaces.IMoveStrategy;

import java.util.ArrayList;

public class NorthEastMovesStrategy implements IMoveStrategy {

    @Override
    public ArrayList<String> calculateMoves(ChessGameBoard board, ChessGamePiece piece, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (piece.isPieceOnScreen()) {
            for (int i = 1; i < 8 && count < numMoves; i++) {
                if (piece.isOnScreen(piece.getRow() - i, piece.getColumn() + i)
                        && (board.getCell(piece.getRow() - i,
                        piece.getColumn() + i).getPieceOnSquare() == null)) {
                    moves.add((piece.getRow() - i) + "," + (piece.getColumn() + i));
                    count++;
                } else if (piece.isEnemy(board, piece.getRow() - i, piece.getColumn() + i)) {
                    moves.add((piece.getRow() - i) + "," + (piece.getColumn() + i));
                    count++;
                    break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
