import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ImageSingletonTest {

    @org.junit.jupiter.api.Test
    void getInstance() {

        ImageSingleton single = new ImageSingleton();
        ImageSingleton single1 = ImageSingleton.getInstance();
    }

    @org.junit.jupiter.api.Test
    void getPieceImage() {
        ImageSingleton single = ImageSingleton.getInstance();
        ChessGameBoard board = new ChessGameBoard();

        King king1 = new King(board,1,1,1);
        PieceImageHandler piece1 = single.getPieceImage(king1);
        assertTrue(piece1 instanceof  PieceImage);

        King king2 = new King(board,1,1,4);
        PieceImageHandler piece2 = single.getPieceImage(king2);
        assertTrue(piece2 instanceof  PieceImageNull);
    }
}