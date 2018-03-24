
import controllers.GameTab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private int windowWidth = 400;
    private int windowHeight = 400;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Window");
        primaryStage.setResizable(false);

        Tab tab = new GameTab("Game Tab","GUESS", "#dedede");


        TabPane tp = new TabPane();
        tp.getTabs().add(tab);
        StackPane sp = new StackPane();
        sp.getChildren().add(tp);

        Scene scene = new Scene(sp,windowWidth,windowHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}