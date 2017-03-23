package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Springer extends Figur
{
    public Springer(FigurColor figurColor)
    {
        super(new ImageIcon("objects/images/" + figurColor.toString() + "_pferd.png"), figurColor);
    }
}
