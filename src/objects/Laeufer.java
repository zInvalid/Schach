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
        int x = Constants.selectedLabel.getXCoord() - 1;
        int y = Constants.selectedLabel.getYCoord() - 1;

        while (x >= 0 && y >= 0)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;
            x--;
            y--;
        }


        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord() + 1;

        while (x <= 7 && y <= 7)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x++;
            y++;
        }


        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord() + 1;

        while (x >= 0 && y <= 7)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x--;
            y++;
        }


        x = Constants.selectedLabel.getXCoord() + 1;
        y = Constants.selectedLabel.getYCoord() - 1;

        while (x <= 7 && y >= 0)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);

            if (e.getFigur() != null)
                break;

            x++;
            y--;
        }

        return moveFields;
    }
}
