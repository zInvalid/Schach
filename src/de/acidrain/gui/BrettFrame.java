package de.acidrain.gui;

import de.acidrain.utils.Constants;

import javax.swing.*;
import java.util.Random;

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
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        randomStartingTurn();
    }

    private void randomStartingTurn()
    {
        int i = new Random().nextInt(2);

        if(i == 0)
            Constants.turn = ChessColor.WHITE;
        else if (i == 1)
            Constants.turn = ChessColor.BLACK;

        JOptionPane.showMessageDialog(null, Constants.turn.toString() + " fängt an!");
        setTitle(Constants.turn.toString());
    }

    @Override
    public void setTitle(String title)
    {
        super.setTitle("Schach by R0bian - " + title + " ist dran!");
    }
}
