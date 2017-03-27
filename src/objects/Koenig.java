package objects;

import gui.ChessColor;

public class Koenig extends Figur
{
    public Koenig(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.KOENIG);
        setFigurImage(getImage("images/" + figurColor.toString() + "_koenig.png"));
    }
}
