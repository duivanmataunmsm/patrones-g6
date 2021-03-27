package com.edu.grupo6.builder;

import com.edu.grupo6.*;
import com.edu.grupo6.enums.PieceType;
import com.edu.grupo6.interfaces.IChessGamePieceBuilder;
import com.edu.grupo6.models.*;

public class ChessGamePieceBuilder implements IChessGamePieceBuilder {

    ChessGamePiece piece;
    ChessGameBoard board;

    public ChessGamePieceBuilder(ChessGameBoard board, PieceType type) {
        this.reset(board, type);
    }

    @Override
    public ChessGamePieceBuilder withColor(int color) {
        this.piece.setPieceColor(color);
        return this;
    }

    @Override
    public ChessGamePieceBuilder withColumn(int column) {
        this.piece.setPieceColumn(column);
        return this;
    }

    @Override
    public ChessGamePieceBuilder withRow(int row) {
        this.piece.setPieceRow(row);
        return this;
    }

    @Override
    public ChessGamePieceBuilder withSkipMoveGeneration(boolean skip) {
        this.piece.setSkipMoveGeneration(skip);
        return this;
    }

    @Override
    public ChessGamePieceBuilder withPossibleMoves() {
        this.piece.setPossibleMoves(this.board);
        return this;
    }

    @Override
    public ChessGamePieceBuilder withImage() {
        this.piece.setPieceImage();
        return this;
    }

    @Override
    public void reset(ChessGameBoard board, PieceType type) {
        this.board = board;
        switch (type){
            case BISHOP:
                this.piece = new Bishop(board);
                break;
            case KING:
                this.piece = new King(board);
                break;
            case KNIGHT:
                this.piece = new Knight(board);
                break;
            case PAWN:
                this.piece = new Pawn(board);
                break;
            case QUEEN:
                this.piece = new Queen(board);
                break;
            case ROOK:
                this.piece = new Rook(board);
                break;
            default:
                this.piece = null;
        }
    }

    @Override
    public ChessGamePiece build() {
        return this.piece;
    }
}
