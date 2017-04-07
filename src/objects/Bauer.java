package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

import java.util.ArrayList;

import static utils.Constants.selectedLabel;

public class Bauer extends Figur
{
    private boolean moved = false;

    public Bauer(ChessColor figurColor)
    {
        super(null, figurColor, FigurType.BAUER);
        setFigurImage(getImage("images/" + figurColor.toString() + "_bauer.png"));
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
            /*if (getFigurColor().equals(ChessColor.BLACK))
            {
                if (((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() + 2) == fieldLabel.getYCoord()) && Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord())
                    moveFields.add(fieldLabel);
            }
            else
            {
                if (((Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() - 2) == fieldLabel.getYCoord()) && Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord())
                    moveFields.add(fieldLabel);
            }*/
        }

        return moveFields;
    }

    public void setMoved(boolean moved)
    {
        this.moved = moved;
    }
}
