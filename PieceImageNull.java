

public class PieceImageNull extends PieceImageHandler{

    @Override
    public boolean hasImage() {
        return false;
    }
    @Override
    protected String getPath() {

        return "chessImages/BlackKing.gif";
    }
}