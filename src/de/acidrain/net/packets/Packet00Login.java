package de.acidrain.net.packets;

import de.acidrain.net.GameClient;
import de.acidrain.net.GameServer;
import de.acidrain.game.objects.PlayerMP;

public class Packet00Login extends Packet
{

    private String username;

    public Packet00Login(byte[] data)
    {
        super(00);
        String[] dataArr = readData(data).split(",");
        this.username = dataArr[0];

    }

    public Packet00Login(PlayerMP player)
    {
        super(00);
        this.username = player.getUsername();
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
        return ("00" + this.username).getBytes();
    }

    public String getUsername()
    {
        return username;
    }

}