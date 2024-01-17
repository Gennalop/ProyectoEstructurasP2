/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import util.Tree;

/**
 *
 * @author Usuario
 */
public class Tablero extends GridPane {
    
    private int filas = 3;
    private int columnas = 3;
    private int utilidad;
    private Celda celdas[][];

    public Tablero(Celda[][] celdas) {
        this.celdas = celdas;
    }
    
    public Tablero() {
        celdas = new Celda[filas][columnas];
        for (int n = 0; n < filas; n++) {
            for (int m = 0; m < columnas; m++) {
                Celda celda = new Celda(n, m);
                celdas[n][m] = celda;
            }
        }  
    }
    
    public int funcionDeUtilidad() {
        int contadorO = calcularPosiblesJugadas("O"); //Pieza jugador real
        int contadorX = calcularPosiblesJugadas("X"); //Pieza cpu
        
        //Como el que le sirve este dato es el cpu, cpu es el "jugador" en el calculo de utilidad, u jugador(t) = P jugador– Poponente
        return contadorX - contadorO;
    }
    
    private int calcularPosiblesJugadas(String simbolo){
     
        int posiblesJugadas = 0;
        for (int n = 0; n < 3; n++) { //filas
            
            boolean probableFila = true;
            boolean probableColumna = true;
            boolean probableDiagonal = true;
            
            for(int m = 0; m < 3; m++){ //columnas
                
                if(simbolo.equals("O")){ //Para el simbolo O
                    if(!celdas[n][m].isEmpty() && !celdas[n][m].isO()){
                        probableFila = false;
                    }
                    
                    if(!celdas[m][n].isEmpty() && !celdas[m][n].isO()){
                        probableColumna = false;
                    }
                    
                    if(!celdas[m][m].isEmpty() && !celdas[m][m].isO()){ //en la diagonal puede ser [n][n] o [m][m], no importa ahí
                        probableDiagonal = false;
                    }
                }
                
                else{ //Para el simbolo X
                    if(!celdas[n][m].isEmpty() && !celdas[n][m].isX()){
                        probableFila = false;
                    }
                    
                    if(!celdas[m][n].isEmpty() && !celdas[m][n].isX()){
                        probableColumna = false;
                    }
                    
                    if(!celdas[m][m].isEmpty() && !celdas[m][m].isX()){
                        probableDiagonal = false;
                    }
                }
            }
            if(probableFila == true)
                posiblesJugadas++;
            
            if(probableColumna == true)
                posiblesJugadas++;
            
            if(probableDiagonal == true)
                posiblesJugadas++;
            
         
     
        
        }
        return posiblesJugadas;
    }
    
    public String verificarGanador(){ //Retorna el simbolo que gano, se deberia correr cada turno
           
        for(int i = 0; i < 3; i++){
            
            //Horizontal
            if(jugadaGanadora(celdas[i][0], celdas[i][1], celdas[i][2]))
                return celdas[i][0].getSimbolo(); //Retorna el simbolo que tiene la jugada ganadora
            
            //Vertical
            else if(jugadaGanadora(celdas[0][i], celdas[1][i], celdas[2][i]))
                return celdas[0][1].getSimbolo();
            
            //Diagonales
            else if(jugadaGanadora(celdas[0][0], celdas[1][1], celdas[2][2]))
                return celdas[0][0].getSimbolo();
            
            else if(jugadaGanadora(celdas[2][0], celdas[1][1], celdas[0][2]))
                return celdas[2][0].getSimbolo();
            
        }
        
        return null;
    }
    
    private boolean jugadaGanadora(Celda a, Celda b, Celda c){
        return (a.compareTo(b) == 0 && b.compareTo(c) == 0);
    }

    public int getUtilidad(){
        return utilidad;
    }

    public Celda[][] getCeldas() {
        return celdas;
    }
    
    public Celda getCelda(int n, int m) {
        return celdas[n][m];
    }
    
    public void setCelda(int n, int m, Celda c) {
        celdas[n][m] = c;
    }
    
    public Tablero copiarTablero() {
        Tablero tablero = new Tablero();
        for (int n = 0; n < filas; n++) {
            for (int m = 0; m < columnas; m++) {
                Celda celda = this.getCelda(n, m);
                tablero.setCelda(n, m, celda);
            }
        }
        return tablero;
    }
    
    public Tree<Tablero> generarArbol(String pieza, int nivel) {
            Tree<Tablero> arbol = new Tree<>(this);
            List<Tree<Tablero>> hijos = new LinkedList<>();
            Tablero aux = this;
            for (int n = 0; n < filas; n++) {
                for (int m = 0; m < columnas; m++) {
                    Celda celda = this.getCelda(n, m);
                    Tablero tmp = new Tablero(this.copiarTablero().getCeldas());
                    if (celda.getSimbolo().equals("img/piezaVacia.png")) {
                 
                        celda = new Celda(n, m);
                        celda.setSimbolo(pieza);

                        
                        tmp.setCelda(n, m, celda);
                        if (nivel == 1){
                            Tree<Tablero> arbolTmp = new Tree<>(tmp);
                            hijos.add(arbolTmp);
                        }else{
                            Tree<Tablero> arbolTmp = tmp.generarArbol("img/piezaO.png", nivel + 1);
                            hijos.add(arbolTmp);
                        }    
                    
                    }

                }
            }
            arbol.setChildren(hijos);
            return arbol;
    }
    
    public boolean isFull(){ //Me indica si el tablero ya esta lleno de simbolos y no se puede jugar mas
        boolean full = true;
        for(int f = 0; f < 3; f++){
            for(int c = 0; c < 3; c++){
                if(celdas[f][c].isEmpty())
                    return false;
                
            }
        }
        return full;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.append(celdas[i][j].getSimbolo().charAt(9));
                if (j < 2) {
                    result.append(" "); // Agrega espacio entre elementos de la misma fila
                }
            }
            if (i < 2) {
                result.append("\n"); // Agrega salto de línea entre filas
            }
        }
        return result.toString();
    }
   
}
