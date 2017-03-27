package utils;

import gui.ChessColor;
import gui.FieldLabel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Invalid on 27.03.2017.
 */
public class Constants
{
    public static ArrayList<FieldLabel> fields = new ArrayList<>();

    /**
     * Cache label, which gets first clicked
     */
    public static FieldLabel selectedLabel = null;


    public static List<FieldLabel> allowedLabels = new CopyOnWriteArrayList<>();

    /**
     * Players turn
     */
    public static ChessColor turn = null;
}
