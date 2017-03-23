package gui;

import com.sun.istack.internal.NotNull;
import listener.MoveListener;
import objects.Figur;

import javax.swing.*;
import java.awt.*;

public class FeldLabel extends JLabel
{
    /**
     * Cache label, which gets first clicked
     */
    public static FeldLabel prevLabel = null;

    /**
     * Players turn
     */
    public static FigurColor turn = null;

    private Figur figur;
    private FigurColor figurColor;
    /**
     * @param color Chess field color (white or black)
     * @param icon Figures picture
     * @param figurColor Figure color (white or black)
     */
    public FeldLabel(@NotNull Color color, Icon icon, Figur figur)
    {
        this.setBackground(color);
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setIcon(icon);
        this.addMouseListener(new MoveListener());
    }

    public FigurColor getFigurColor()
    {
        return figurColor;
    }

    public void setFigurColor(FigurColor figurColor)
    {
        this.figurColor = figurColor;
    }


}
