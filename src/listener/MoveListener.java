package listener;

import gui.FeldLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Invalid on 16.03.2017.
 */
public class MoveListener implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent e)
    {
        //JLabel which gets clicked
        FeldLabel jLabel = (FeldLabel) e.getSource();

        if (FeldLabel.prevLabel == null && jLabel.getIcon() != null)
        {
            if (jLabel.getFigurColor().equals(FeldLabel.turn))
            {
                FeldLabel.prevLabel = jLabel;
                jLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
            else
                JOptionPane.showMessageDialog(null, FeldLabel.turn.toString() + " ist dran!");

        }
        else
        {
            if (jLabel.getFigurColor() == null || jLabel.getFigurColor() != FeldLabel.prevLabel.getFigurColor())
            {
                jLabel.setIcon(FeldLabel.prevLabel.getIcon());
                jLabel.setFigurColor(FeldLabel.prevLabel.getFigurColor());

                FeldLabel.turn = jLabel.getFigurColor().getNegation();

                FeldLabel.prevLabel.setBorder(null);
                FeldLabel.prevLabel.setIcon(null);
                FeldLabel.prevLabel.setFigurColor(null);
                FeldLabel.prevLabel = null;
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
