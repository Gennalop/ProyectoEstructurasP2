/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.layout.GridPane;

/**
 *
 * @author Usuario
 */
public class Tablero extends GridPane {
    private Celda[][] celdas;
    private final int filas = 3;
    private final int columnas = 3;
    
    public Tablero() {
        celdas = new Celda[3][3]; //Todas se inicializan con null
        for (int i = 0; i < filas; i++) { //Filas
            for (int j = 0; j < columnas; j++) { //Columnas
                celdas[i][j] = new Celda(i, j); 
                //Inicia el nuevo tablero con todas las celdas "vacias"
            }
        }    
    }

    public Tablero(Celda[][] celdas) {
        this.celdas = celdas;
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    
    
    public Celda getCeldaIndividual(int fila, int columna){
        if(fila == 0 || fila > 3 || columna == 0 || columna > 3){
            return null;
        }      
        return this.getCeldas()[fila][columna];
    }
    
    
    
    
    
    
    
    
    
    
    
}
