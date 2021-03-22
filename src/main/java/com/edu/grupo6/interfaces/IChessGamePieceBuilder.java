package com.edu.grupo6.interfaces;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.builder.ChessGamePieceBuilder;
import com.edu.grupo6.enums.PieceType;

public interface IChessGamePieceBuilder {

    ChessGamePieceBuilder withColor(int color);

    ChessGamePieceBuilder withColumn(int column);

    ChessGamePieceBuilder withRow(int row);

    ChessGamePieceBuilder withSkipMoveGeneration(boolean flag);

    ChessGamePieceBuilder withPossibleMoves();

    ChessGamePieceBuilder withImage();

    void reset(ChessGameBoard board, PieceType type);

    ChessGamePiece build();
}
