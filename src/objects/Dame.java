package objects;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

public class Dame extends Figur
{
    public Dame(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.DAME);
        setFigurImage(getImage("images/" + figurColor.toString() + "_dame.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        return null;
    }

}
