package com.edu.grupo6.strategies;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.interfaces.IMoveStrategy;

import java.util.ArrayList;

public class EastMovesStrategy implements IMoveStrategy {

    @Override
    public ArrayList<String> calculateMoves(ChessGameBoard board, ChessGamePiece piece, int numMoves) {
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if (piece.isPieceOnScreen()) {
            for (int i = piece.getColumn() + 1; i < 8 && count < numMoves; i++) {
                if ((board.getCell(piece.getRow(), i).getPieceOnSquare()
                        == null || piece.isEnemy(board, piece.getRow(), i))) {
                    moves.add(piece.getRow() + "," + i);
                    count++;
                    if (piece.isEnemy(board, piece.getRow(), i)) {
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
