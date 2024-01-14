/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


/**
 *
 * @author Usuario
 */
public class Celda extends Pane  {
    private String simbolo;
    private final int fila;
    private final int columna;

    public Celda(int fila, int columna) {
        this.simbolo = "vacio";
        this.fila = fila;
        this.columna = columna;
        setOnMouseClicked(this::handleMouseClicked);
    }

    private void handleMouseClicked(MouseEvent t) {
        
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    
    
    
}
