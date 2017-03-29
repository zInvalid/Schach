package objects;

import gui.ChessColor;
import gui.FieldLabel;
import utils.Constants;

import java.util.ArrayList;

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
        for (FieldLabel fieldLabel : Constants.fields)
        {
            if(moved)
            {
                if(getFigurColor().equals(ChessColor.BLACK))
                {
                    if((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord() && Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord())
                        moveFields.add(fieldLabel);
                }
                else
                {
                    if((Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord() && Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord())
                        moveFields.add(fieldLabel);
                }
            }
            else
            {
                if(getFigurColor().equals(ChessColor.BLACK))
                {
                    if(((Constants.selectedLabel.getYCoord() + 1) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() + 2) == fieldLabel.getYCoord()) && Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord())
                        moveFields.add(fieldLabel);
                }
                else
                {
                    if(((Constants.selectedLabel.getYCoord() - 1) == fieldLabel.getYCoord() || (Constants.selectedLabel.getYCoord() - 2) == fieldLabel.getYCoord()) && Constants.selectedLabel.getXCoord() == fieldLabel.getXCoord())
                        moveFields.add(fieldLabel);
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
