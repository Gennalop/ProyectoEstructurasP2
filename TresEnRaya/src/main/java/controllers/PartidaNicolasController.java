/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;


import com.mycompany.tresenraya.Jugador;
import java.net.URL;
import java.util.Comparator;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.Celda;
import modelo.Tablero;

/**
 * FXML Controller class
 *
 * @author nicolassierra
 */
public class PartidaNicolasController implements Initializable{

    @FXML
    private Label turnoLabel;
    @FXML
    private Label player1Label;
    @FXML
    private ImageView player1Simbolo;
    @FXML
    private Label player2Label;
    @FXML
    private ImageView player2Simbolo;
    @FXML
    private ImageView topLeftSpace;
    @FXML
    private ImageView topCenterSpace;
    @FXML
    private ImageView topRightSpace;
    @FXML
    private ImageView centerLeftSpace;
    @FXML
    private ImageView centerSpace;
    @FXML
    private ImageView centerRightSpace;
    @FXML
    private ImageView bottomLeftSpace;
    @FXML
    private ImageView bottomCenterSpace;
    @FXML
    private ImageView bottomRightSpace;
    @FXML
    private Button pistaButton;
    @FXML
    private Button reiniciarButton;
    
    private Tablero tablero;
    
    Comparator cmpString; //Comparador de Strings, falta definir aun

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        jugar();
    }    

    @FXML
    private void mostrarPista(MouseEvent event) {
    }

    @FXML
    private void reiniciarJuego(MouseEvent event) {
    }
    
        
}
