package objects;

import gui.FigurColor;

import javax.swing.*;

/**
 * Created by e6_grumptmann on 23.03.2017.
 */
public class Turm extends Figur
{
    public Turm(FigurColor figurColor)
    {
        super(new ImageIcon("objects/images/" + figurColor.toString() + "_turm.png"), figurColor);
    }

}
