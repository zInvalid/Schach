package gui;

import listener.MoveListener;
import objects.Figur;

import javax.swing.*;

public class FieldLabel extends JLabel
{

    private Figur figur;

    private final int x;
    private final int y;

    /**
     * @param figur
     * @param chessColor Chess field color (white or black)
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
