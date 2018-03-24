package controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import classes.Person;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PersonPane extends Pane {

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
    Person p = new Person();

    public PersonPane() throws Exception{

        this.setMaxWidth(400);
        this.setMaxHeight(350);
    }

    public void clickSubmitButton(){
        String fName = this.fNameTxtFld.getText();
        String lName = this.lNameTxtFld.getText();

        p = new Person();
        p.setfName(fName);
        p.setlName(lName);
    }

    public void clickClearButton(){
        this.fNameTxtFld.clear();
        this.lNameTxtFld.clear();
    }
}
