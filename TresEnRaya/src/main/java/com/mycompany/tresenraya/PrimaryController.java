package com.mycompany.tresenraya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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

        // Ajusta el tamaño preferido de las celdas
        double celdaSize = 100.0;

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                Celda celda = new Celda(i, j, celdas);
                tablero.add(celda, i, j);
                celdas[i][j] = celda;
                celda.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
                ImageView imagen = new ImageView(new Image("img/piezaO.png"));
                imagen.setFitWidth(100); // Establecer el ancho deseado
                imagen.setFitHeight(100);
                celda.getChildren().add(imagen);
            }
        }

        // Configura las restricciones de diseño para centrar el tablero en el BorderPane
        BorderPane.setAlignment(tablero, Pos.CENTER);
        panel.setCenter(tablero);
    }
}
