package objects;

import gui.ChessColor;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Springer extends Figur
{
    public Springer(ChessColor figurColor)
    {
        super(null, figurColor);
        setFigurImage(getImage("images/" + figurColor.toString() + "_pferd.png"));
    }
}
