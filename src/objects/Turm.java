package objects;

import gui.ChessColor;

public class Turm extends Figur
{


    public Turm(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.TURM);
        setFigurImage(getImage("images/" + figurColor.toString() + "_turm.png"));
    }


}
