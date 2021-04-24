package com.edu.grupo6.impl;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.models.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {

    @org.junit.jupiter.api.Test
    void test() {
        ChessGameBoard board = new ChessGameBoard();
        PieceFactory pf = new PieceFactory();
        ChessGamePiece pawn = pf.getPiece(board,1,1);

        assertTrue(pawn instanceof Pawn);
    }
}