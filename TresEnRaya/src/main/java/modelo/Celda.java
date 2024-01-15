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
public class Celda extends StackPane  {
    private ImageView simbolo;
    private final int fila;
    private final int columna;
    private Celda[][] celdas;

    public Celda(int fila, int columna, Celda[][] celdas) {
        this.fila = fila;
        this.columna = columna;
        this.celdas = celdas;
        this.simbolo = new ImageView(new Image("img/piezaVacia.png"));
        this.getChildren().add(simbolo);
        simbolo.setFitWidth(95);
        simbolo.setFitHeight(95);   
        setOnMouseClicked(this::handleMouseClicked);
    }

    private void handleMouseClicked(MouseEvent t) {
        Image img = new Image("img/piezaO.png");
        simbolo.setImage(img);
    }

    public ImageView getSimbolo() {
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
    
    
    
}
