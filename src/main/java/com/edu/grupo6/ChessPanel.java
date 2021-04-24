package com.edu.grupo6;

import com.edu.grupo6.impl.GUIMediator;
import com.edu.grupo6.interfaces.IGUIMediator;

import java.awt.*;
import javax.swing.*;
// -------------------------------------------------------------------------

/**
 * The main panel of the Chess game.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessPanel
        extends JPanel {
    private ChessMenuBar menuBar;
    private ChessGameBoard gameBoard;
    private ChessGameLog gameLog;
    private ChessGraveyard playerOneGraveyard;
    private ChessGraveyard playerTwoGraveyard;
    private ChessGameEngine gameEngine;
    // ----------------------------------------------------------

    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel() {
        IGUIMediator mediator = new GUIMediator();
        this.setLayout(new BorderLayout());
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        gameLog = new ChessGameLog();
        mediator.registerComponent(menuBar);
        playerOneGraveyard = new ChessGraveyard("Player 1's graveyard");
        playerTwoGraveyard = new ChessGraveyard("Player 2's graveyard");
        this.add(menuBar, BorderLayout.NORTH);
        this.add(gameBoard, BorderLayout.CENTER);
        this.add(gameLog, BorderLayout.SOUTH);
        this.add(playerOneGraveyard, BorderLayout.WEST);
        this.add(playerTwoGraveyard, BorderLayout.EAST);
        this.setPreferredSize(new Dimension(800, 600));

        Logging logging = new Logging();
        gameEngine = new ChessGameEngine(gameBoard, logging); // start the game
    }
    // ----------------------------------------------------------

    /**
     * Gets the logger object for use in other classes.
     *
     * @return ChessGameLog the ChessGameLog object
     */
    public ChessGameLog getGameLog() {
        return gameLog;
    }
    // ----------------------------------------------------------

    /**
     * Gets the board object for use in other classes.
     *
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard() {
        return gameBoard;
    }
    // ----------------------------------------------------------

    /**
     * Gets the game engine object for use in other classes
     *
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine() {
        return gameEngine;
    }
    // ----------------------------------------------------------

    /**
     * Gets the appropriate graveyard object for use in other classes.
     *
     * @param whichPlayer the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard(int whichPlayer) {
        if (whichPlayer == 1) {
            return playerOneGraveyard;
        } else if (whichPlayer == 2) {
            return playerTwoGraveyard;
        } else {
            return null;
        }
    }
}
