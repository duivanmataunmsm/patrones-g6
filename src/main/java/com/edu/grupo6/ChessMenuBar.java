package com.edu.grupo6;

import com.edu.grupo6.interfaces.IComponent;
import com.edu.grupo6.interfaces.IGUIMediator;

import java.awt.event.*;
import javax.swing.*;
// -------------------------------------------------------------------------

/**
 * Represents the north menu-bar that contains various controls for the game.
 *
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessMenuBar extends JMenuBar implements IComponent {
    IGUIMediator mediator;
    // ----------------------------------------------------------

    /**
     * Create a new ChessMenuBar object.
     */
    public ChessMenuBar() {
        String[] menuCategories = {"File", "Options", "Help"};
        String[] menuItemLists =
                {"New game/restart,Exit", "Toggle graveyard,Toggle game log",
                        "About"};
        for (int i = 0; i < menuCategories.length; i++) {
            JMenu currMenu = new JMenu(menuCategories[i]);
            String[] currMenuItemList = menuItemLists[i].split(",");
            for (int j = 0; j < currMenuItemList.length; j++) {
                JMenuItem currItem = new JMenuItem(currMenuItemList[j]);
                currItem.addActionListener(new MenuListener());
                currMenu.add(currItem);
            }
            this.add(currMenu);
        }
    }

    @Override
    public void setMediator(IGUIMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "MenuBar";
    }

    /**
     * Listener for the north menu bar.
     *
     * @author Ben Katz (bakatz)
     * @author Myles David II (davidmm2)
     * @author Danielle Bushrow (dbushrow)
     * @version 2010.11.17
     */
    private class MenuListener
            implements ActionListener {
        /**
         * Takes an appropriate action based on which menu button is clicked
         *
         * @param event the mouse event from the source
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            String buttonName = ((JMenuItem) event.getSource()).getText();
            mediator.clickMenuEvent(buttonName);
        }
    }
}
