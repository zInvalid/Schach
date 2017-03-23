package gui;

import objects.Figur;

import java.awt.*;

public enum FigurColor
{
    BLACK,
    WHITE;

    public FigurColor getNegation()
    {
        if(this == BLACK)
            return WHITE;
        else if (this == WHITE)
            return BLACK;
        else
            return null;
    }


    public FigurColor getFigurColorFromColor(String color)
    {
        if(color.equalsIgnoreCase("schwarz"))
            return BLACK;
        else if (color.equalsIgnoreCase("weiss"))
            return WHITE;
        else
            return null;
    }

    public String toColor()
    {
        if(this == BLACK)
            return "weiss";
        else if (this == WHITE)
            return "schwarz";
        else
            return null;
    }

    @Override
    public String toString()
    {
        return this == BLACK ? "Schwarz" : "Weiß";
    }
}
