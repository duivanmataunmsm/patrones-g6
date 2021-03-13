import java.util.ArrayList;

public class MoveCalculation {

    ChessGamePiece piece;

    MoveCalculation(ChessGamePiece piece) {
        this.piece = piece;
    }
    /**
     * Calculates and returns moves in the south direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the calculated moves.
     */
    protected ArrayList<String> calculateSouthMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = this.piece.pieceRow + 1; i < 8 && count < numMoves; i++ ){
                if ( ( board.getCell( i, this.piece.pieceColumn ).getPieceOnSquare()
                        == null || this.piece.isEnemy( board, i, this.piece.pieceColumn ) ) ){
                    moves.add( i + "," + this.piece.pieceColumn );
                    count++;
                    if ( this.piece.isEnemy( board, i, this.piece.pieceColumn ) ){
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the north direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateNorthMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = this.piece.pieceRow - 1; i >= 0 && count < numMoves; i-- ){
                if ( ( board.getCell( i, this.piece.pieceColumn ).getPieceOnSquare()
                        == null || this.piece.isEnemy( board, i, this.piece.pieceColumn ) ) ){
                    moves.add( i + "," + this.piece.pieceColumn );
                    count++;
                    if ( this.piece.isEnemy( board, i, this.piece.pieceColumn ) ){
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the east direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateEastMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = this.piece.pieceColumn + 1; i < 8 && count < numMoves; i++ ){
                if ( ( board.getCell( this.piece.pieceRow, i ).getPieceOnSquare()
                        == null || this.piece.isEnemy( board, this.piece.pieceRow, i ) ) ){
                    moves.add( this.piece.pieceRow + "," + i );
                    count++;
                    if ( this.piece.isEnemy( board, this.piece.pieceRow, i ) ){
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the west direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateWestMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = this.piece.pieceColumn - 1; i >= 0 && count < numMoves; i-- ){
                if ( ( board.getCell(this.piece.pieceRow, i ).getPieceOnSquare()
                        == null || this.piece.isEnemy( board, this.piece.pieceRow, i ) ) ){
                    moves.add( this.piece.pieceRow + "," + i );
                    count++;
                    if ( this.piece.isEnemy( board, this.piece.pieceRow, i ) ){
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the north-west direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateNorthWestMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = 1; i < 8 && count < numMoves; i++ ){
                if ( this.piece.isOnScreen( this.piece.pieceRow - i, this.piece.pieceColumn - i )
                        && ( board.getCell( this.piece.pieceRow - i,
                        this.piece.pieceColumn - i ).getPieceOnSquare() == null ) ){
                    moves.add( ( this.piece.pieceRow - i ) + "," + ( this.piece.pieceColumn - i ) );
                    count++;
                }
                else if ( this.piece.isEnemy( board, this.piece.pieceRow - i, this.piece.pieceColumn - i ) ){
                    moves.add( ( this.piece.pieceRow - i ) + "," + ( this.piece.pieceColumn - i ) );
                    count++;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the north-east direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateNorthEastMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = 1; i < 8 && count < numMoves; i++ ){
                if ( this.piece.isOnScreen( this.piece.pieceRow - i, this.piece.pieceColumn + i )
                        && ( board.getCell( this.piece.pieceRow - i,
                        this.piece.pieceColumn + i).getPieceOnSquare() == null ) ){
                    moves.add( ( this.piece.pieceRow - i ) + "," + ( this.piece.pieceColumn + i ) );
                    count++;
                }
                else if ( this.piece.isEnemy( board, this.piece.pieceRow - i, this.piece.pieceColumn + i ) ){
                    moves.add( ( this.piece.pieceRow - i ) + "," + ( this.piece.pieceColumn + i ) );
                    count++;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the south-west direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateSouthWestMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = 1; i < 8 && count < numMoves; i++ ){
                if ( this.piece.isOnScreen( this.piece.pieceRow + i, this.piece.pieceColumn - i )
                        && ( board.getCell( this.piece.pieceRow + i,
                        this.piece.pieceColumn - i ).getPieceOnSquare() == null ) ){
                    moves.add( ( this.piece.pieceRow + i ) + "," + ( this.piece.pieceColumn - i ) );
                    count++;
                }
                else if ( this.piece.isEnemy( board, this.piece.pieceRow + i, this.piece.pieceColumn - i ) ){
                    moves.add( ( this.piece.pieceRow + i ) + "," + ( this.piece.pieceColumn - i ) );
                    count++;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }
    /**
     * Calculates and returns moves in the south-east direction relative to this
     * piece.
     *
     * @param board
     *            the board to calculate the moves on
     * @param numMoves
     *            the number of moves to calculate
     * @return ArrayList<String> the moves in this direction
     */
    protected ArrayList<String> calculateSouthEastMoves(
            ChessGameBoard board,
            int numMoves ){
        ArrayList<String> moves = new ArrayList<String>();
        int count = 0;
        if ( this.piece.isPieceOnScreen() ){
            for ( int i = 1; i < 8 && count < numMoves; i++ ){
                if ( this.piece.isOnScreen( this.piece.pieceRow + i, this.piece.pieceColumn + i )
                        && ( board.getCell( this.piece.pieceRow + i,
                        this.piece.pieceColumn + i ).getPieceOnSquare() == null ) ){
                    moves.add( ( this.piece.pieceRow + i ) + "," + ( this.piece.pieceColumn + i ) );
                    count++;
                }
                else if ( this.piece.isEnemy( board, this.piece.pieceRow + i, this.piece.pieceColumn + i ) ){
                    moves.add( ( this.piece.pieceRow + i ) + "," + ( this.piece.pieceColumn + i ) );
                    count++;
                    break;
                }
                else
                {
                    break;
                }
            }
        }
        return moves;
    }


}
