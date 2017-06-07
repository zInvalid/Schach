package de.acidrain.net.packets;

import de.acidrain.gui.ChessColor;
import de.acidrain.net.GameClient;
import de.acidrain.net.GameServer;
import de.acidrain.game.objects.PlayerMP;

public class Packet03ChessColor extends Packet
{
    private ChessColor color;

    public Packet03ChessColor(byte[] data)
    {
        super(03);
        String[] dataArr = readData(data).split(",");
        switch (dataArr[0])
        {
            case "schwarz":
                color = ChessColor.BLACK;
                break;
            case "weiss":
                color = ChessColor.WHITE;
                break;
            default:
                color = null;
                break;
        }
    }

    public Packet03ChessColor(PlayerMP player)
    {
        super(03);
        this.color = player.getColor();
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
        return ("03" + color.toString().toLowerCase()).getBytes();
    }

    public ChessColor getColor()
    {
        return color;
    }


}
