package de.acidrain.net;

import de.acidrain.game.Game;
import de.acidrain.gui.FieldLabel;
import de.acidrain.net.packets.*;
import de.acidrain.utils.Constants;

import java.io.IOException;
import java.net.*;

public class GameClient extends Thread
{
    private InetAddress ipAddress;
    private int port;
    private DatagramSocket socket;
    private Game game;

    public GameClient(Game game, String ipAddress, int port)
    {
        this.port = port;
        this.game = game;
        try
        {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        }
        catch (SocketException | UnknownHostException e)
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
            System.out.println("SERVER (" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + ") > " + new String(packet.getData()));
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
                System.out.println("[" + address.getHostAddress() + ":" + port + "] " + ((Packet01Disconnect) packet).getUsername() + " left.");
                break;
            case MOVE:
                packet = new Packet02Move(data);
                handleMove((Packet02Move) packet);
                break;
            case CHESSCOLOR:
                packet = new Packet03ChessColor(data);
                if(game.player1.getColor() == null)
                    game.player1.setColor(((Packet03ChessColor) packet).getColor());

        }
    }

    public void sendData(byte[] data)
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

    private void handleLogin(Packet00Login packet, InetAddress address, int port)
    {
        System.out.println("[" + address.getHostAddress() + ":" + port + "] " + packet.getUsername() + " joined.");
        Game.instance.waiting = false;
    }

    private void handleMove(Packet02Move packet)
    {
        FieldLabel prevFigure = Constants.fieldsArr[packet.getX_prev()][packet.getY_prev()];
        Constants.fieldsArr[packet.getX_to()][packet.getY_to()].setFigur(prevFigure.getFigur());
        Constants.fieldsArr[packet.getX_to()][packet.getY_to()].setIcon(prevFigure.getIcon());
        Constants.fieldsArr[packet.getX_prev()][packet.getY_prev()].setFigur(null);
        Constants.fieldsArr[packet.getX_prev()][packet.getY_prev()].setIcon(null);

        Constants.turn = packet.getColor().getNegation();
        Game.instance.frame.setTitle(Constants.turn.toString());
    }

}
