package listener;

import gui.FieldLabel;
import utils.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MoveListener implements MouseListener
{

    @Override
    public void mouseClicked(MouseEvent e)
    {
        //JLabel which gets clicked
        FieldLabel jLabel = (FieldLabel) e.getSource();
        if (Constants.selectedLabel == null && jLabel.getFigur() != null)
        {
            if (jLabel.getFigur().getFigurColor().equals(Constants.turn))
            {
                Constants.selectedLabel = jLabel;
                jLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                //TODO - Nullpointer, coz no mechanics
                for(FieldLabel fieldLabel : jLabel.getFigur().moveAblesFields())
                {
                    fieldLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                }
            }
            else
                JOptionPane.showMessageDialog(null, Constants.turn.toString() + " ist dran!");
        }
        else if (Constants.selectedLabel != null && Constants.selectedLabel.equals(jLabel))
        {
            Constants.selectedLabel.setBorder(null);
            Constants.selectedLabel = null;
        }
        else if (Constants.selectedLabel != null && (jLabel.getFigur() == null || jLabel.getFigur().getFigurColor() != Constants.selectedLabel.getFigur().getFigurColor()))
        {
            //TODO - Add this "if statement to" the other, when other mechanics are finished!
            if(jLabel.getBorder() != null && ((LineBorder) jLabel.getBorder()).getLineColor().equals(Color.GREEN))
            {
                for (FieldLabel fieldLabel : Constants.selectedLabel.getFigur().moveAblesFields())
                {
                    fieldLabel.setBorder(null);
                }
            }


            jLabel.setIcon(Constants.selectedLabel.getFigur().getFigurImage());
            jLabel.setFigur(Constants.selectedLabel.getFigur());

            Constants.turn = jLabel.getFigur().getFigurColor().getNegation();

            Constants.selectedLabel.setBorder(null);
            Constants.selectedLabel.setIcon(null);
            Constants.selectedLabel.setFigur(null);
            Constants.selectedLabel = null;
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
