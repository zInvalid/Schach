package de.acidrain.gui;

import de.acidrain.utils.Constants;

import javax.swing.*;
/**
 * Frame fürs Schachbrett
 */
public class ChessFrame extends JFrame
{

    public ChessFrame()
    {
        this.add(new ChessPanel());
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle(Constants.turn.toString());
    }

    @Override
    public void setTitle(String title)
    {
        super.setTitle("Schach by Invalid - " + title + " ist dran!");
    }
}
