package objects;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

public class Koenig extends Figur
{
    public Koenig(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.KOENIG);
        setFigurImage(getImage("images/" + figurColor.toString() + "_koenig.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        return null;
    }
}
