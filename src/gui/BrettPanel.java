package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Panel fürs Schachbrett
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
                    if(y == 0 || y == 1)
                        figurColor = FigurColor.BLACK;
                    else if(y == 6 || y == 7)
                        figurColor = FigurColor.WHITE;
                    else
                        figurColor = null;

                if ((x % 2 == 0 || y % 2 == 1) && ((y % 2 == 0 || x % 2 == 1)))
                {
                    this.add(new FeldLabel(Color.black, imageForPosition(x, y), figurColor));
                }
                else
                {
                    this.add(new FeldLabel(Color.white, imageForPosition(x, y), figurColor));
                }
            }
        }
    }

    private ImageIcon imageForPosition(int x, int y)
    {
        switch (y)
        {
            case 0:
                return colorFiguren(x, "schwarz");
            case 1:
                return createImageIcon("images/schwarz_bauer.png");
            case 6:
                return createImageIcon("images/weiss_bauer.png");
            case 7:
                return colorFiguren(x, "weiss");
            default:
                return null;
        }
    }

    private ImageIcon colorFiguren(int x, String color)
    {
        switch (x)
        {
            case 0:
            case 7:
                return createImageIcon("images/" + color + "_turm.png");
            case 1:
            case 6:
                return createImageIcon("images/" + color + "_pferd.png");
            case 2:
            case 5:
                return createImageIcon("images/" + color + "_laeufer.png");
            case 3:
                return createImageIcon("images/" + color + "_dame.png");
            case 4:
                return createImageIcon("images/" + color + "_koenig.png");
            default:
                return null;
        }
    }

    /**
     * Erstellt ein Icon mit Hilfe der Bilddatei, die für den angegebenen String gefunden wird.
     *
     * @param pfad der Pfad, der auf eine Bilddatei weisen muss
     * @return ein ImageIcon.
     */
    private ImageIcon createImageIcon(String pfad)
    {
        java.net.URL imgURL = getClass().getResource(pfad);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL, "");
        }
        else
        {
            System.out.println("Konnte " + pfad + " nicht finden.");
            return null;
        }
    }

}
