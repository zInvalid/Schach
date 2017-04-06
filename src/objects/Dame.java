package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

import java.util.ArrayList;

import static utils.Constants.fieldsArr;
import static utils.Constants.selectedLabel;

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
            /*if ((Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() != fieldLabel.getYCoord())
                    || (Constants.selectedLabel.getXCoord() != fieldLabel.getXCoord() && Constants.selectedLabel.getYCoord() == fieldLabel.getYCoord()))
            {
                moveFields.add(fieldLabel);
            }*/

        //------------------------------------------
        int x = selectedLabel.getXCoord();
        int y = selectedLabel.getYCoord() - 1;

        while (y >= 0)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            y--;
        }

        //------------------------------------------
        y = selectedLabel.getYCoord() + 1;
        while (y <= 7)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            y++;
        }

        //------------------------------------------
        x = selectedLabel.getXCoord() - 1;
        y = selectedLabel.getYCoord();

        while (x >= 0)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x--;
        }

        //------------------------------------------
        x = selectedLabel.getXCoord() + 1;
        y = selectedLabel.getYCoord();

        while (x <= 7)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x++;
        }

        //------------------------------------------
        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord() - 1;

        while (x >= 0 && y >= 0)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x--;
            y--;
        }

        //------------------------------------------
        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord() + 1;

        while (x <= 7 && y <= 7)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;
            x++;
            y++;
        }

        //------------------------------------------
        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord() + 1;

        while (x >= 0 && y <= 7)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x--;
            y++;
        }

        //------------------------------------------
        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord() - 1;

        while (x <= 7 && y >= 0)
        {
            FieldLabel e = fieldsArr[x][y];
            if (e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x++;
            y--;
        }

        return moveFields;
    }

}
