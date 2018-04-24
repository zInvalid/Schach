package de.acidrain.listener;

import de.acidrain.game.Game;
import de.acidrain.gui.FieldLabel;
import de.acidrain.game.objects.Figures.Bauer;
import de.acidrain.game.objects.Figures.FigurType;
import de.acidrain.net.packets.PacketMove;
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
            if(Game.instance.waiting)
                JOptionPane.showMessageDialog(null, "Warte auf Gegenspieler!");
            else
            {
                if (Constants.turn.equals(Game.instance.player.getColor()))
                {
                    move(e, true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, Game.instance.player.getUsername() + " (" + Constants.turn.toString() + ") ist dran!");
                }
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
        FieldLabel clickedLabel = (FieldLabel) e.getSource();

        if (Constants.selectedLabel == null && clickedLabel.getFigur() != null)
        {
            if (clickedLabel.getFigur().getFigurColor().equals(Constants.turn))
            {
                Constants.selectedLabel = clickedLabel;
                clickedLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                for (FieldLabel fieldLabel : clickedLabel.getFigur().moveAblesFields())
                {
                    fieldLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Falsche Farbe, " + Constants.turn.toString() + " ist dran!");
            }
        }
        else if (Constants.selectedLabel != null && Constants.selectedLabel.equals(clickedLabel))
        {
            for (FieldLabel fieldLabel : Constants.selectedLabel.getFigur().moveAblesFields())
            {
                fieldLabel.setBorder(null);
            }
            Constants.selectedLabel.setBorder(null);
            Constants.selectedLabel = null;
        }
        else if (Constants.selectedLabel != null && (clickedLabel.getFigur() == null || clickedLabel.getFigur().getFigurColor() != Constants.selectedLabel.getFigur().getFigurColor()) && clickedLabel.getBorder() != null && ((LineBorder) clickedLabel.getBorder()).getLineColor().equals(Color.GREEN))
        {

            if (multiplayer)
            {
                PacketMove movePacket = new PacketMove(Game.instance.player.getColor(), Constants.selectedLabel.getXCoord(), Constants.selectedLabel.getYCoord(), clickedLabel.getXCoord(), clickedLabel.getYCoord());
                Game.instance.client.sendTCP(movePacket);
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

            clickedLabel.setIcon(Constants.selectedLabel.getFigur().getFigurImage());
            clickedLabel.setFigur(Constants.selectedLabel.getFigur());

            if(clickedLabel.getFigur().getType().equals(FigurType.KOENIG) && !clickedLabel.getFigur().getFigurColor().equals(Constants.turn))
                JOptionPane.showMessageDialog(null, "Gz du hast gewonnen (" + Constants.turn + ")");

            Constants.turn = clickedLabel.getFigur().getFigurColor().getNegation();

            Game.instance.frame.setTitle(Constants.turn.toString());

            Constants.selectedLabel.setBorder(null);
            Constants.selectedLabel.setIcon(null);
            Constants.selectedLabel.setFigur(null);
            Constants.selectedLabel = null;
        }
    }
}
