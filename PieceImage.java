import javax.swing.ImageIcon;

import java.util.HashMap;

public class PieceImage {

    private final HashMap<String, String> paths;

    PieceImage() {
        this.paths = new HashMap<>();
        this.paths.put("BISHOP_WHITE", "chessImages/WhiteBishop.gif");
        this.paths.put("BISHOP_BLACK", "chessImages/BlackBishop.gif");
        this.paths.put("KING_WHITE", "chessImages/WhiteKing.gif");
        this.paths.put("KING_BLACK", "chessImages/BlackKing.gif");
        this.paths.put("KNIGHT_WHITE", "chessImages/WhiteKnight.gif");
        this.paths.put("KNIGHT_BLACK", "chessImages/BlackKnight.gif");
        this.paths.put("PAWN_WHITE", "chessImages/WhitePawn.gif");
        this.paths.put("PAWN_BLACK", "chessImages/BlackPawn.gif");
        this.paths.put("QUEEN_BLACK", "chessImages/BlackQueen.gif");
        this.paths.put("QUEEN_WHITE", "chessImages/WhiteQueen.gif");
        this.paths.put("ROOK_WHITE", "chessImages/WhiteRook.gif");
        this.paths.put("ROOK_BLACK", "chessImages/BlackRook.gif");
        this.paths.put("DEFAULT", "chessImages/default-Unassigned.gif");
    }

    public ImageIcon getImage(ChessGamePiece piece) {
        String path = this.getPath(piece);

        return new ImageIcon(getClass().getResource(path));
    }

    public String getPath(ChessGamePiece piece) {
        if ( piece.getColorOfPiece() == ChessGamePiece.WHITE ){
            return this.paths.get(piece.getPieceName() + "_WHITE");
        }
        else if ( piece.getColorOfPiece() == ChessGamePiece.BLACK ){
            return this.paths.get(piece.getPieceName() + "_BLACK");
        }
        else {
            return this.paths.get("DEFAULT");
        }
    }


}
