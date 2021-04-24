package com.edu.grupo6;
import com.edu.grupo6.interceptingFilter.FilterManager;
import com.edu.grupo6.login.LoginFrame;

import javax.swing.*;
// -------------------------------------------------------------------------

/**
 * Shows the GUI for the Chess game.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessMain {
    // ----------------------------------------------------------

    /**
     * Creates the GUI for Chess.
     *
     * @param args command line arguments, not used
     */
    public static void main(String[] args) {
        initLogin();
    }
    public static void initLogin() {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public static void initChess() {
        JFrame frame = new JFrame("YetAnotherChessGame 1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChessPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
