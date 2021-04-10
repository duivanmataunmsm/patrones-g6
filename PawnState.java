import javax.swing.JOptionPane;
public class PawnState {
  public static ChessGamePiece upgradePawn(
    ChessGameBoard board,
    int row,
    int col,
    int color
  ) {
    String r = JOptionPane.showInputDialog("Qué quieres ser?:");
    
    if(r=="reyna")
      return new Queen(board, row, col, color);
    else if(r=="caballo")
      return new Knight(board, row, col, color);
    else if(r=="alfil")
      return new Bishop(board, row, col, color);
    else
      return new Rook(board, row, col, color);
  }
}
