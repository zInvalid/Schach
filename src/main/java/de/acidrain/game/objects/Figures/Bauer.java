package de.acidrain.game.objects.Figures;

import de.acidrain.RessourceLoader;
import de.acidrain.gui.ChessColor;
import de.acidrain.gui.FieldLabel;
import de.acidrain.utils.Constants;

import javax.swing.*;
import java.util.ArrayList;

import static de.acidrain.utils.Constants.selectedLabel;

public class Bauer extends Figur
{
    private boolean moved = false;

    public Bauer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.BAUER);
        setFigurImage(new ImageIcon(RessourceLoader.getImage(figurColor.toString().toLowerCase() + "_bauer.png")));
    }

    @Override
    public ArrayList<FieldLabel> moveAblesFields()
    {
        ArrayList<FieldLabel> moveFields = new ArrayList<>();
        int x = selectedLabel.getXCoord();
        int y;

        if (moved)
        {
            if (getFigurColor().equals(ChessColor.BLACK))
            {
                y = selectedLabel.getYCoord() + 1;
                if (y <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if (e.getFigur() == null)
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() - 1;
                if(x >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() + 1;
                if(x <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }
            }
            else
            {
                y = selectedLabel.getYCoord() - 1;
                if (y >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if (e.getFigur() == null)
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() - 1;
                if(x >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() + 1;
                if(x <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }
            }
        }
        else
        {
            if (getFigurColor().equals(ChessColor.BLACK))
            {
                y = selectedLabel.getYCoord() + 1;
                if (y <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if (e.getFigur() == null)
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() - 1;
                if(x >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() + 1;
                if(x <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord();
                y = selectedLabel.getYCoord() + 2;
                if (y <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if (e.getFigur() == null && Constants.fieldsArr[x][y - 1].getFigur() == null)
                        moveFields.add(e);
                }

            }
            else
            {
                y = selectedLabel.getYCoord() - 1;
                if (y >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if (e.getFigur() == null)
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() - 1;
                if(x >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord() + 1;
                if(x <= 7)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if(e.getFigur() != null && !e.getFigur().getFigurColor().equals(Constants.selectedLabel.getFigur().getFigurColor()))
                        moveFields.add(e);
                }

                x = selectedLabel.getXCoord();
                y = selectedLabel.getYCoord() - 2;
                if (y >= 0)
                {
                    FieldLabel e = Constants.fieldsArr[x][y];
                    if (e.getFigur() == null && Constants.fieldsArr[x][y + 1].getFigur() == null)
                        moveFields.add(e);
                }
            }
        }

        return moveFields;
    }

    public void setMoved(boolean moved)
    {
        this.moved = moved;
    }
}
