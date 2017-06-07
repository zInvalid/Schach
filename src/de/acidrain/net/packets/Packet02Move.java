package de.acidrain.net.packets;

import de.acidrain.gui.ChessColor;
import de.acidrain.net.GameClient;
import de.acidrain.net.GameServer;

public class Packet02Move extends Packet
{
    private String username;
    private ChessColor color;
    private int x_prev, y_prev, x_to, y_to;

    public Packet02Move(byte[] data)
    {
        super(02);
        String[] dataArr = readData(data).split(",");
        this.username = dataArr[0];
        switch (dataArr[1])
        {
            case "schwarz":
                color = ChessColor.BLACK;
                break;
            case "weiss":
                color = ChessColor.WHITE;
                break;
            default:
        }
        this.x_prev = Integer.parseInt(dataArr[2]);
        this.y_prev = Integer.parseInt(dataArr[3]);
        this.x_to = Integer.parseInt(dataArr[4]);
        this.y_to = Integer.parseInt(dataArr[5]);
    }

    public Packet02Move(String username, ChessColor color, int x_prev, int y_prev, int x_to, int y_to)
    {
        super(02);
        this.username = username;
        this.color = color;
        this.x_prev = x_prev;
        this.y_prev = y_prev;
        this.x_to = x_to;
        this.y_to = y_to;
    }

    @Override
    public void writeData(GameClient client)
    {
        client.sendData(getData());
    }

    @Override
    public void writeData(GameServer server)
    {
        server.sendDataToAllClients(getData());
    }

    @Override
    public byte[] getData()
    {
        return ("02" + username + "," + color.toString().toLowerCase() + "," + x_prev + "," + y_prev + "," + x_to + "," + y_to).getBytes();
    }

    public int getX_prev()
    {
        return x_prev;
    }

    public int getY_prev()
    {
        return y_prev;
    }

    public int getX_to()
    {
        return x_to;
    }

    public int getY_to()
    {
        return y_to;
    }

    public ChessColor getColor()
    {
        return color;
    }

    public String getUsername()
    {
        return username;
    }
}
