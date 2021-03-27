package com.edu.grupo6.interfaces;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;

public interface IPieceFactory {
    ChessGamePiece getPiece(ChessGameBoard board, int row, int col);
}
