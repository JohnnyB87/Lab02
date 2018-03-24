import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private int windowWidth = 400;
    private int windowHeight = 350;
    private static Stage primaryStage;

    public static void main(String[] args){
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = getPrimaryStage();
        primaryStage.setTitle("Window");
        primaryStage.setResizable(false);

        TabPane tabPane = new TabPane();

        String colour = "#bcbcbc";
        GuessingGameTab guessingGameTab = new GuessingGameTab("Guessing Game","Guess", colour);
        LotteryGameTab lotteryGameTab = new LotteryGameTab("Lottery Game","Submit", colour);
        //PersonPane personTab = new PersonPane();
        
        guessingGameTab.setClosable(false);
        lotteryGameTab.setClosable(false);

        tabPane.getTabs().addAll(guessingGameTab, lotteryGameTab);
//        tabPane.getTabs().addAll(guessingGameTab, lotteryGameTab, personTab);
        guessingGameTab.showPrizeTab();

        StackPane layout = new StackPane();
        layout.getChildren().addAll(tabPane);
        
        Scene scene = new Scene(layout, windowWidth, windowHeight);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}