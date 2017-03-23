package objects;

import gui.ChessColor;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Koenig extends Figur
{
    public Koenig(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.KOENIG);
        setFigurImage(getImage("images/" + figurColor.toString() + "_koenig.png"));
    }
}
