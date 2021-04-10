package com.edu.grupo6.strategies;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.interfaces.IMoveStrategy;

import java.util.ArrayList;

public class SouthMovesStrategy implements IMoveStrategy {

    @Override
    public ArrayList<String> calculateMoves(ChessGameBoard board, ChessGamePiece piece, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (piece.isPieceOnScreen()) {
            for (int i = piece.getRow() + 1; i < 8 && count < numMoves; i++) {
                if ((board.getCell(i, piece.getColumn()).getPieceOnSquare()
                        == null || piece.isEnemy(board, i, piece.getColumn()))) {
                    moves.add(i + "," + piece.getColumn());
                    count++;
                    if (piece.isEnemy(board, i, piece.getColumn())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
