package libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {

    private TextureRegion[] frames;
    private float time;
    private float delay;
    private int currentFrame;
    private int timesPlayed;

    public Animation(TextureRegion[] frames, float delay) {
        setFrames(frames, delay);
    }

    public void setFrames(TextureRegion[] frames, float delay) {
        this.frames = frames;
        this.delay = delay;
        this.time = 0;
        this.currentFrame = 0;
        this.timesPlayed = 0;
    }

    public void setFrames(TextureRegion[] frames) {
        this.frames = frames;
    }

    public void draw(SpriteBatch batch, float x, float y) {
        update(Gdx.graphics.getDeltaTime());
    }

    public void update(float dt) {
        if (delay <= 0) {
            return;
        }
        time += dt;
        if(time > delay){
            step();
            time = 0;
        }
    }

    private void step() {
        currentFrame++;
        if (currentFrame == frames.length) {
            currentFrame = 0;
            timesPlayed++;
        }
    }

    public TextureRegion getFrame() {
        return frames[currentFrame];
    }

    public int getTimesPlayer() {
        return timesPlayed;
    }
}