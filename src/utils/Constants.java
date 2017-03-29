package utils;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;

/**
 * public constants
 */
public class Constants
{
    /**
     * ArrayList which contains all fields
     */
    public static final ArrayList<FieldLabel> fields = new ArrayList<>();

    /**
     * Cache label, which gets first clicked
     */
    public static FieldLabel selectedLabel = null;

    /**
     * Players turn
     */
    public static ChessColor turn = null;
}
