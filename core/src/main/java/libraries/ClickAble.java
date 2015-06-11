
package libraries;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;


public abstract class ClickAble extends GameObject{
    
    private boolean hover;
    
    public ClickAble(float x, float y, Sprite img) {
        super(x, y, img);
    }
    
    public boolean isMousePointerTouching(float mouseX, float mouseY){
        return getCollisionArea().contains(mouseX, Math.abs(mouseY - Gdx.app.getGraphics().getHeight()));
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }
    
    @Override
    public void move() {
    }
}
