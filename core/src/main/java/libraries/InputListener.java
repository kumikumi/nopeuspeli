package libraries;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;

public class InputListener implements InputProcessor {

    private boolean isButtonPressed = false;
    private float mouseX;
    private float mouseY;

    public boolean isLeftMouseButtonClicked() {
        if (isButtonPressed) {
            isButtonPressed = false;
            return true;
        }
        return false;
    }

    public float getMouseX() {
        return mouseX;
    }

    public float getMouseY() {
        return mouseY;
    }
    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int mouseX, int mouseY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int mouseX, int mouseY, int pointer, int button) {
        if (button == Buttons.LEFT) {
            isButtonPressed = true;
        }
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int mouseX, int mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

}
