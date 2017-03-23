package objects;

import gui.ChessColor;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Dame extends Figur
{
    public Dame(ChessColor figurColor)
    {
        super(null, figurColor);
        setFigurImage(getImage("images/" + figurColor.toString() + "_dame.png"));
    }


}
