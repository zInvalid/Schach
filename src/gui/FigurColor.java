package gui;

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

    @Override
    public String toString()
    {
        return this == BLACK ? "schwarz" : "weiss";
    }
}
