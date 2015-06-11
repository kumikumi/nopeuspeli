package game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.ArrayList;
import libraries.InputListener;
import libraries.MenuButton;
import libraries.Scene;
import libraries.StaticImage;
import net.java.games.input.Component.Identifier.Key;

class MenuScene extends Scene {

    private ArrayList<MenuButton> buttonList;
    private ArrayList<MenuButton> gameButtons;

    private InputListener inputListener;
    private Pelilogiikka logiikka;

    @Override
    public void initialize() {

        buttonList = new ArrayList<MenuButton>();
        gameButtons = new ArrayList<MenuButton>();

        Sprite backgroundImg = new Sprite(new Texture("assets/background.png"));
        StaticImage background = new StaticImage(0, 0, backgroundImg);
        addDrawable(background);

        Sprite logoImg = new Sprite(new Texture("assets/logo.png"));
        StaticImage logo = new StaticImage(100, 700, logoImg);
        addDrawable(logo);

        MenuButton nappi0 = new MenuButton(100, 100, new Sprite(new Texture("assets/nappi1_off.png")), new Sprite(new Texture("assets/nappi1_on.png")), "NAPPI0");
        gameButtons.add(nappi0);
        nappi0.bindKey(Keys.NUM_1);

        MenuButton nappi1 = new MenuButton(300, 100, new Sprite(new Texture("assets/nappi2_off.png")), new Sprite(new Texture("assets/nappi2_on.png")), "NAPPI1");
        gameButtons.add(nappi1);
        nappi1.bindKey(Keys.NUM_2);

        MenuButton nappi2 = new MenuButton(500, 100, new Sprite(new Texture("assets/nappi3_off.png")), new Sprite(new Texture("assets/nappi3_on.png")), "NAPPI2");
        gameButtons.add(nappi2);
        nappi2.bindKey(Keys.NUM_3);

        MenuButton nappi3 = new MenuButton(700, 100, new Sprite(new Texture("assets/nappi4_off.png")), new Sprite(new Texture("assets/nappi4_on.png")), "NAPPI3");
        gameButtons.add(nappi3);
        nappi3.bindKey(Keys.NUM_4);

        MenuButton startButton = new MenuButton(100, 600, new Sprite(new Texture("assets/rosk/buttonStart.png")), new Sprite(new Texture("assets/rosk/buttonStartHover.png")), "START");
        buttonList.add(startButton);
        addButtons(gameButtons);
        addButtons(buttonList);

        logiikka = new Pelilogiikka(gameButtons);

        inputListener = new InputListener();
        Gdx.input.setInputProcessor(inputListener);
    }

    @Override
    public void updateScene() {
        logiikka.update();
    }

    @Override
    public void checkInputs() {
        for (MenuButton button : buttonList) {
            if (button.isMousePointerTouching(inputListener.getMouseX(), inputListener.getMouseY())) {
                button.setHover(true);
                if (inputListener.isLeftMouseButtonClicked()) {
                    if ("QUIT".equals(button.getButtonText())) {
                        System.exit(0);
                    }
                    if ("START".equals(button.getButtonText())) {
                        //MyGame.sceneManager.nextScene();
                        logiikka.startGame();
                    }
                }
            } else {
                button.setHover(false);
            }
        }

        for (MenuButton button : gameButtons) {
            if (button.isMousePointerTouching(inputListener.getMouseX(), inputListener.getMouseY())) {
                if (inputListener.isLeftMouseButtonClicked()) {
                    logiikka.buttonPressed(button);
                }
            }
            if (button.keyWasJustPressed()) {
                logiikka.buttonPressed(button);
            }
        }
    }

}
