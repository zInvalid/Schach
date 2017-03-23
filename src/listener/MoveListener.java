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
        if (FeldLabel.selectedLabel == null && jLabel.getFigur() != null)
        {
            if (jLabel.getFigur().getFigurColor().equals(FeldLabel.turn))
            {
                FeldLabel.selectedLabel = jLabel;
                jLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                System.out.println();
            }
            else
                JOptionPane.showMessageDialog(null, FeldLabel.turn.toString() + " ist dran!");
        }

        if (FeldLabel.selectedLabel != null && (jLabel.getFigur() == null || jLabel.getFigur().getFigurColor() != FeldLabel.selectedLabel.getFigur().getFigurColor()))
        {
            switch (FeldLabel.selectedLabel.getFigur().getType())
            {
                case TURM:
                    if ((FeldLabel.selectedLabel.getXCoord() == jLabel.getXCoord() && FeldLabel.selectedLabel.getYCoord() != jLabel.getYCoord()) || (FeldLabel.selectedLabel.getXCoord() != jLabel.getXCoord() && FeldLabel.selectedLabel.getYCoord() == jLabel.getYCoord()))
                    {
                        jLabel.setIcon(FeldLabel.selectedLabel.getFigur().getFigurImage());
                        jLabel.setFigur(FeldLabel.selectedLabel.getFigur());

                        FeldLabel.turn = jLabel.getFigur().getFigurColor().getNegation();

                        FeldLabel.selectedLabel.setBorder(null);
                        FeldLabel.selectedLabel.setIcon(null);
                        FeldLabel.selectedLabel.setFigur(null);
                        FeldLabel.selectedLabel = null;
                    }
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
