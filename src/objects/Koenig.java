package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

import java.util.ArrayList;

public class Koenig extends Figur
{
    public Koenig(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.KOENIG);
        setFigurImage(getImage("images/" + figurColor.toString() + "_koenig.png"));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        ArrayList<FieldLabel> moveFields = new ArrayList<>();
        //------------------------------------------
        int x = Constants.selectedLabel.getXCoord() + 1;
        int y = Constants.selectedLabel.getYCoord();

        if(x <= 7 && y <= 7)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }

        //------------------------------------------
        y = Constants.selectedLabel.getYCoord() - 1;

        if(x <= 7 && y >= 0)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }

        //------------------------------------------
        y = Constants.selectedLabel.getYCoord() + 1;

        if(x <= 7 && y <= 7)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }

        //------------------------------------------
        x = Constants.selectedLabel.getXCoord() - 1;
        y = Constants.selectedLabel.getYCoord();

        if(x >= 0 && y >= 0)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }

        //------------------------------------------
        y = Constants.selectedLabel.getYCoord() - 1;

        if(x >= 0 && y >= 0)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }

        //------------------------------------------
        y = Constants.selectedLabel.getYCoord() + 1;

        if(x >= 0 && y <= 7)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }
        /*for (FieldLabel fieldLabel : Constants.fields)
        {
            if (((Constants.selectedLabel.getXCoord() + 1) == fieldLabel.getXCoord() || (Constants.selectedLabel.getXCoord() - 1) == fieldLabel.getXCoord()) && (Constants.selectedLabel.getYCoord()) == fieldLabel.getYCoord()
                    || ((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord()) && (Constants.selectedLabel.getXCoord()) == fieldLabel.getXCoord()

                    || (((Constants.selectedLabel.getXCoord() + 1) == fieldLabel.getXCoord()) && ((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord()))
                    || (((Constants.selectedLabel.getXCoord() - 1) == fieldLabel.getXCoord()) && ((Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord()))
                    || (((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord()) && ((Constants.selectedLabel.getXCoord() - 1) == fieldLabel.getXCoord()))
                    || (((Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord()) && ((Constants.selectedLabel.getXCoord() + 1) == fieldLabel.getXCoord())))
            {
                moveFields.add(fieldLabel);
            }

        }*/
        return moveFields;
    }
}
