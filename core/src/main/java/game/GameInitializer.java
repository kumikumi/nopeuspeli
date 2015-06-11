package game;

import game.MyGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;

public class GameInitializer 
{
    
    
    public static void main( String[] args )
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.useGL20 = false;
        config.fullscreen = false;
        config.width = MyGame.SCREEN_WIDTH;
        config.height = MyGame.SCREEN_HEIGHT;
        Texture.setEnforcePotImages(false);
        new LwjglApplication(new MyGame(), config);
    }
}
