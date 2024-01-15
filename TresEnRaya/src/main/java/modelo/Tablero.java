/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Usuario
 */
public class Tablero extends GridPane {
    
    private int filas = 3;
    private int columnas = 3;
    private int utilidad;
    private Celda celdas[][];

    public Tablero(Celda[][] celdas) {
        this.celdas = celdas;
    }
    
    public int funcionDeUtilidad() {
        int contadorO = 0;
        int contadorX = 0;
        int victoria[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 5, 6}};
        for (int n = 0; n < victoria.length; n++) {
            
        }
        return 0;
    }
    
    
}
