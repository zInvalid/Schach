package objects;

import gui.ChessColor;

public class Springer extends Figur
{
    public Springer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.SPRINGER);
        setFigurImage(getImage("images/" + figurColor.toString() + "_pferd.png"));
    }
}
