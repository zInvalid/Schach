package de.acidrain.gui;

import java.awt.*;

public enum ChessColor
{
    BLACK(Color.BLACK, "Schwarz"),
    WHITE(Color.WHITE, "Weiss");

    private Color color;
    private String name;

    ChessColor() {
    }

    ChessColor(Color color, String name)
    {
        this.color = color;
        this.name = name;
    }

    public ChessColor getNegation()
    {
        if (this == BLACK)
            return WHITE;
        else if (this == WHITE)
            return BLACK;
        else
            return null;
    }

    /**
     * Similar to {@link #toString() toString}
     *
     * @return {@link Color color}
     */
    public Color toColor() {return color;}

    @Override
    public String toString()
    {
        return name;
    }
}
