package de.acidrain.net.packets;

import de.acidrain.net.GameClient;
import de.acidrain.net.GameServer;

public abstract class Packet
{
    public byte packetId;

    public Packet(int packetId)
    {
        this.packetId = (byte) packetId;
    }

    public static PacketTypes getPacketType(String id)
    {
        try
        {
            return getPacketType((Integer.parseInt(id)));
        }
        catch (NumberFormatException e)
        {
            return PacketTypes.INVALID;
        }
    }

    public static PacketTypes getPacketType(int id)
    {
        for (PacketTypes p : PacketTypes.values())
        {
            if (p.getId() == id)
                return p;
        }
        return PacketTypes.INVALID;
    }

    public abstract void writeData(GameClient client);

    public abstract void writeData(GameServer server);

    public abstract byte[] getData();

    public String readData(byte[] data)
    {
        String msg = new String(data).trim();
        return msg.substring(2);
    }

    public enum PacketTypes
    {
        INVALID(-1), LOGIN(00), DISCONNECT(01), MOVE(02), CHESSCOLOR(03);

        private int packetId;

        PacketTypes(int packetId)
        {
            this.packetId = packetId;
        }

        public int getId()
        {
            return packetId;
        }
    }
}
