package de.acidrain.net.packets;

import de.acidrain.gui.ChessColor;

public class PacketConnect {
    private ChessColor color;
    private String username;

    public PacketConnect() {
    }

    public PacketConnect(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChessColor getColor() {
        return color;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }

}
