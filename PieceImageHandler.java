import javax.swing.*;

public abstract class PieceImageHandler {
    String path;

    public ImageIcon getImage() {
        return new ImageIcon(getClass().getResource(this.getPath()));
    }

    protected String getPath() {
        return this.path;
    };

    public abstract boolean hasImage();

}