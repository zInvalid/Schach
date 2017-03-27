package objects;

import com.sun.istack.internal.NotNull;
import gui.ChessColor;
import gui.FieldLabel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Figur
{
    private ImageIcon figurImage;
    private final ChessColor figurColor;
    private final FigurType type;

    Figur(@NotNull ImageIcon figurImage, @NotNull ChessColor figurColor, @NotNull FigurType type)
    {
        this.figurImage = figurImage;
        this.figurColor = figurColor;
        this.type = type;
    }

    public ImageIcon getFigurImage()
    {
        return figurImage;
    }

    @Deprecated
    void setFigurImage(ImageIcon figurImage)
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

    public FigurType getType()
    {
        return type;
    }

    public abstract ArrayList<FieldLabel> moveAblesFields();

}
