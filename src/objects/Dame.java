package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by Invalid on 23.03.2017.
 */
public class Dame extends Figur
{
    public Dame(FigurColor figurColor)
    {
        super(new ImageIcon("objects/images/" + figurColor.toString() + "_dame.png"), figurColor);
    }
}
