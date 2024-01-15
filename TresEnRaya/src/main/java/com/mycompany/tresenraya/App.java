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
        Celda celda1 = new Celda(1,1, new Celda[1][1]);
        Celda celda2 = new Celda(1,1, new Celda[1][1]);
        boolean b1 = celda1.getSimbolo().equals(celda2.getSimbolo());
        boolean b2 = celda1.getSimbolo().getImage().equals(celda2.getSimbolo().getImage());
        boolean b3 = celda1.getSimbolo().getImage().getUrl().endsWith("img/piezaVacia.png");
        System.out.println("b1: " + b3);
        launch();

    }

}