package libraries;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject implements Movable {

    private float x, y;
    protected float angle;
    private Sprite img;
    protected SpriteBatch batch = new SpriteBatch();

    public GameObject(float x, float y, Sprite img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public void draw() {
        batch.begin();
        if (this.angle == 0) {
            batch.draw(getImage(), getX(), getY());
        } else {
            batch.draw(this.img, this.x, this.y, this.img.getWidth() / 2, this.img.getHeight() / 2, this.img.getWidth(), this.img.getHeight(), 1f, 1f,
                    this.angle * -57.296f);
        }
        batch.end();
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public Sprite getImage() {
        return this.img;
    }

    public Rectangle getCollisionArea() {
        return new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    public void moveForward(double distance) {
        this.moveForward((float) distance);
    }

    public void moveForward(float distance) {
        this.x += Math.sin(this.angle) * distance;
        this.y += Math.cos(this.angle) * distance;
    }

    public void moveTowards(GameObject target, float distance) {
        float minDist = this.img.getWidth() + 10;
        float curDistX = target.x - this.x;
        float curDistY = target.y - this.y;
        this.angle = (float) Math.atan(curDistX / curDistY);
        float curDist = (float) Math.sqrt(curDistX * curDistX + curDistY * curDistY);
        if (distance >= curDist - minDist) {
            return;
        }
        //distance = Math.min(distance, curDist - minDist);
        this.x += curDistX * distance / curDist;
        this.y += curDistY * distance / curDist;
    }

    @Override
    public void move() {

    }
}