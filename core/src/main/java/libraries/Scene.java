package libraries;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import java.util.ArrayList;

public abstract class Scene implements Screen {

    private ArrayList<GameObject> allDrawables;
    private ArrayList<GameObject> toBeAdded;
    private ArrayList<GameObject> toBeRemoved;

    public Scene() {
        allDrawables = new ArrayList<GameObject>();
        toBeAdded = new ArrayList<GameObject>();
        toBeRemoved = new ArrayList<GameObject>();
    }

    public abstract void initialize();

    public abstract void updateScene();

    public abstract void checkInputs();

    public void addDrawable(GameObject image) {
        toBeAdded.add(image);
    }

    public void removeDrawable(GameObject image) {
        toBeRemoved.add(image);
    }

    //REFACTOR THIS AWAY TO THE ONE BELOW THIS METHOD
    public void addButtons(ArrayList<MenuButton> buttons) {
        toBeAdded.addAll(buttons);
    }

    public void addDrawables(ArrayList<GameObject> players) {
        toBeAdded.addAll(players);
    }

    @Override
    public void render(float f) {
        checkInputs();
        updateScene();
        flush();
        allDrawables.addAll(toBeAdded);
        toBeAdded.clear();
        allDrawables.removeAll(toBeRemoved);
        toBeRemoved.clear();
        for (GameObject drawable : allDrawables) {
            drawable.draw();
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    private void flush() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }
}
