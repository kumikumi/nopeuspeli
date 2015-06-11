package libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextObject extends GameObject {

    private String txt;
    private float scale;
    private Color color;
    private SpriteBatch batch;
    private BitmapFont font;

    public TextObject(String txt, float x, float y) {
        super(x, y, null);
        this.scale = 1;
        this.txt = txt;
        this.color = Color.BLACK;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
    }

    public String getTxt() {
        return this.txt;
    }

    public void setText(String txt) {
        this.txt = txt;
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public void draw() {
        batch.begin();
        font.draw(batch, txt, getX(), getY());
        batch.end();
    }
}
