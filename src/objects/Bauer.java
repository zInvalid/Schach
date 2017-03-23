package objects;

import gui.ChessColor;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Bauer extends Figur
{
    public Bauer(ChessColor figurColor)
    {
        super(null, figurColor);
        setFigurImage(getImage("images/" + figurColor.toString() + "_bauer.png"));
    }
}
