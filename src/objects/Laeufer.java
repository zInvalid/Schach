package objects;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

public class Laeufer extends Figur
{
    public Laeufer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.LAEUFER);
        setFigurImage(getImage("images/" + figurColor.toString() + "_laeufer.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        return null;
    }
}
