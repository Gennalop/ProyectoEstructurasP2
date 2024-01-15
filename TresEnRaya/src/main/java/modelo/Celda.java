/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author Usuario
 */
public class Celda extends Label  {
    private String simbolo;
    private final int fila;
    private final int columna;
    private Celda[][] celdas;

    public Celda(int fila, int columna, Celda[][] celdas) {
        this.simbolo = "vacio";
        this.setText("vacio");
        this.fila = fila;
        this.columna = columna;
        this.celdas = celdas;
        setOnMouseClicked(this::handleMouseClicked);
    }

    private void handleMouseClicked(MouseEvent t) {
        
    }
    
    
}
