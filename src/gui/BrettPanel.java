package gui;

import objects.*;
import utils.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for {@link BrettFrame Frame]
 */
class BrettPanel extends JPanel
{

    BrettPanel()
    {
        this.setLayout(new GridLayout(8, 8));
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                FieldLabel fieldLabel;
                if ((x % 2 == 0 || y % 2 == 1) && ((y % 2 == 0 || x % 2 == 1)))
                {
                    fieldLabel = new FieldLabel(imageForPosition(x, y), ChessColor.BLACK, x, y);
                    this.add(fieldLabel);
                    Constants.fields.add(fieldLabel);
                }
                else
                {
                    fieldLabel = new FieldLabel(imageForPosition(x, y), ChessColor.WHITE, x, y);
                    this.add(fieldLabel);
                    Constants.fields.add(fieldLabel);
                }
            }
        }
    }

    private Figur imageForPosition(int x, int y)
    {
        switch (y)
        {
            case 0:
                return colorFiguren(x, ChessColor.BLACK);
            case 1:
                return new Bauer(ChessColor.BLACK);
            case 6:
                return new Bauer(ChessColor.WHITE);
            case 7:
                return colorFiguren(x, ChessColor.WHITE);
            default:
                return null;
        }
    }

    private Figur colorFiguren(int x, ChessColor color)
    {
        switch (x)
        {
            case 0:
            case 7:
                return new Turm(color);
            case 1:
            case 6:
                return new Springer(color);
            case 2:
            case 5:
                return new Laeufer(color);
            case 3:
                return new Dame(color);
            case 4:
                return new Koenig(color);
            default:
                return null;
        }
    }

}
