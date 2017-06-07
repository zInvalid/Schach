package de.acidrain.game.objects.Figures;

import de.acidrain.gui.ChessColor;
import de.acidrain.gui.FieldLabel;

import javax.swing.*;
import java.util.ArrayList;

import static de.acidrain.utils.Constants.selectedLabel;

public abstract class Figur
{
    private ImageIcon figurImage;
    private final ChessColor figurColor;
    private final FigurType type;

    Figur(ImageIcon figurImage, ChessColor figurColor, FigurType type)
    {
        this.figurImage = figurImage;
        this.figurColor = figurColor;
        this.type = type;
    }

    public ImageIcon getFigurImage()
    {
        return figurImage;
    }

    void setFigurImage(ImageIcon figurImage)
    {
        this.figurImage = figurImage;
    }

    public ChessColor getFigurColor()
    {
        return figurColor;
    }

    public FigurType getType()
    {
        return type;
    }

    public abstract ArrayList<FieldLabel> moveAblesFields();

    public void add(ArrayList<FieldLabel> arrayList, FieldLabel label)
    {
        if (label.getFigur() == null || !label.getFigur().getFigurColor().equals(selectedLabel.getFigur().getFigurColor()))
            arrayList.add(label);
    }
}
