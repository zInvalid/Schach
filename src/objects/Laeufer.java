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
        int x, y;
        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord() - 1;

        while (x >= 0 && y >= 0)
        {
            moveFields.add(Constants.fieldsArr[x][y]);
            x--;
            y--;
        }


        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord() + 1;

        while (x <= 7 && y <= 7)
        {
            moveFields.add(Constants.fieldsArr[x][y]);

            x++;
            y++;
        }


        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord() + 1;

        while (x >= 0 && y <= 7)
        {
            moveFields.add(Constants.fieldsArr[x][y]);

            x--;
            y++;
        }


        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord() - 1;

        while (x <= 7 && y >= 0)
        {
            moveFields.add(Constants.fieldsArr[x][y]);

            x++;
            y--;
        }

        return moveFields;
    }
}
