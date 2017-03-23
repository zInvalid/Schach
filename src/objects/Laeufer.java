package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Laeufer extends Figur
{
    public Laeufer(FigurColor figurColor)
    {
        super(new ImageIcon("objects/images/" + figurColor.toString() + "_laeufer.png"), figurColor);
    }
}
