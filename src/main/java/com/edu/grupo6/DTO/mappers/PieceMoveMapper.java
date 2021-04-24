package com.edu.grupo6.DTO.mappers;

import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.DTO.PieceMoveDTO;
import com.edu.grupo6.Logging;

public class PieceMoveMapper{
    public Logging logging;

    public PieceMoveMapper(Logging logging) {
        this.logging = logging;
    }

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
        this.logging.getLogger().info(
                String.format(
                        "Piece: %s, Color: %s, Column: %s, Row: %s, PreviousCol: %s, PreviousRow: %s",
                        dto.getPiece(),
                        dto.getColor(),
                        dto.getCurrentColumn(),
                        dto.getCurrentRow(),
                        dto.getPreviousColumn(),
                        dto.getPreviousRow()
                        )
        );
    }
}