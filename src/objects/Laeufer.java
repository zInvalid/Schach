package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

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
        ArrayList<FieldLabel> moveFields = new ArrayList<>();
        int x = Constants.selectedLabel.getXCoord();
        int y = Constants.selectedLabel.getYCoord();
        for (FieldLabel fieldLabel : Constants.fields)
        {
            if (((x + 1) == fieldLabel.getXCoord()) && ((y + 1) == fieldLabel.getYCoord()))
            {
                moveFields.add(fieldLabel);
            }
        }
        return moveFields;
    }
}
