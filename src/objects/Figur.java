package objects;

import com.sun.istack.internal.NotNull;
import gui.ChessColor;

import javax.swing.*;

/**
 * Created by e6_grumptmann on 23.03.2017.
 */
public class Figur
{
    private ImageIcon figurImage;
    private final ChessColor figurColor;

    public Figur(@NotNull ImageIcon figurImage, @NotNull ChessColor figurColor)
    {
        this.figurImage = figurImage;
        this.figurColor = figurColor;
    }

    public ImageIcon getFigurImage()
    {
        return figurImage;
    }

    public void setFigurImage(ImageIcon figurImage)
    {
        this.figurImage = figurImage;
    }

    public ChessColor getFigurColor()
    {
        return figurColor;
    }

    public ImageIcon getImage(String pfad)
    {
        if (getClass().getResource(pfad) != null)
            return new ImageIcon(getClass().getResource(pfad));
        else
            return null;
    }
}
