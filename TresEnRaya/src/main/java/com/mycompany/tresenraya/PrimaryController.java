package com.mycompany.tresenraya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import modelo.Celda;
import modelo.Tablero;

public class PrimaryController implements Initializable {
    @FXML
    private BorderPane panel;
    
    private int fila = 3;
    private int columna = 3;
    private Celda celdas[][] = new Celda[fila][columna];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTablero();
    }
    
    public void llenarTablero() {
        GridPane tablero = new Tablero();
        panel.setCenter(tablero);
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                Celda celda = new Celda(i, j, celdas);
                celda.setText("vacio");
                tablero.add(celda, i, j);
                celdas[i][j] = celda;
            }
        }
        tablero.setHgap(100);
        tablero.setVgap(100);
    }

}
