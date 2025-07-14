import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Menu{

    public JMenuBar menuBar;
    public JMenu fileMenu;
    public boolean gameActive = false;
    public boolean reseter = false;
    public Menu(){
        menuBar = new JMenuBar();
        /*$*================================================*$*/
        JButton buttonPauseResume = new JButton("Pause/Resume");
        buttonPauseResume.setFocusable(false);
        buttonPauseResume.setHorizontalTextPosition(buttonPauseResume.LEFT);
        buttonPauseResume.addActionListener(new ActionListener()
            {
                // @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle "New" action
                    gameActive = !gameActive;
                    System.out.println("Game State: " + gameActive);
                }

            });
        /*$*================================================*$*/
        JButton buttonReset = new JButton("Reset");
        buttonReset.setFocusable(false);
        buttonReset.addActionListener(new ActionListener()
            {
                // @Override
                public void actionPerformed(ActionEvent e) {
                    reseter = true;
                    System.out.println("Game State: Game Reseted");
                }

            });
        /*$*================================================*$*/
        fileMenu = new JMenu("Menu");
        //menuBar.add(fileMenu);
        menuBar.add(buttonPauseResume);
        menuBar.add(buttonReset);

    }

    public void setGameState(boolean state)
    {
        gameActive = state;
    }

    public void setReseter(boolean state)
    {
        reseter = state;
    }    
}