package modelo;

import javafx.scene.image.Image;

public class Jugador {

    private boolean firstTurn;
    private Image simbolo;
    private boolean machine;
    private int wins;

    public Jugador(boolean firstTurn, Image simbolo, boolean machine) {
        this.firstTurn = firstTurn;
        this.machine = machine;
        this.simbolo = simbolo;
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    public boolean isMachine() {
        return machine;
    }

    public Image getSimbolo() {
        return simbolo;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
