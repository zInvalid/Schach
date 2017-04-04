package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

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
        ArrayList<FieldLabel> moveFields = new ArrayList<>();

        int x, y;
        for (FieldLabel fieldLabel : Constants.fields)
        {
            if ((Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() != fieldLabel.getYCoord())
                    || (Constants.selectedLabel.getXCoord() != fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() == fieldLabel.getYCoord()))
            {
                moveFields.add(fieldLabel);
            }

            x = Constants.selectedLabel.getXCoord() - 1;
            y = Constants.selectedLabel.getYCoord() - 1;

            while (x >= 0 && y >= 0)
            {
                if (fieldLabel.getXCoord() == x && fieldLabel.getYCoord() == y)
                    moveFields.add(fieldLabel);
                x--;
                y--;
            }


            x = Constants.selectedLabel.getXCoord() + 1;
            y = Constants.selectedLabel.getYCoord() + 1;

            while (x <= 8 && y <= 8)
            {
                if (fieldLabel.getXCoord() == x && fieldLabel.getYCoord() == y)
                    moveFields.add(fieldLabel);
                x++;
                y++;
            }


            x = Constants.selectedLabel.getXCoord() - 1;
            y = Constants.selectedLabel.getYCoord() + 1;

            while (x >= 0 && y <= 8)
            {
                if (fieldLabel.getXCoord() == x && fieldLabel.getYCoord() == y)
                    moveFields.add(fieldLabel);
                x--;
                y++;
            }


            x = Constants.selectedLabel.getXCoord() + 1;
            y = Constants.selectedLabel.getYCoord() - 1;

            while (x <= 8 && y >= 0)
            {
                if (fieldLabel.getXCoord() == x && fieldLabel.getYCoord() == y)
                    moveFields.add(fieldLabel);
                x++;
                y--;
            }

        }
        return moveFields;
    }

}
