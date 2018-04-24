package de.acidrain;

import com.esotericsoftware.minlog.Log;
import de.acidrain.game.Game;

public class Main
{
    private static Game game = new Game();

    public static void main(String[] args)
    {
        Log.set(Log.LEVEL_DEBUG);
        game.start();
    }
}
