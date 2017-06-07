package de.acidrain.game;

import de.acidrain.gui.ChessFrame;
import de.acidrain.gui.ChessColor;
import de.acidrain.net.GameClient;
import de.acidrain.net.GameServer;
import de.acidrain.net.packets.Packet00Login;
import de.acidrain.game.objects.Player;
import de.acidrain.game.objects.PlayerMP;
import de.acidrain.utils.Constants;

import javax.swing.*;

/**
 * Test Klasse GUI
 */
public class Game
{

    private static final String NAME = "Schach";
    public static Game instance;
    public JFrame frame;

    public Player player1;
    public GameClient client;
    public GameServer server;

    private String ADDRESS = "127.0.0.1";
    private int PORT = 1330;
    private Thread thread;

    public boolean waiting = true;

    public synchronized void start()
    {
        thread = new Thread(NAME + "_main");
        thread.start();
        init();
    }

    private void init()
    {
        instance = this;

        Constants.multiplayer = JOptionPane.showConfirmDialog(null, "Start multiplayer?") == JOptionPane.YES_OPTION;

        if (Constants.multiplayer)
        {
            final JTextField username = new JTextField();

            final JCheckBox hostgame = new JCheckBox("Host game?");
            hostgame.setSelected(true);

            final JTextField address = new JTextField();
            address.setText("127.0.0.1");
            address.setEditable(false);

            final JTextField port = new JTextField();
            port.setText("1330");

            final JRadioButton radioWhite = new JRadioButton("Weiß");
            final JRadioButton radioBlack = new JRadioButton("Schwarz");

            final ButtonGroup group = new ButtonGroup();
            group.add(radioWhite);
            group.add(radioBlack);

            hostgame.addActionListener(e ->
            {
                JCheckBox cb = (JCheckBox) e.getSource();
                if (cb.isSelected())
                {
                    address.setText("127.0.0.1");
                    address.setEditable(false);
                    radioBlack.setVisible(true);
                    radioWhite.setVisible(true);
                }
                else
                {
                    address.setEditable(true);
                    radioBlack.setVisible(false);
                    radioWhite.setVisible(false);
                    radioBlack.repaint();
                }
            });

            final JComponent[] inputs = new JComponent[]{
                    hostgame,
                    new JLabel("IP-Adresse:"),
                    address,
                    new JLabel("Port:"),
                    port,
                    new JLabel("Username:"),
                    username,
                    radioWhite,
                    radioBlack
            };

            if (JOptionPane.showConfirmDialog(null, inputs, "Game Settings", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
            {
                if (!address.getText().isEmpty())
                    this.ADDRESS = address.getText();

                if (!port.getText().isEmpty())
                {
                    try
                    {
                        this.PORT = Integer.parseInt(port.getText());
                    }
                    catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "Only Numbers!°");
                    }
                }

                if (hostgame.isSelected())
                {
                    server = new GameServer(this, this.PORT);
                    server.start();

                    client = new GameClient(this, this.ADDRESS, this.PORT);
                    client.start();

                    if (radioWhite.isSelected())
                        player1 = new PlayerMP(username.getText(), ChessColor.WHITE, null, -1);
                    if (radioBlack.isSelected())
                        player1 = new PlayerMP(username.getText(), ChessColor.BLACK, null, -1);

                    Packet00Login loginPacket = new Packet00Login((PlayerMP) player1);

                    if (server != null)
                        server.addConnection((PlayerMP) player1, loginPacket);

                    loginPacket.writeData(client);

                    boolean msg = false;
                    while (waiting)
                    {
                        if(!msg)
                        {
                            msg = true;
                            if(JOptionPane.showConfirmDialog(null, "Listening on Port: " + this.PORT, "Waiting for player", JOptionPane.OK_CANCEL_OPTION) == 2)
                                System.exit(0);
                            else
                                msg = false;
                        }

                    }
                }
                else
                {
                    client = new GameClient(this, this.ADDRESS, this.PORT);
                    client.start();

                    player1 = new PlayerMP(username.getText(), null, null, -1);
                    Packet00Login loginPacket = new Packet00Login((PlayerMP) player1);
                    loginPacket.writeData(client);
                }
            }
            else
            {
                System.exit(0);
            }
        }
        else
        {
            //TODO Local Game
        }

        frame = new ChessFrame();
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
