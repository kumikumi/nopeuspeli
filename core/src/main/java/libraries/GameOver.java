package libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver {

    private int score;
    private boolean newHighScore;
    private Sprite gameOver;
    private BitmapFont font;

    public GameOver(int score, boolean newHighScore) {
        this.score = score;
        this.newHighScore = newHighScore;
        this.font = new BitmapFont();
    }

    public void update() {
        
    }

    public void render(SpriteBatch batch) {
    }

}