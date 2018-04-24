package de.acidrain.net.packets;

import de.acidrain.gui.ChessColor;

public class PacketMove {
    private int x_prev, y_prev, x_to, y_to;
    private ChessColor color;

    public PacketMove() {
    }

    public PacketMove(ChessColor color, int x_prev, int y_prev, int x_to, int y_to) {
        this.color = color;
        this.x_prev = x_prev;
        this.y_prev = y_prev;
        this.x_to = x_to;
        this.y_to = y_to;
    }

    public int getX_prev() {
        return x_prev;
    }

    public int getY_prev() {
        return y_prev;
    }

    public int getX_to() {
        return x_to;
    }

    public int getY_to() {
        return y_to;
    }

    public ChessColor getColor() {
        return color;
    }
}
