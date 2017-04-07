package objects;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

import static utils.Constants.*;

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
        int x = selectedLabel.getXCoord();
        int y = selectedLabel.getYCoord() - 1;

        while (y >= 0)
        {
            FieldLabel e = fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            y--;
        }

        y = selectedLabel.getYCoord() + 1;

        while (y <= 7)
        {
            FieldLabel e = fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            y++;
        }

        x = selectedLabel.getXCoord() - 1;
        y = selectedLabel.getYCoord();

        while (x >= 0)
        {
            FieldLabel e = fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x--;
        }


        x = selectedLabel.getXCoord() + 1;
        y = selectedLabel.getYCoord();

        while (x <= 7)
        {
            FieldLabel e = fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

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
