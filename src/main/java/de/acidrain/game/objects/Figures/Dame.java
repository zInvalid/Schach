package de.acidrain.game.objects.Figures;

import de.acidrain.RessourceLoader;
import de.acidrain.gui.ChessColor;
import de.acidrain.gui.FieldLabel;
import de.acidrain.utils.Constants;

import javax.swing.*;
import java.util.ArrayList;

import static de.acidrain.utils.Constants.fieldsArr;
import static de.acidrain.utils.Constants.selectedLabel;

public class Dame extends Figur
{
    public Dame(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.DAME);
        setFigurImage(new ImageIcon(RessourceLoader.getImage(figurColor.toString().toLowerCase()  + "_dame.png")));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        ArrayList<FieldLabel> moveFields = new ArrayList<>();

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
