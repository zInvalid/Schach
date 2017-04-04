package objects;

import gui.ChessColor;
import gui.FieldLabel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Figur
{
    private ImageIcon figurImage;
    private final ChessColor figurColor;
    private final FigurType type;

    Figur(ImageIcon figurImage, ChessColor figurColor, FigurType type)
    {
        this.figurImage = figurImage;
        this.figurColor = figurColor;
        this.type = type;
    }

    public ImageIcon getFigurImage()
    {
        return figurImage;
    }

    void setFigurImage(ImageIcon figurImage)
    {
        this.figurImage = figurImage;
    }

    public ChessColor getFigurColor()
    {
        return figurColor;
    }

    ImageIcon getImage(String pfad)
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
