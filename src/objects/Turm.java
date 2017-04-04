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
        int x, y;
        x = Constants.selectedLabel.getXCoord();
        y = Constants.selectedLabel.getYCoord() - 1;

        while (y >= 0)
        {
            moveFields.add(Constants.fieldsArr[x][y]);
            y--;
        }

        y = Constants.selectedLabel.getYCoord() + 1;

        while (y <= 7)
        {
            moveFields.add(Constants.fieldsArr[x][y]);
            y++;
        }

        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord();

        while (x >= 0)
        {
            moveFields.add(Constants.fieldsArr[x][y]);
            x--;
        }


        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord();

        while (x <= 7)
        {
            moveFields.add(Constants.fieldsArr[x][y]);
            x++;
        }


        /*for (FieldLabel fieldLabel : Constants.fields)
        {
            if ((Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() != fieldLabel.getYCoord())
                    || (Constants.selectedLabel.getXCoord() != fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() == fieldLabel.getYCoord()))
            {
                moveFields.add(fieldLabel);
            }

        }*/
        return moveFields;

    }
}
