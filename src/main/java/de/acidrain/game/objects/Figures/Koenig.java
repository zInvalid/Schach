package de.acidrain.game.objects.Figures;

import de.acidrain.RessourceLoader;
import de.acidrain.gui.ChessColor;
import de.acidrain.gui.FieldLabel;
import de.acidrain.utils.Constants;

import javax.swing.*;
import java.util.ArrayList;

public class Koenig extends Figur
{
    public Koenig(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.KOENIG);
        setFigurImage(new ImageIcon(RessourceLoader.getImage( figurColor.toString().toLowerCase()  + "_koenig.png")));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        ArrayList<FieldLabel> moveFields = new ArrayList<>();
        //------------------------------------------
        int x = Constants.selectedLabel.getXCoord() + 1;
        int y = Constants.selectedLabel.getYCoord();

        if(x <= 7)
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

        if(x >= 0)
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

        //------------------------------------------
        x = Constants.selectedLabel.getXCoord();
        y = Constants.selectedLabel.getYCoord() + 1;

        if(y <= 7)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }

        //------------------------------------------
        y = Constants.selectedLabel.getYCoord() - 1;

        if(y >= 0)
        {
            FieldLabel e = Constants.fieldsArr[x][y];
            if(e.getFigur() == null  || !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                moveFields.add(e);
        }
        return moveFields;
    }
}
