package objects;

import gui.ChessColor;

public class Dame extends Figur
{
    public Dame(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.DAME);
        setFigurImage(getImage("images/" + figurColor.toString() + "_dame.png"));
    }


}
