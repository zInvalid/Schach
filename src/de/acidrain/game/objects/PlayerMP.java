package de.acidrain.game.objects;

import de.acidrain.gui.ChessColor;

import java.net.InetAddress;

/**
 * Multiplayer Spieler Klasse
 */
public class PlayerMP extends Player
{
    public InetAddress ipAddress;
    public int port;

    public PlayerMP(String username, ChessColor color, InetAddress ipAddress, int port)
    {
        super(username, color);
        this.ipAddress = ipAddress;
        this.port = port;
    }
}
