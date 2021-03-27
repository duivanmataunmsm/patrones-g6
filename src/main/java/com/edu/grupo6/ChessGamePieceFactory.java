package com.edu.grupo6;

import com.edu.grupo6.builder.ChessGamePieceBuilder;
import com.edu.grupo6.enums.PieceType;

import java.util.HashMap;

public class ChessGamePieceFactory {
    HashMap<PieceType, ChessGamePieceBuilder> pieces;

    ChessGamePieceFactory() {
        pieces = new HashMap<PieceType, ChessGamePieceBuilder>();
    }

    /**
     * Busca una pieza por tipo, si la encuetra, retorna el objeto guardado, si no, lo crea
     *
     * @param type:  PieceType
     * @param board: int
     * @return ChessGamePiece
     */
    public ChessGamePieceBuilder getBuilder(PieceType type, ChessGameBoard board) {
        ChessGamePieceBuilder result = pieces.get(type);
        if (result == null) {

            result = new ChessGamePieceBuilder(board, type);
            pieces.put(type, result);
        }
        return result;
    }
}
