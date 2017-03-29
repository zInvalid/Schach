package objects;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

public class Bauer extends Figur
{
    private boolean moved;

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
