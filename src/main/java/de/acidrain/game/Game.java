package de.acidrain.game;

import com.esotericsoftware.kryonet.Client;
import de.acidrain.gui.ChessColor;
import de.acidrain.gui.ChessFrame;
import de.acidrain.net.NetworkListener;
import de.acidrain.game.objects.Player;
import de.acidrain.net.packets.PacketConnect;
import de.acidrain.net.packets.PacketForceShutdown;
import de.acidrain.net.packets.PacketJoin;
import de.acidrain.net.packets.PacketMove;
import de.acidrain.utils.Constants;

import javax.swing.*;
import java.io.IOException;

/**
 * Test Klasse GUI
 */
public class Game {

    private static final String NAME = "Schach";
    public static Game instance;
    public JFrame frame;

    public Player player;
    public Client client;

    private String ADDRESS = "127.0.0.1";
    private int PORT = 54555;

    public static final Object monitor = new Object();
    public boolean waiting = true;

    public synchronized void start() {
        gameThread.start();
    }

    private Thread gameThread = new Thread(() -> {
        instance = this;
        Constants.multiplayer = JOptionPane.showConfirmDialog(null, "Start multiplayer?") == JOptionPane.YES_OPTION;

        if (Constants.multiplayer) {
            final JTextField username = new JTextField();

            final JTextField address = new JTextField();
            address.setText(ADDRESS);

            final JTextField port = new JTextField();
            port.setText(String.valueOf(this.PORT));

            final JComponent[] inputs = new JComponent[]{
                    new JLabel("Server IP-Adresse:"),
                    address,
                    new JLabel("Port:"),
                    port,
                    new JLabel("Username:"),
                    username,
            };

            if (JOptionPane.showConfirmDialog(null, inputs, "Game Settings", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                if (!address.getText().isEmpty())
                    this.ADDRESS = address.getText();

                if (!port.getText().isEmpty()) {
                    try {
                        this.PORT = Integer.parseInt(port.getText());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Only Numbers!°");
                    }
                }

                client = new Client();
                client.getKryo().register(PacketConnect.class);
                client.getKryo().register(PacketMove.class);
                client.getKryo().register(ChessColor.class);
                client.getKryo().register(PacketJoin.class);
                client.getKryo().register(PacketForceShutdown.class);
                client.addListener(new NetworkListener());

                client.start();
                try {
                    client.connect(5000, this.ADDRESS, this.PORT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                client.sendTCP(new PacketConnect(username.getText()));

            } else {
                System.exit(0);
            }
        } else {
            //TODO Local Game
        }

        frame = new ChessFrame();
    }, NAME + "_main");

    public synchronized void stop() {
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
