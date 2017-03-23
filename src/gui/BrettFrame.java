package gui;

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

        randomStartingTurn();

        this.setVisible(true);
    }

    private void randomStartingTurn()
    {
        int i = new Random().nextInt(2);

        if(i == 0)
            FeldLabel.turn = FigurColor.WHITE;
        else if (i == 1)
            FeldLabel.turn = FigurColor.BLACK;

        JOptionPane.showMessageDialog(null, FeldLabel.turn.toString() + " fängt an!");
    }
}
