package de.acidrain;

import java.awt.*;

public class RessourceLoader
{
    static RessourceLoader instance = new RessourceLoader();

    public static Image getImage(String file)
    {
        return Toolkit.getDefaultToolkit().getImage(instance.getClass().getClassLoader().getResource("img/" + file));
    }
}
