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

        if(FeldLabel.selectedLabel == null && jLabel.getFigur() != null)
        {
            FeldLabel.selectedLabel = jLabel;
            jLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        }

        /*if (FeldLabel.selectedLabel == null && jLabel.getIcon() != null)
        {
            if (jLabel.getFigur().getFigurColor().equals(FeldLabel.turn))
            {
                FeldLabel.selectedLabel = jLabel;
                jLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
            }
            else
                JOptionPane.showMessageDialog(null, FeldLabel.turn.toString() + " ist dran!");

        }
        else
        {
            if (jLabel.getFigur().getFigurColor() == null || jLabel.getFigur().getFigurColor() != FeldLabel.selectedLabel.getFigur().getFigurColor())
            {
                jLabel.setIcon(FeldLabel.selectedLabel.getIcon());
                jLabel.setFigurColor(FeldLabel.selectedLabel.getFigurColor());

                FeldLabel.turn = jLabel.getFigurColor().getNegation();

                FeldLabel.selectedLabel.setBorder(null);
                FeldLabel.selectedLabel.setIcon(null);
                FeldLabel.selectedLabel.setFigurColor(null);
                FeldLabel.selectedLabel = null;
            }

        }*/
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
