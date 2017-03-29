package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

import java.util.ArrayList;

public class Springer extends Figur
{
    public Springer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.SPRINGER);
        setFigurImage(getImage("images/" + figurColor.toString() + "_pferd.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        return null;
    }
}
