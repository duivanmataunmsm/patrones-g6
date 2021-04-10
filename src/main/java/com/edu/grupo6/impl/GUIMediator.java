package com.edu.grupo6.impl;

import com.edu.grupo6.ChessPanel;
import com.edu.grupo6.interfaces.IComponent;
import com.edu.grupo6.interfaces.IGUIMediator;

import javax.swing.*;
import java.awt.*;

public class GUIMediator implements IGUIMediator {
    JMenuBar menuBar;
    JPanel panel;

    @Override
    public void registerComponent(IComponent component) {
        component.setMediator(this);
        System.out.println(component.getClass().getName());
        switch (component.getName()) {
            case "MenuBar":
                menuBar = (JMenuBar) component;
                break;
            case "ChessGameBoard":
                panel = (JPanel) component;
                break;
            default: break;
        }
    }
    @Override
    public void clickMenuEvent(String buttonName) {
        switch (buttonName) {
            case "About":
                aboutHandler();
                break;
            case "New game/restart":
                restartHandler();
                break;
            case "Toggle game log":
                toggleGameLogHandler();
                break;
            case "Exit":
                exitHandler();
                break;
            default:
                toggleGraveyardHandler();
                break;
        }
    }

    /**
     * Takes an appropriate action if the about button is clicked.
     */
    private void aboutHandler() {
        JOptionPane.showMessageDialog(
                menuBar.getParent(),
                "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                        + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT");
    }

    /**
     * Takes an appropriate action if the restart button is clicked.
     */
    private void restartHandler() {
        ((ChessPanel) menuBar.getParent()).getGameEngine().reset();
    }

    /**
     * Takes an appropriate action if the exit button is clicked.
     * Uses Tony Allevato's code for exiting a GUI app without System.exit()
     * calls.
     */
    private void exitHandler() {
        JOptionPane.showMessageDialog(menuBar.getParent(), "Thanks for leaving"
                + ", quitter! >:(");
        Component possibleFrame = menuBar;
        while (possibleFrame != null && !(possibleFrame instanceof JFrame)) {
            possibleFrame = possibleFrame.getParent();
        }
        JFrame frame = (JFrame) possibleFrame;
        frame.setVisible(false);
        frame.dispose();
    }

    /**
     * Takes an appropriate action if the toggle graveyard button is clicked.
     */
    private void toggleGraveyardHandler() {
        ((ChessPanel) menuBar.getParent()).getGraveyard(1).setVisible(
                !((ChessPanel) menuBar.getParent()).getGraveyard(1).isVisible());
        ((ChessPanel) menuBar.getParent()).getGraveyard(2).setVisible(
                !((ChessPanel) menuBar.getParent()).getGraveyard(2).isVisible());
    }

    /**
     * Takes an appropriate action if the toggle game log button is clicked.
     */
    private void toggleGameLogHandler() {
        ((ChessPanel) menuBar.getParent()).getGameLog().setVisible(
                !((ChessPanel) menuBar.getParent()).getGameLog().isVisible());
        ((ChessPanel) menuBar.getParent()).revalidate();
    }
}
