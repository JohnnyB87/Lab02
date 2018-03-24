package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GameTab extends Tab{

    @FXML
    private BorderPane pane = new BorderPane();
    @FXML
    private Button reset = new Button();
    @FXML
    private Button guess = new Button();
    @FXML
    private Button exit;
    @FXML
    private TilePane tileButtons;
    private Alert alert;

    public GameTab(){

    }
    public GameTab(String title, String buttonName, String colour) throws Exception{
        this.setText(title);
        Pane p = (AnchorPane) FXMLLoader.load(getClass().getResource("../fxml/GameTab.fxml"));

        this.setContent(p);
    }

    public void exitGame() {
        System.out.println("Exit Game!");
        this.alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure you want to quit?",ButtonType.YES,ButtonType.NO);
        alert.showAndWait();

        if(alert.getResult() == ButtonType.YES) {
            Platform.exit();
        }
        else {
            alert.close();
        }
    }

    public void resetGame() {
        this.alert = new Alert(Alert.AlertType.CONFIRMATION,
            "Are you sure you want to reset the game.\nAll current progress will be lost?"
            , ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }

}
