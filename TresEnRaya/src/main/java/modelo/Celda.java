/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


/**
 *
 * @author Usuario
 */
public class Celda extends StackPane {
    private String simbolo;
    private final int fila;
    private final int columna;
    private Celda[][] celdas;

    public Celda(int fila, int columna, Celda[][] celdas) {
        this.fila = fila;
        this.columna = columna;
        this.celdas = celdas;
        this.simbolo = "img/piezaVacia.png";
        ImageView iv = new ImageView(new Image(simbolo));
        iv.setFitWidth(95);
        iv.setFitHeight(95);   
        this.getChildren().add(iv);
        setOnMouseClicked(this::handleMouseClicked);
    }

    private void handleMouseClicked(MouseEvent t) {
        this.setSimbolo("img/piezaO.png");
        ImageView iv = new ImageView(new Image(simbolo));
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    
    
}
