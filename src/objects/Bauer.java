package objects;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Bauer extends Figur
{
    public Bauer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.BAUER);
        setFigurImage(getImage("images/" + figurColor.toString() + "_bauer.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        return null;
    }
}
