package objects;

import gui.ChessColor;

/**
 * Created by e6_grumptmann on 23.03.2017.
 */
public class Turm extends Figur
{
    public Turm(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.TURM);
        setFigurImage(getImage("images/" + figurColor.toString() + "_turm.png"));
    }


}
