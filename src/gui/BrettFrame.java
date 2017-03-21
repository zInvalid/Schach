package gui;

import javax.swing.*;

/**
 * Frame fürs Schachbrett
 */
public class BrettFrame extends JFrame
{

    public BrettFrame()
    {
        this.add(new BrettPanel());
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
