import javax.swing.ImageIcon;
import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 * Represents a Rook game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Rook
    extends ChessGamePiece{
    // private ArrayList<String> possibleMoves;
    // ----------------------------------------------------------
    /**
     * Create a new Rook object.
     *
     * @param board
     *            the board to create the rook on
     * @param row
     *            the row to create the rook on
     * @param col
     *            the column to create the rook on
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Rook( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color );
    }
    /**
     * Calculates the possible moves for this Rook.
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        MoveCalculation mc = new MoveCalculation(this);
        ArrayList<String> northMoves = mc.calculateNorthMoves( board, 8 );
        ArrayList<String> southMoves = mc.calculateSouthMoves( board, 8 );
        ArrayList<String> westMoves = mc.calculateWestMoves( board, 8 );
        ArrayList<String> eastMoves = mc.calculateEastMoves( board, 8 );
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll( northMoves );
        allMoves.addAll( southMoves );
        allMoves.addAll( westMoves );
        allMoves.addAll( eastMoves );
        return allMoves;
    }
    @Override
    public String getPieceName() {
        return "ROOK";
    }
}
