package controllers;

import com.mycompany.tresenraya.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import modelo.Turno;
import modelo.Jugador;
import modelo.Tablero;

public class PartidaNicolasController implements Initializable {

    @FXML
    private BorderPane container;
    @FXML
    private ImageView avatarP1;
    @FXML
    private ImageView simboloP1;
    @FXML
    private ImageView avatarP2;
    @FXML
    private ImageView simboloP2;
    @FXML
    private GridPane gameTable;
    @FXML
    private Label winsP1;
    @FXML
    private Label winsP2;
    
    private Tablero tablero;
    private Jugador p1; //Jugador 1 siempre será la persona si se juega contra cpu
    private Jugador p2;
    private Jugador jugadorOponente;
    private Jugador jugadorActual;
    private Turno turno;
    private boolean block;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setOptions();
        System.out.println(tablero.toString()+"\n");
    }
    
    public void setOptions() {
        tablero = new Tablero();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int fila = i;
                int columna = j;
                ImageView iv = (ImageView) gameTable.getChildren().get(fila * 3 + columna);
                iv.setImage(null);
                iv.setOnMouseClicked(event -> jugar(fila, columna, iv));
            }
        }
    }
    
    public void setPlayers(Jugador jugador1, Jugador jugador2){
        p1 = jugador1;
        p2 = jugador2;
        if(p1.isFirstTurn()){
            jugadorActual = p1;
            jugadorOponente = p2;
        } else{
            jugadorActual = p2;
            jugadorOponente = p2;
        } 
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
        if(jugadorActual.isMachine()){
            machinePlays();
            return;
        }
    }
    
    public void machinePlays(){
        turno = new Turno(tablero,jugadorActual, jugadorOponente);
        int[] coord = turno.getCoordinatesMinMax();
        int fila =coord[0];
        int column = coord[1];
        jugar(fila, column, (ImageView) gameTable.getChildren().get(fila * 3 + column));
    }
    
    public void jugar(int fila, int columna, ImageView iv) {
        if (!block) {
            System.out.println("Antes:\n" + tablero.toString() + "\n");
            Image simbolo = jugadorActual.getSimbolo();
            iv.setImage(simbolo);
            tablero.update(fila, columna, simbolo);
            System.out.println("Después:\n" + tablero.toString() + "\n");
            iv.setOnMouseClicked(null);
            String state = tablero.getState();
            if (!state.equals("In progress")) {
                //Mostrar jugada ganadora
                //Aumentar wins
                delaySetGameOver();
                return;
            }

//_----------------------
            //Valida si es turno de una maquina
            if (p1.equals(jugadorActual)) {
                jugadorActual = p2;
                jugadorOponente = p1;
            } else {
                jugadorActual = p1;
                jugadorOponente = p2;
            }
            if (jugadorActual.isMachine()) {
                machinePlays();
                return;
            }
        }
    }
    
    private void delaySetGameOver() { //Este metodo solo es para la visualización
        block = true;
        Duration delay = Duration.seconds(0.6);
        KeyFrame keyFrame = new KeyFrame(delay, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setGameOver();
            }
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();
    }
     
    public void setGameOver(){
        //Mostar ventana quien gano o el estado
        setOptions();
        block = false;
    }

    @FXML
    private void mostrarPista(MouseEvent event) {
    }

    @FXML
    private void reiniciarJuego(MouseEvent event) {
        setOptions();
    }

    @FXML
    private void regresarAMenu(MouseEvent event) {
        try {
            FXMLLoader loader;
            loader = App.loadFXML("menuNicolas");
            Scene sc = new Scene(loader.load());
            App.setScene(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
