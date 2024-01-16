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
        int contadorO = 0;
        int contadorX = 0;
        int victoria[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 5, 6}};
        for (int n = 0; n < victoria.length; n++) {
            
        }
        return 0;
    }

    public int getUtilidad() {
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
