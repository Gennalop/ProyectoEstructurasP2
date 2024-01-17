package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.scene.image.Image;
import util.Tree;

public class Turno {
    
    private Tablero tablero;
    private Jugador jugador;
    private Jugador oponente;
    
    public Turno(Tablero tablero, Jugador p1, Jugador p2) {
        this.tablero = tablero;
        this.jugador = p1;
        this.oponente = p2;
    }
    
    public Tree<Tablero> generarJugadas(boolean getFirstNevel, Tablero tb) {
        Tree<Tablero> arbolJugadas = new Tree<>(tb);
        List<Tree<Tablero>> hijos = new ArrayList<>();
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                Tablero tmp = tb.copiarTablero();
                Image simbolo = tb.getCeldas()[n][m];
                if (simbolo == null) {
                    simbolo = jugador.getSimbolo();
                    tmp.update(n, m, simbolo);
                    hijos.add(new Tree<>(tmp));
                }
            }
        }
        if(!getFirstNevel) {
            for(int i = 0; i<hijos.size(); i++){
                Tablero t = hijos.get(i).getRoot();
                Tree<Tablero> arbolRespuestas = generarJugadas(true,t);
                hijos.set(i, arbolRespuestas);
            }
        }
        arbolJugadas.setChildren(hijos);
        return arbolJugadas;
    }
    
    public Tablero getTableroMinMax(){
        List<Tree<Tablero>> jugadas = generarJugadas(false, tablero).getChildren();
        Queue<Tablero> colaMax = new PriorityQueue<>((tab1, tab2) -> {
            return tab2.getUtilidad()-tab1.getUtilidad();
        });
        for(Tree<Tablero> tree1 : jugadas){
            Tablero t1 = tree1.getRoot();
            List<Tree<Tablero>> respuesta = tree1.getChildren();
            Queue<Tablero> colaMin = new PriorityQueue<>((tab1, tab2) -> {
            return tab1.getUtilidad()-tab2.getUtilidad();
            });
            for(Tree<Tablero> tree2 : respuesta){
                Tablero t2 = tree1.getRoot();
                t2.setUtilidad(jugador, oponente);
                colaMin.add(t2);
            }
            t1.setUtilidad(colaMin.poll().getUtilidad());
            colaMax.add(t1);
        }
        return colaMax.poll();
    }
    
    public int[] getCoordinatesMinMax(){
        Tablero t = getTableroMinMax();
        int retorno[] = new int[2]; // [fila columna]
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                if (tablero.getCeldas()[n][m]==null && t.getCeldas()[n][m]!=null) {
                    retorno[0] = n;
                    retorno[1] = m;
                }
            }
        }
        return retorno;
    }
    
}
