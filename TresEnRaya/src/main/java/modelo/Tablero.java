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
    

    
    public Tree<Tablero> generarArbol(String pieza, int nivel) {
        Tablero tablero = this;
        Tree<Tablero> arbol = new Tree<>(this);
        List<Tree<Tablero>> hijos = new LinkedList<>();
        for (int n = 0; n < filas; n++) {
            for (int m = 0; m < columnas; m++) {
                Celda celda = celdas[n][m];
                if (celda.getSimbolo().equals("img/piezaVacia.png")) {
                    celda.setSimbolo(pieza);
                    Celda celdasTmp[][] = new Celda[filas][columnas];
                    celdasTmp[n][m] = celda;
                    Tablero tmp = new Tablero(celdasTmp);
                    Tree<Tablero> arbolTmp = new Tree<>(tmp);
                    hijos.add(arbolTmp);
                }
                
            }
        }
        if (nivel == 1){
            return arbol;
        }else{
            for (Tree<Tablero> t: hijos) {
                Tablero tbl = t.getRoot();
                tbl.generarArbol("img/piezaO.png", nivel + 1);
            }
            arbol.setChildren(hijos);
            return arbol;
        }
    }
}
