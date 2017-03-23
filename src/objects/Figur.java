package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by e6_grumptmann on 23.03.2017.
 */
public class Figur
{
    private ImageIcon figurImage;
    private FigurColor figurColor;

    public Figur(ImageIcon figurImage, FigurColor figurColor)
    {
        this.figurImage = figurImage;
        this.figurColor = figurColor;
    }

    public ImageIcon getFigurImage()
    {
        return figurImage;
    }
}
