package modelo;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Tablero extends GridPane {
    
    private Image[][] celdas;
    
    public Tablero() {
        celdas = new Image[3][3]; //Todas se inicializan con null
    }

}
