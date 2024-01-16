package com.mycompany.tresenraya;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import modelo.Celda;
import modelo.Tablero;
import util.Tree;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        Tablero tablero = new Tablero();
        Celda celda1 = new Celda(0, 0);
        celda1.setSimbolo("img/piezaX.png");
        tablero.setCelda(0, 0, celda1);
        Celda celda2 = new Celda(2, 2);
        celda2.setSimbolo("img/piezaX.png");
        tablero.setCelda(2, 2, celda2);  
        Celda celda3 = new Celda(1, 1);
        celda3.setSimbolo("img/piezaX.png");
        tablero.setCelda(1, 1, celda3);        
        Tree<Tablero> arbol = tablero.generarArbol("img/piezaX.png", 0);
        System.out.print(arbol);
    }

}