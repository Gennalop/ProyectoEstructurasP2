package controllers;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import modelo.Jugador;
import modelo.Tablero;

public class PartidaNicolasController implements Initializable {

    @FXML
    private BorderPane container;
    @FXML
    private Label player1Label;
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
    @FXML
    private ImageView avatarP1;
    @FXML
    private ImageView simboloP1;

    private Tablero tablero;
    private Comparator cmp;
    private Jugador p1; //Jugador 1 siempre será la persona si se juega contra cpu
    private Jugador p2;
    private Jugador jugadorActual;
    @FXML
    private Label player1Label1;
    @FXML
    private ImageView avatarP2;
    @FXML
    private ImageView simboloP2;
    @FXML
    private GridPane gameTable;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tablero = new Tablero();
        setOptions();
    }
    
    public void setPlayers(Jugador jugador1, Jugador jugador2){
        p1 = jugador1;
        p2 = jugador2;
        if(p1.isFirstTurn())
            jugadorActual = p1;
        else
            jugadorActual = p2;
        setPanel();
    }
    
    public void setPanel(){
        container.setStyle("-fx-background-image: url(img/background.jpg);-fx-background-size: cover");
        avatarP1.setImage(new Image("img/player.png"));
        simboloP1.setImage(p1.getSimbolo());
        if(p2.isMachine())
            avatarP2.setImage(new Image("img/computer.png"));
        else
            avatarP2.setImage(new Image("img/player.png"));
        simboloP2.setImage(p2.getSimbolo());
    }
    
    public void setOptions(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int fila = i;
                int columna = j;
                ImageView iv = (ImageView) gameTable.getChildren().get(i * 3 + j);
                iv.setImage(null);
                iv.setOnMouseClicked(event -> jugar(fila,columna,iv));
            }
        }
    }
    
    public void jugar(int fila, int columna, ImageView iv){
        iv.setImage(jugadorActual.getSimbolo());
        iv.setOnMouseClicked(null);
        //Actualizar tablero
        //Valida si es turno de una maquina
        //verificarGanador(); Falta probar
        if(p1.equals(jugadorActual))
            jugadorActual = p2;
        else
            jugadorActual = p1;
    }
    
    private void siguienteTurno(){
    }
    
    /*
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
    }*/

    @FXML
    private void mostrarPista(MouseEvent event) {
    }

    @FXML
    private void reiniciarJuego(MouseEvent event) {
        setOptions();
    }
    
}
