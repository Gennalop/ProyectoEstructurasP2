package controllers;

import com.mycompany.tresenraya.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.Jugador;

public class MenuNicolasController implements Initializable {

    @FXML
    private Button vsCpuButton;
    @FXML
    private Button vsPlayerButton;
    @FXML
    private AnchorPane container;
    @FXML
    private VBox modePanel;
    @FXML
    private VBox piecePanel;
    @FXML
    private ImageView singleplayer;
    @FXML
    private ImageView multiplayer;
    @FXML
    private ImageView next;
    @FXML
    private ImageView previous;
    @FXML
    private ImageView pieceX;
    @FXML
    private ComboBox<String> turnX;
    @FXML
    private ImageView pieceO;
    @FXML
    private ComboBox<String> turnO;
    @FXML
    private Button jugar;
    
    private Jugador p1;
    private Jugador p2;
    
    private String mode = "Single Player";
    private Image piece = new Image("img/piezaX.png");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPanel();
        piecePanel.setVisible(false);
        previous.setVisible(false);
    }
    
    public void setPanel(){
        container.setStyle("-fx-background-image: url(img/background.jpg);-fx-background-size: cover");
        next.setImage(new Image("img/next.png"));
        previous.setImage(new Image("img/previous.png"));
        setModePanel();
        setPiecePanel();
        setOptionsLogic();
    }
    
    public void setModePanel(){
        singleplayer.setImage(new Image("img/singleplayer.png"));
        multiplayer.setImage(new Image("img/multiplayer.png"));
    }
    
    public void setPiecePanel(){
        pieceX.setImage(new Image("img/piezaX.png"));
        pieceO.setImage(new Image("img/piezaO.png"));
        turnX.getItems().addAll("1st","2nd");
        turnO.getItems().addAll("1st","2nd");
        turnX.setValue("1st");
        turnO.setValue("2nd");
    }
    
    public void setOptionsLogic() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setSpread(0.8);
        dropShadow.setColor(Color.DARKVIOLET);
        
        jugar.setOnMouseEntered(event -> {jugar.setEffect(dropShadow);});
        jugar.setOnMouseExited(event -> {jugar.setEffect(null);});
        
        pieceX.setOnMouseClicked(event -> changeStyle(pieceX,pieceO, dropShadow));
        pieceO.setOnMouseClicked(event -> changeStyle(pieceO,pieceX, dropShadow));
        
        pieceX.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> changePiece(pieceX));
        pieceO.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> changePiece(pieceO));
        
        vsCpuButton.setOnMouseClicked(event -> changeStyle(vsCpuButton,vsPlayerButton, dropShadow));
        vsPlayerButton.setOnMouseClicked(event -> changeStyle(vsPlayerButton,vsCpuButton, dropShadow));
        
        vsCpuButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> changeMode(vsCpuButton));
        vsPlayerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> changeMode(vsPlayerButton));
        
        turnX.setOnAction(event -> changeComboBox(turnX, turnO));
        turnO.setOnAction(event -> changeComboBox(turnO, turnX));
        
        changeStyle(pieceX,pieceO, dropShadow);
        changeStyle(vsCpuButton,vsPlayerButton, dropShadow);
    }
    
    public void changeStyle(Node change, Node restore, Effect e){
        change.setEffect(e);
        restore.setEffect(null);
    }
    
    public void changeComboBox(ComboBox<String> change, ComboBox<String> restore){
        String selectedItem = change.getSelectionModel().getSelectedItem();
        for(String s : restore.getItems()){
            if(!s.equals(selectedItem))
                restore.setValue(s);
        }
    }
    
    public void changePiece(ImageView iv){
        piece = iv.getImage();
    }
    
    public void changeMode(Button b){
        mode = b.getText();
    }
    
    @FXML
    private void nextOption(MouseEvent event) {
        piecePanel.setVisible(true);
        modePanel.setVisible(false);
        previous.setVisible(true);
        next.setVisible(false);
    }

    @FXML
    private void previousOption(MouseEvent event) {
        piecePanel.setVisible(false);
        modePanel.setVisible(true);
        previous.setVisible(false);
        next.setVisible(true);
    }
    
    public void setPlayers(){
        boolean firstTurn;
        Image pieceP2;
        if(piece.getUrl().contains("piezaX")){
            firstTurn = turnX.getSelectionModel().getSelectedItem().equals("1st");
            pieceP2 = pieceO.getImage();
        } else {
            firstTurn = turnO.getSelectionModel().getSelectedItem().equals("1st");
            pieceP2 = pieceX.getImage();
        } 
        p1 = new Jugador(firstTurn, piece, false);
        if(mode.equals("Single Player"))
            p2 = new Jugador(!firstTurn, pieceP2, true);
        else
            p2 = new Jugador(!firstTurn, pieceP2, false);
    }


    @FXML
    private void jugar(MouseEvent event) {
        setPlayers();
        try {
            FXMLLoader loader;
            loader = App.loadFXML("partidaNicolas");
            Scene sc = new Scene(loader.load());
            PartidaNicolasController pc = loader.getController();
            pc.setPlayers(p1, p2);
            App.setScene(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
