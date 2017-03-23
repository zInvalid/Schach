package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Bauer extends Figur
{
    public Bauer(FigurColor figurColor)
    {
        super(new ImageIcon("objects/images/" + figurColor.toString() + "_bauer.png"), figurColor);
    }
}
