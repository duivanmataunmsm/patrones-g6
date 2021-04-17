package com.edu.grupo6.DTO.mappers;

import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.DTO.PieceMoveDTO;

public class PieceMoveMapper{

    public PieceMoveDTO createDTO(ChessGamePiece piece, int previousCol, int previousRow) {
        PieceMoveDTO dto = new PieceMoveDTO();
        dto.setPiece(piece.getPieceName());
        dto.setColor(piece.getColorOfPiece() == 1 ? "WHITE" : "BLACK");
        dto.setCurrentColumn(piece.getColumn());
        dto.setCurrentRow(piece.getRow());
        dto.setPreviousRow(previousRow);
        dto.setPreviousColumn(previousCol);

        return dto;
    }

    public void logMove(PieceMoveDTO dto) {
        //TODO: guardar el dto en una base de datos
    }
}