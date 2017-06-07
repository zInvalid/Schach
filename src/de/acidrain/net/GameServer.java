package de.acidrain.net;

import de.acidrain.game.Game;
import de.acidrain.net.packets.*;
import de.acidrain.game.objects.PlayerMP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class GameServer extends Thread
{
    private DatagramSocket socket;
    private List<PlayerMP> connectedPlayers = new ArrayList<>();
    private Game game;

    public GameServer(Game game, int port)
    {
        this.game = game;
        try
        {
            this.socket = new DatagramSocket(port);
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try
            {
                socket.receive(packet);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.println("CLIENT (" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + ") > " + new String(packet.getData()));
            this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
        }
    }

    private void parsePacket(byte[] data, InetAddress address, int port)
    {
        String msg = new String(data).trim();
        Packet.PacketTypes packetType = Packet.getPacketType(msg.substring(0, 2));
        Packet packet;
        switch (packetType)
        {
            default:
            case INVALID:
                break;
            case LOGIN:
                packet = new Packet00Login(data);
                handleLogin((Packet00Login) packet, address, port);
                break;
            case DISCONNECT:
                packet = new Packet01Disconnect(data);
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet01Disconnect) packet).getUsername() + " disconnected.");
                this.removeConnection((Packet01Disconnect) packet);
                break;
            case MOVE:
                packet = new Packet02Move(data);
                handleMove((Packet02Move) packet);
        }
    }

    public void addConnection(PlayerMP player, Packet00Login packet)
    {
        boolean alreadyConnected = false;
        for (PlayerMP p : this.connectedPlayers)
        {
            if (player.getUsername().equalsIgnoreCase(p.getUsername()))
            {
                if (p.ipAddress == null)
                    p.ipAddress = player.ipAddress;

                if (p.port == -1)
                    p.port = player.port;

                alreadyConnected = true;
            }
            else
            {
                sendData(packet.getData(), p.ipAddress, p.port);
                Packet00Login packet2 = new Packet00Login(p);
                sendData(packet2.getData(), player.ipAddress, player.port);
            }
        }
        if (!alreadyConnected)
        {
            this.connectedPlayers.add(player);
        }
    }

    public void removeConnection(Packet01Disconnect packet)
    {
        this.connectedPlayers.remove(getPlayerMPIndex(packet.getUsername()));
        packet.writeData(this);
    }

    public PlayerMP getPlayerMP(String username)
    {
        for (PlayerMP player : this.connectedPlayers)
        {
            if (player.getUsername().equals(username))
                return player;
        }
        return null;
    }

    public int getPlayerMPIndex(String username)
    {
        int index = 0;
        for (PlayerMP player : this.connectedPlayers)
        {
            if (player.getUsername().equals(username))
                break;
            index++;
        }
        return index;
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port)
    {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try
        {
            socket.send(packet);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void sendDataToAllClients(byte[] data)
    {
        for (PlayerMP p : connectedPlayers)
        {
            sendData(data, p.ipAddress, p.port);
        }
    }

    private void handleLogin(Packet00Login packet, InetAddress address, int port)
    {
        System.out.println("[" + address.getHostAddress() + ":" + port + "] " + packet.getUsername() + " connected.");
        PlayerMP player = new PlayerMP(packet.getUsername(), game.player1.getColor().getNegation(), address, port);
        sendData(new Packet03ChessColor(player).getData(), address, port);
        this.addConnection(player, packet);
    }

    private void handleMove(Packet02Move packet)
    {
        for (PlayerMP p : connectedPlayers)
        {
            if(!p.getUsername().equalsIgnoreCase(packet.getUsername()))
                sendData(packet.getData(), p.ipAddress, p.port);
        }
    }
}
