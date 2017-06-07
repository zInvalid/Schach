package de.acidrain.gui;

import de.acidrain.listener.MoveListener;
import de.acidrain.game.objects.Figures.Figur;

import javax.swing.*;

public class FieldLabel extends JLabel
{

    private Figur figur;

    private final int x, y;

    /**
     * @param figur      sets a {@link Figur figur] on the label
     * @param chessColor Chess field color (white or black)
     * @param x          x-coordinate
     * @param y          y-coordinate
     */
    FieldLabel(Figur figur, ChessColor chessColor, int x, int y)
    {
        this.figur = figur;
        this.x = x;
        this.y = y;
        this.setBackground(chessColor.toColor());
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new MoveListener());

        if (figur != null)
            this.setIcon(figur.getFigurImage());
    }

    public Figur getFigur()
    {
        return figur;
    }

    public void setFigur(Figur figur)
    {
        this.figur = figur;
    }

    public int getXCoord()
    {
        return x;
    }

    public int getYCoord()
    {
        return y;
    }

}
