package com.edu.grupo6.interfaces;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;

import java.util.ArrayList;

public interface IMoveStrategy {
    public ArrayList<String> calculateMoves(ChessGameBoard board, ChessGamePiece piece, int numMoves);
}
