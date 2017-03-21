package gui;

import com.sun.istack.internal.NotNull;
import listener.MoveListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Invalid on 16.03.2017.
 */
public class FeldLabel extends JButton
{
    /**
     * Cache label, which gets first clicked
     */
    public static FeldLabel prevLabel = null;

    private FigurColor figurColor;

    /**
     * @param color Chess field color (white or black)
     * @param icon Figures picture
     * @param figurColor Figure color (white or black)
     */
    public FeldLabel(@NotNull Color color, Icon icon, FigurColor figurColor)
    {
        this.setBackground(color);
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setIcon(icon);
        this.addMouseListener(new MoveListener());
        this.figurColor = figurColor;
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
