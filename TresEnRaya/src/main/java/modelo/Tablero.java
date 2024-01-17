package modelo;

import java.util.Comparator;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Tablero extends GridPane {
    
    private Image[][] celdas;
    private Comparator<Image> cmpCeldas;
    private int utilidad;
    
    public Tablero() {
        celdas = new Image[3][3]; //Todas se inicializan con null
        cmpCeldas = (c1, c2) -> {
            return c1.getUrl().compareTo(c2.getUrl());
        };
    }
    
    public void update(int fila, int columna, Image img){
        celdas[fila][columna] = img;
    }
    
    public String getState(){
        if(isWinnerTable())
            return "Winn";
        else if(isProgressTable())
            return "In progress";
        else
            return "Draft";
    }
    
    public boolean isProgressTable(){
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                if(celdas[n][m] == null)
                    return true;
            }
        }
        return false;
    }
    
    public boolean isWinnerTable(){
        for (int i = 0; i < 3; i++) {
            //Horizontal
            if(celdasIguales(celdas[i][0], celdas[i][1], celdas[i][2])){
                return true;
            }
            //Vertical
            else if(celdasIguales(celdas[0][i], celdas[1][i], celdas[2][i])){
                return true;
            }
            //Diagonales
            else if(celdasIguales(celdas[0][0], celdas[1][1], celdas[2][2])){
                return true;
            }
            else if(celdasIguales(celdas[0][2], celdas[1][1], celdas[2][0])){
                return true;
            }
        }
        return false;
    }
    
    private boolean celdasIguales(Image a, Image b, Image c){
       if(a==null || b==null || c==null)
           return false;
       else if(cmpCeldas.compare(a, b) == 0 && cmpCeldas.compare(b, c) == 0)
           return true;
       else
           return false;
    }
    
    private boolean celdasLibres(Image ref, Image a, Image b, Image c){ //Indica si no hay una pieza contraria
        if(a==null && b==null && c==null)
           return true;
        if(a!=null && cmpCeldas.compare(a, ref) != 0)
           return false;
        if(b!=null && cmpCeldas.compare(b, ref) != 0)
           return false;
        if(c!=null && cmpCeldas.compare(c, ref) != 0)
           return false;
        return true;
    }
    
    public int getTotalOptions(Image ref){
        int total=0; // [filas columnas diagonales]
        //Diagonales
        if(celdasLibres(ref,celdas[0][0], celdas[1][1], celdas[2][2]))
            total++;
        if(celdasLibres(ref,celdas[0][2], celdas[1][1], celdas[2][0]))
            total++;
        for (int i = 0; i < 3; i++) {
            //Horizontal
            if(celdasLibres(ref,celdas[i][0], celdas[i][1], celdas[i][2]))
                total++;
            //Vertical
            if(celdasLibres(ref,celdas[0][i], celdas[1][i], celdas[2][i]))
                total++;
        }
        return total;
    }
    
    public void setUtilidad(Jugador objetivo, Jugador oponente) {
        int totalOpcionesP1 = getTotalOptions(objetivo.getSimbolo());
        int totalOpcionesP2 = getTotalOptions(oponente.getSimbolo());
        utilidad = totalOpcionesP1 - totalOpcionesP2;
    }
    
    public void setUtilidad(int u) {
        utilidad = u;
    }
    
    public int getUtilidad() {
        return utilidad;
    }
    
    public Tablero copiarTablero() {
        Tablero tablero = new Tablero();
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                tablero.celdas[n][m] = celdas[n][m];
            }
        }
        return tablero;
    }

    public Image[][] getCeldas() {
        return celdas;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String simbolo;
                if(celdas[i][j] == null)
                    simbolo = "-";
                else if(celdas[i][j].getUrl().contains("piezaX"))
                    simbolo = "X";
                else
                    simbolo = "O";
                result.append(simbolo);
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
