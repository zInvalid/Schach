package objects;

import gui.ChessColor;

public class Laeufer extends Figur
{
    public Laeufer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.LAEUFER);
        setFigurImage(getImage("images/" + figurColor.toString() + "_laeufer.png"));
    }
}
