package gui;

import listener.MoveListener;
import objects.Figur;

import javax.swing.*;

public class FeldLabel extends JLabel
{
    /**
     * Cache label, which gets first clicked
     */
    public static FeldLabel selectedLabel = null;

    /**
     * Players turn
     */
    public static ChessColor turn = null;

    private Figur figur;
    private ChessColor figurColor;

    /**
     * @param figur
     * @param chessColor Chess field color (white or black)
     */
    public FeldLabel(Figur figur, ChessColor chessColor)
    {
        this.figur = figur;

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
}
