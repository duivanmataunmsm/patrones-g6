package com.edu.grupo6.builder;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.enums.PieceType;
import com.edu.grupo6.impl.ChessGamePieceBuilder;
import com.edu.grupo6.models.King;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ChessGamePieceBuilderTest {

    @Test
    void shouldExpectSpecificPiece() {
        ChessGameBoard board = new ChessGameBoard();
        ChessGamePiece piece;
        ChessGamePieceBuilder builder = new ChessGamePieceBuilder(board, PieceType.KING);
        piece = builder.build();
        Assertions.assertInstanceOf(King.class, piece);
    }
    @Test
    void shouldExpectBlackPiece() {
        ChessGameBoard board = new ChessGameBoard();
        ChessGamePiece piece;
        ChessGamePieceBuilder builder = new ChessGamePieceBuilder(board, PieceType.KING);
        piece = builder.withColor(0).build();
        Assertions.assertEquals(0, piece.getColorOfPiece());
    }
    @Test
    void shouldExpectWhitePiece() {
        ChessGameBoard board = new ChessGameBoard();
        ChessGamePiece piece;
        ChessGamePieceBuilder builder = new ChessGamePieceBuilder(board, PieceType.KING);
        piece = builder.withColor(1).build();
        Assertions.assertEquals(1, piece.getColorOfPiece());
    }

    @Test
    void shouldExpectColumn() {
        ChessGameBoard board = new ChessGameBoard();
        ChessGamePiece piece;
        ChessGamePieceBuilder builder = new ChessGamePieceBuilder(board, PieceType.KING);
        piece = builder.withColumn(1).build();
        Assertions.assertEquals(1, piece.getColumn());
    }

    @Test
    void withRow() {
        Assertions.assertEquals(1, 1);
    }


}