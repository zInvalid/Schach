package gui;

import java.awt.*;

public enum ChessColor
{
    BLACK,
    WHITE;

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
     * Similar to {@link #toString() method}
     *
     * @return Color
     */
    public Color toColor() {return this == BLACK ? Color.BLACK : Color.WHITE;}

    @Override
    public String toString()
    {
        return this == BLACK ? "schwarz" : "weiss";
    }
}
