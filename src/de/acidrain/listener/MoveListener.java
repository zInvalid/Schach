package de.acidrain.listener;

import de.acidrain.game.Game;
import de.acidrain.gui.FieldLabel;
import de.acidrain.net.packets.Packet02Move;
import de.acidrain.game.objects.Figures.Bauer;
import de.acidrain.game.objects.Figures.FigurType;
import de.acidrain.utils.Constants;

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
        //Multiplayer Game
        if (Constants.multiplayer)
        {
            if (Constants.turn.equals(Game.instance.player1.getColor()))
            {
                move(e, true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, Constants.turn.toString() + " ist dran!");
            }
        }
        else
        {
            move(e, false);
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

    public void move(MouseEvent e, boolean multiplayer)
    {
        FieldLabel jLabel = (FieldLabel) e.getSource();

        if (Constants.selectedLabel == null && jLabel.getFigur() != null)
        {
            if (jLabel.getFigur().getFigurColor().equals(Constants.turn))
            {
                Constants.selectedLabel = jLabel;
                jLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                for (FieldLabel fieldLabel : jLabel.getFigur().moveAblesFields())
                {
                    fieldLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, Constants.turn.toString() + " ist dran!");
            }
        }
        else if (Constants.selectedLabel != null && Constants.selectedLabel.equals(jLabel))
        {
            for (FieldLabel fieldLabel : Constants.selectedLabel.getFigur().moveAblesFields())
            {
                fieldLabel.setBorder(null);
            }
            Constants.selectedLabel.setBorder(null);
            Constants.selectedLabel = null;
        }
        else if (Constants.selectedLabel != null && (jLabel.getFigur() == null || jLabel.getFigur().getFigurColor() != Constants.selectedLabel.getFigur().getFigurColor()) && jLabel.getBorder() != null && ((LineBorder) jLabel.getBorder()).getLineColor().equals(Color.GREEN))
        {

            if (multiplayer)
            {
                Packet02Move movePacket = new Packet02Move(Game.instance.player1.getUsername(), Game.instance.player1.getColor(), Constants.selectedLabel.getXCoord(), Constants.selectedLabel.getYCoord(), jLabel.getXCoord(), jLabel.getYCoord());
                movePacket.writeData(Game.instance.client);
            }
            for (FieldLabel fieldLabel : Constants.selectedLabel.getFigur().moveAblesFields())
            {
                fieldLabel.setBorder(null);
            }
            if (Constants.selectedLabel.getFigur().getType().equals(FigurType.BAUER))
            {
                Bauer bauer = (Bauer) Constants.selectedLabel.getFigur();
                bauer.setMoved(true);
            }

            jLabel.setIcon(Constants.selectedLabel.getFigur().getFigurImage());
            jLabel.setFigur(Constants.selectedLabel.getFigur());
            Constants.turn = jLabel.getFigur().getFigurColor().getNegation();

            Game.instance.frame.setTitle(Constants.turn.toString());

            Constants.selectedLabel.setBorder(null);
            Constants.selectedLabel.setIcon(null);
            Constants.selectedLabel.setFigur(null);
            Constants.selectedLabel = null;
        }
    }
}
