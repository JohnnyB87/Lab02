package controllers;

import classes.ListOfWinners;
import classes.Winner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListOfWinnersTab extends Tab {

    private TableView<Winner> winnersTableView;
    private TableColumn<Winner, String> firstName;
    private TableColumn<Winner, String> lastName;
    private TableColumn<Winner, String> starPrize;
    private static ListOfWinners lof;

    public ListOfWinnersTab(){
        lof = new ListOfWinners();

        Pane pane = new Pane();
        pane.prefHeight(350);
        pane.prefWidth(410);

        firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        firstName.setMaxWidth(100);

        lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        lastName.setMaxWidth(100);

        starPrize = new TableColumn<>("Prize Value");
        starPrize.setCellValueFactory(new PropertyValueFactory<>("prizeValue"));
        starPrize.setMaxWidth(100);

        winnersTableView = new TableView<>();
        winnersTableView.setMaxSize(300,200);
//        winnersTableView.maxWidth(300);
        winnersTableView.setLayoutX(75);
        winnersTableView.setLayoutY(50);

        winnersTableView.setItems(toObservableList());

        winnersTableView.getColumns().addAll(firstName, lastName, starPrize);

        pane.getChildren().addAll(winnersTableView);

        this.setContent(pane);

    }

    public void removeButtonPressed() {
    }

    public ObservableList<Winner> toObservableList(){
        ObservableList<Winner> ol = FXCollections.observableArrayList();
        System.out.println("-------------------------");
        for(Winner w : lof.getWinners()) {
            System.out.printf("%s %s %d%n",w.getFName(),w.getLName(),w.getPrizeValue());
            ol.add(new Winner(w.getFName(), w.getLName(),w.getPrizeValue()));
        }
        System.out.println("-------------------------");
        return ol;
    }

    public ListOfWinners getLof(){
        return lof;
    }

    public TableView<Winner> getWinnersTableView() {
        return this.winnersTableView;
    }
}
