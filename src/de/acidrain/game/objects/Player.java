package de.acidrain.game.objects;

import de.acidrain.gui.ChessColor;

/**
 * Spieler Klasse
 */
public class Player
{
    private String username;
    private ChessColor color;

    public Player(String username, ChessColor color)
    {
        this.username = username;
        this.color = color;
    }

    public String getUsername()
    {
        return username;
    }

    public ChessColor getColor()
    {
        return color;
    }

    public void setColor(ChessColor color)
    {
        this.color = color;
    }
}
