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
        ArrayList<FieldLabel> moveFields = new ArrayList<>();
        for (FieldLabel fieldLabel : Constants.fields)
        {
            if ((((Constants.selectedLabel.getXCoord() - 2) == fieldLabel.getXCoord() || (Constants.selectedLabel.getXCoord() + 2) == fieldLabel.getXCoord()) && ((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord()))
                    || (((Constants.selectedLabel.getYCoord() - 2) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() + 2) == fieldLabel.getYCoord()) && ((Constants.selectedLabel.getXCoord() + 1) == fieldLabel.getXCoord() || (Constants.selectedLabel.getXCoord() - 1) == fieldLabel.getXCoord())))
            {
                moveFields.add(fieldLabel);
            }
        }
        return moveFields;
    }
}
