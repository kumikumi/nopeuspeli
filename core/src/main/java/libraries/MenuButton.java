package libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MenuButton extends ClickAble {

    private String buttonText;
    private final BitmapFont font = new BitmapFont();
    private Sprite defaultImage;
    private Sprite hoverImage;
    private int key;
    private boolean alreadyPressed;

    public MenuButton(float x, float y, Sprite defaultImage, Sprite hoverImage, String buttonText) {
        super(x, y, defaultImage);
        this.defaultImage = defaultImage;
        this.hoverImage = hoverImage;
        this.buttonText = buttonText;
        font.setScale(1.5f);
    }
    
    
    
    @Override
    public void draw() {
        batch.begin();
        if(isHover()){
            batch.draw(this.hoverImage, getX(), getY());
        }
        else{
            batch.draw(this.defaultImage, getX(), getY());
        }
        batch.end();
    }
    public String getButtonText(){
        return this.buttonText;
    }
    
    public void bindKey(int key) {
        this.key = key;
    }
    
    public boolean keyWasJustPressed() {
        if (!Gdx.input.isKeyPressed(key)) {
            alreadyPressed = false;
            return false;
        }
        if (alreadyPressed) {
            return false;
        }
        alreadyPressed = true;
        return true;
    }

    
}
