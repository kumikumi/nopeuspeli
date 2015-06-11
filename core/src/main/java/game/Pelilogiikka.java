package game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import libraries.MenuButton;

public class Pelilogiikka {

    private Random arpoja;
    private List<MenuButton> buttons;
    private LinkedList<MenuButton> painettavatNapit;
    private MenuButton uusinArvottuNappi;
    private int aika;
    private int laskuri;
    private boolean running;

    public Pelilogiikka(List<MenuButton> buttons) {
        this.painettavatNapit = new LinkedList<MenuButton>();
        this.buttons = buttons;
        this.arpoja = new Random();
    }

    public void startGame() {
        for (MenuButton b : buttons) {
            b.setHover(false);
        }
        this.painettavatNapit = new LinkedList<MenuButton>();
        this.aika = 100;
        this.laskuri = aika;
        running = true;
    }

    private void endGame() {
        for (MenuButton b : buttons) {
            b.setHover(true);
        }
        running = false;
    }

    public void buttonPressed(MenuButton button) {
        if (!running) {
            return;
        }
        MenuButton nextButton = painettavatNapit.poll();
        if (button == nextButton) {
            System.out.println("click ok");
            button.setHover(false);
        } else {
            if (nextButton == null) {
                System.out.println("Vielä ei olisi saanut painaa!");
            } else {
                System.out.println("Olisi pitänyt painaa " + nextButton.getButtonText());
                System.out.println("Painoit " + button.getButtonText());
            }
            endGame();
        }
    }

    private void arvoUusiNappi() {
        if (uusinArvottuNappi != null) {
            uusinArvottuNappi.setHover(false);
        }

        MenuButton nappi = uusinArvottuNappi;
        while (nappi == uusinArvottuNappi) {
            nappi = buttons.get(arpoja.nextInt(buttons.size()));
        }
        nappi.setHover(true);
        this.painettavatNapit.add(nappi);
        uusinArvottuNappi = nappi;
    }

    public void update() {
        if (!running) {
            return;
        }
        this.laskuri--;

        if (laskuri == 0) {
            aika--;
            laskuri = aika;
            arvoUusiNappi();
        }

    }
}
