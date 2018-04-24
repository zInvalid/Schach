package de.acidrain.utils;

import de.acidrain.gui.ChessColor;
import de.acidrain.gui.FieldLabel;

import java.util.ArrayList;

/**
 * public constants
 */
public class Constants
{
    /**
     * ArrayList which contains all fields
     */
    public static final FieldLabel[][] fieldsArr = new FieldLabel[8][8];

    public static boolean multiplayer = false;
    /**
     * Cache label, which gets first clicked
     */
    public static FieldLabel selectedLabel = null;

    /**
     * Players turn
     */
    public static ChessColor turn = ChessColor.WHITE;
}
