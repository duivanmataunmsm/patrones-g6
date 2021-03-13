import javax.swing.ImageIcon;
import java.util.ArrayList;
// import java.awt.Color;
// -------------------------------------------------------------------------
/**
 * Represents a Queen game piece.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Queen
    extends ChessGamePiece{
    // ----------------------------------------------------------
    /**
     * Create a new Queen object.
     *
     * @param board
     *            the board the queen is on
     * @param row
     *            the row location of the queen
     * @param col
     *            the column location of the queen
     * @param color
     *            either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Queen( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color );
    }
    /**
     * Calculates the possible moves for this Queen.
     * @param board the board to check on
     * @return ArrayList<String> the list of moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        MoveCalculation mc = new MoveCalculation(this);
        ArrayList<String> northEastMoves = mc.calculateNorthEastMoves( board, 8 );
        ArrayList<String> northWestMoves = mc.calculateNorthWestMoves( board, 8 );
        ArrayList<String> southEastMoves = mc.calculateSouthEastMoves( board, 8 );
        ArrayList<String> southWestMoves = mc.calculateSouthWestMoves( board, 8 );
        ArrayList<String> northMoves = mc.calculateNorthMoves( board, 8 );
        ArrayList<String> southMoves = mc.calculateSouthMoves( board, 8 );
        ArrayList<String> eastMoves = mc.calculateEastMoves( board, 8 );
        ArrayList<String> westMoves = mc.calculateWestMoves( board, 8 );
        ArrayList<String> allMoves = new ArrayList<String>();

        addMoves(northEastMoves,northWestMoves,southEastMoves,southWestMoves,
                northMoves,southMoves,eastMoves,westMoves,allMoves);

        return allMoves;
    }
    void addMoves( ArrayList<String> northEastMoves,ArrayList<String> northWestMoves,
                            ArrayList<String> southEastMoves,ArrayList<String> southWestMoves,
                            ArrayList<String> northMoves,ArrayList<String> southMoves,
                            ArrayList<String> eastMoves,ArrayList<String> westMoves,
                            ArrayList<String> moves){
        moves.addAll( northEastMoves);
        moves.addAll( northWestMoves );
        moves.addAll( southEastMoves );
        moves.addAll( southWestMoves );
        moves.addAll( northMoves );
        moves.addAll( southMoves );
        moves.addAll( eastMoves );
        moves.addAll( westMoves );
    }
    @Override
    public String getPieceName() {
        return "QUEEN";
    }
}
