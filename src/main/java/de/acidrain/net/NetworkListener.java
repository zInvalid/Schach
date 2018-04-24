package de.acidrain.net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import de.acidrain.game.Game;
import de.acidrain.game.objects.Player;
import de.acidrain.gui.ChessColor;
import de.acidrain.gui.FieldLabel;
import de.acidrain.net.packets.PacketConnect;
import de.acidrain.net.packets.PacketForceShutdown;
import de.acidrain.net.packets.PacketJoin;
import de.acidrain.net.packets.PacketMove;
import de.acidrain.utils.Constants;

public class NetworkListener extends Listener {

    @Override
    public void received(Connection connection, Object o) {
        if(o instanceof PacketMove)
        {
            PacketMove packet = (PacketMove) o;
            handleMove(packet);
        }
        else if(o instanceof PacketConnect) {
            PacketConnect packet = (PacketConnect) o;
            Game.instance.player = new Player(packet.getUsername(), packet.getColor());
            if(Game.instance.player.getColor().equals(ChessColor.BLACK))
                Game.instance.waiting = false;
        }
        else if(o instanceof PacketJoin)
        {
            Game.instance.waiting = false;
        }
        else if(o instanceof PacketForceShutdown)
        {
            System.exit(0);
        }
    }

    private void handleMove(PacketMove packet)
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
