package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

import java.util.ArrayList;

public class Turm extends Figur
{
    public Turm(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.TURM);
        setFigurImage(getImage("images/" + figurColor.toString() + "_turm.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        ArrayList<FieldLabel> moveFields = new ArrayList<>();
        for (FieldLabel fieldLabel : Constants.fields)
        {
            if ((Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() != fieldLabel.getYCoord())
                    || (Constants.selectedLabel.getXCoord() != fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() == fieldLabel.getYCoord()))
            {
                moveFields.add(fieldLabel);
            }

        }
        return moveFields;

    }
}
