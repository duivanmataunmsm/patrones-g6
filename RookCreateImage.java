import javax.swing.*;

public class RookCreateImage {

    public Rook getRook() {
        return rook;
    }

    public void setRook(Rook rook) {
        this.rook = rook;
    }

    private Rook rook;

    public RookCreateImage(
            Rook rook
    ){
        this.setRook(rook);
    }

    public ImageIcon createImage(){
        if ( this.getRook().getColorOfPiece() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                    getClass().getResource("chessImages/WhiteRook.gif")
            );
        }
        else if ( this.getRook().getColorOfPiece() == ChessGamePiece.BLACK ){
            return new ImageIcon(
                    getClass().getResource("chessImages/BlackRook.gif")
            );
        }
        else
        {
            return new ImageIcon(
                    getClass().getResource("chessImages/default-Unassigned.gif")
            );
        }
    }

}
