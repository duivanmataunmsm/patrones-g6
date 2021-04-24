package com.edu.grupo6.DTO.mappers;

import com.edu.grupo6.ChessGameBoard;
import com.edu.grupo6.ChessGamePiece;
import com.edu.grupo6.DTO.PieceMoveDTO;
import com.edu.grupo6.Logging;
import com.edu.grupo6.impl.PieceFactory;
import com.edu.grupo6.models.Pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PieceMoveMapperTest {

    @org.junit.jupiter.api.Test
    void test() {
        ChessGameBoard board = new ChessGameBoard();
        PieceFactory pf = new PieceFactory();
        ChessGamePiece pawn = pf.getPiece(board,1,1);

        Logging logging = new Logging();

        PieceMoveMapper pmm = new PieceMoveMapper(logging);
        PieceMoveDTO pdtp = pmm.createDTO(pawn,1,1);
        pmm.logMove(pdtp);

        assertEquals(logging.getLogger().getName(),"ChessLog");
    }

}
