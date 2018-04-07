package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import classes.Winner;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WinnerPane extends Pane {

    @FXML
    private Button clear;
    @FXML
    private Button submit;
    @FXML
    private Label fNameLabel;
    @FXML
    private Label lNameLabel;
    @FXML
    private TextField fNameTxtFld;
    @FXML
    private TextField lNameTxtFld;
    private String fName;
    private String lName;

    public WinnerPane() throws Exception{
        this.setMaxWidth(400);
        this.setMaxHeight(350);
//        this.getChildren().add(FXMLLoader.load(getClass().getResource("../resources/WinnerPane.fxml")));
    }

    public void clickSubmitButton(){
        if(!this.fNameTxtFld.getText().equals("")
                && !this.lNameTxtFld.getText().equals("")) {
            this.fName = this.fNameTxtFld.getText();
            this.lName = this.lNameTxtFld.getText();
            System.out.printf("TEST :  fn: %s  ln: %s%n",this.fName,this.lName);
            Stage s = (Stage)this.submit.getScene().getWindow();
            s.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Enter a valid name.");
            alert.showAndWait();
        }
    }

    public void clickClearButton(){
        this.fNameTxtFld.clear();
        this.lNameTxtFld.clear();
    }

    public String getfName(){
        return this.fName;
    }

    public String getlName() {
        return this.lName;
    }

}
