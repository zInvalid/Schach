package gui;

import objects.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for {@link BrettFrame Frame]
 */
class BrettPanel extends JPanel
{


    BrettPanel()
    {
        FigurColor figurColor;
        this.setLayout(new GridLayout(8, 8));
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                if ((x % 2 == 0 || y % 2 == 1) && ((y % 2 == 0 || x % 2 == 1)))
                {
                    this.add(new FeldLabel(Color.black, imageForPosition(x, y)));
                }
                else
                {
                    this.add(new FeldLabel(Color.white, imageForPosition(x, y)));
                }
            }
        }
    }

    private Figur imageForPosition(int x, int y)
    {
        switch (y)
        {
            case 0:
                return colorFiguren(x, FigurColor.BLACK);
            case 1:
                return new Bauer(FigurColor.BLACK);
            case 6:
                return new Bauer(FigurColor.WHITE);
            case 7:
                return colorFiguren(x, FigurColor.WHITE);
            default:
                return null;
        }
    }

    private Figur colorFiguren(int x, FigurColor color)
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
