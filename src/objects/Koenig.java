package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Koenig extends Figur
{
    public Koenig(FigurColor figurColor)
    {
        super(new ImageIcon("objects/images/" + figurColor.toString() + "_koenig.png"), figurColor);
    }
}
