package com.edu.grupo6.impl;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.enums.PieceType;
import com.edu.grupo6.interfaces.IPieceFactory;

public class PieceFactory implements IPieceFactory {

    public ChessGamePiece getPiece(ChessGameBoard board, int row, int col) {
        ChessGamePiece pieceToAdd;
        if (row == 1) // black pawns
        {
            pieceToAdd = new ChessGamePieceBuilder(board, PieceType.PAWN)
                    .withRow(row)
                    .withColumn(col)
                    .withColor(ChessGamePiece.BLACK)
                    .withImage()
                    .withSkipMoveGeneration(true)
                    .withPossibleMoves()
                    .build();

        } else if (row == 6) // white pawns
        {
            //pieceToAdd = new Pawn( this, i, j, ChessGamePiece.WHITE );
            pieceToAdd = new ChessGamePieceBuilder(board, PieceType.PAWN)
                    .withRow(row)
                    .withColumn(col)
                    .withColor(ChessGamePiece.WHITE)
                    .withImage()
                    .withSkipMoveGeneration(true)
                    .withPossibleMoves()
                    .build();
        } else if (row == 0 || row == 7) // main rows
        {
            int colNum =
                    row == 0 ? ChessGamePiece.BLACK : ChessGamePiece.WHITE;
            if (col == 0 || col == 7) {
                //pieceToAdd = new Rook( this, i, j, colNum );
                pieceToAdd = new ChessGamePieceBuilder(board, PieceType.ROOK)
                        .withRow(row)
                        .withColumn(col)
                        .withColor(colNum)
                        .withImage()
                        .withSkipMoveGeneration(false)
                        .withPossibleMoves()
                        .build();
            } else if (col == 1 || col == 6) {
                //pieceToAdd = new Knight( this, i, j, colNum );
                pieceToAdd = new ChessGamePieceBuilder(board, PieceType.KNIGHT)
                        .withRow(row)
                        .withColumn(col)
                        .withColor(colNum)
                        .withImage()
                        .withSkipMoveGeneration(false)
                        .withPossibleMoves()
                        .build();;
            } else if (col == 2 || col == 5) {
                //pieceToAdd = new Bishop( this, i, j, colNum );
                pieceToAdd = new ChessGamePieceBuilder(board, PieceType.BISHOP)
                        .withRow(row)
                        .withColumn(col)
                        .withColor(colNum)
                        .withImage()
                        .withSkipMoveGeneration(false)
                        .withPossibleMoves()
                        .build();
            } else if (col == 3) {
                //pieceToAdd = new King( this, i, j, colNum );
                pieceToAdd = new ChessGamePieceBuilder(board, PieceType.KING)
                        .withRow(row)
                        .withColumn(col)
                        .withColor(colNum)
                        .withImage()
                        .withSkipMoveGeneration(false)
                        .withPossibleMoves()
                        .build();
            } else {
                //pieceToAdd = new Queen( this, i, j, colNum );
                pieceToAdd = new ChessGamePieceBuilder(board, PieceType.QUEEN)
                        .withRow(row)
                        .withColumn(col)
                        .withColor(colNum)
                        .withImage()
                        .withSkipMoveGeneration(false)
                        .withPossibleMoves()
                        .build();
            }
        } else {
            pieceToAdd = null;
        }
        return pieceToAdd;
    }

}
