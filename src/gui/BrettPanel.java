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
        ChessColor figurColor;
        this.setLayout(new GridLayout(8, 8));
        int[][] field = new int[8][8];
        System.out.println(field[0].length);
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                if ((x % 2 == 0 || y % 2 == 1) && ((y % 2 == 0 || x % 2 == 1)))
                {
                    this.add(new FeldLabel(imageForPosition(x, y), ChessColor.BLACK, x ,y));
                }
                else
                {
                    this.add(new FeldLabel(imageForPosition(x, y), ChessColor.WHITE, x ,y));
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
