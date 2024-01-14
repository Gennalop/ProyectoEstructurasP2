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
import javafx.fxml.Initializable;
import modelo.Celda;
import modelo.Tablero;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class PartidaController implements Initializable {
    
    private Tablero tablero;
    
    Comparator cmpString; //Comparador de Strings, falta definir aun

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void jugar(){
    this.tablero = new Tablero();
    Jugador jugador1 = new Jugador("X"); //Jugador 1 siempre será la persona si se juega contra cpu
    Jugador jugador2 = new Jugador("O");
    
    Jugador jugadorActual;
    Random random = new Random();
    int inicial = random.nextInt(2) + 1;
    
    if(inicial == 1){ //Ver quien inicia primero
        jugadorActual = jugador1;
    }else
        jugadorActual = jugador2;
    }
    
    
    private void siguienteTurno(){
        
        
    }
    
    
    private boolean verificarGanador(){
        Celda[][] juego = tablero.getCeldas();
        for (int i = 0; i < 3; i++) {
            
            //Horizontal
            if(sonIguales(juego[i][0], juego[i][1], juego[i][2])){
                return true;
            }
            
            //Vertical
            else if(sonIguales(juego[0][i], juego[1][i], juego[2][i])){
                return true;
            }
            
            
            //Diagonal
            else if(sonIguales(juego[0][0], juego[1][1], juego[2][2])){
                return true;
            }
        }
        
        return false; //Si es que no sale ningun ganador por ahora
   
    }
    
    private boolean sonIguales(Celda a, Celda b, Celda c){
       if(cmpString.compare(a.getSimbolo(), b.getSimbolo()) == 0 && cmpString.compare(b.getSimbolo(), c.getSimbolo()) == 0)
           return true;
       else
           return false;
    }
}
