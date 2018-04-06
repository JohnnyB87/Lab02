import controllers.PersonPane;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class GameTab extends Tab{

	private static PrizeTab prizeTab;
  	private BorderPane pane = new BorderPane();
    private Button exit = new Button();
    private Button reset = new Button();
    private Button guess = new Button();
    private Pane ps;
    private Alert alert;

    public GameTab(String title, String buttonName, String colour) {

        prizeTab = new PrizeTab(colour);
        this.setText(title);
        prizeTab.setDisable(true);
        
        exit.setText("Exit");
        reset.setText("Reset");
        guess.setText(buttonName);

        TilePane tileButtons = new TilePane(Orientation.HORIZONTAL);
        tileButtons.setBackground(new Background(new BackgroundFill(Color.web(colour),CornerRadii.EMPTY,Insets.EMPTY)));
        tileButtons.setAlignment(Pos.CENTER);
        tileButtons.setHgap(5.0);
//        tileButtons.setVgap(8.0);
        tileButtons.setMinHeight(75);

        int buttonWidth = 60;
        setButtonsSize(buttonWidth);

        tileButtons.getChildren().addAll(guess, reset, exit);

        this.pane.setBottom(tileButtons);
        this.setContent(this.pane);
        
        if(this.getTabPane() != null)
        	this.getTabPane().getTabs().add(prizeTab);

        exit.setOnAction(e -> exitGame());

    }

    //------------------------------------
    //			GETTERS
    //------------------------------------

    public Button getExitButton() {
        return exit;
    }

    public Button getResetButton() {
        return reset;
    }

    public Button getGuessButton() {
        return guess;
    }

	public PrizeTab getPrizeTab() {
		return prizeTab;
	}

    public Alert getAlert() {
        return alert;
    }

    //------------------------------------
    //			SETTERS
    //------------------------------------

	public void setButtonsSize(int buttonWidth) {
		this.guess.setMinWidth(buttonWidth);
        this.guess.setMaxWidth(buttonWidth);
        this.exit.setMinWidth(buttonWidth);
        this.exit.setMaxWidth(buttonWidth);
        this.reset.setMinWidth(buttonWidth);
        this.reset.setMaxWidth(buttonWidth);
	}

    public void addPane(Node node){
        this.pane.setCenter(node);
    }

    public void showPrizeTab() {
    	if(this.getTabPane() != null)
    		this.getTabPane().getTabs().add(prizeTab);
    	else 
    		System.out.println("ERROR: No TAbPAne to add to.");
    }
    
    //------------------------------------
    //			EXTRA FUNCTIONALITY
    //------------------------------------
    
    public void resetGame() {
        this.alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure you want to reset the game.\nAll current progress will be lost?"
                , ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
    }

    public void exitGame() {
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

    public void winner(int stars) throws Exception{
        setWinnerAlertBox(stars);
        createStage();
        this.exit.setDisable(true);
        this.reset.setDisable(true);
        
        prizeTab.setDisable(false);
    }

    public void createStage() throws Exception{
        this.ps = FXMLLoader.load(getClass().getResource("resources/PersonTab.fxml"));
        StackPane sp = new StackPane();
        sp.getChildren().add(this.ps);
        Scene scene = new Scene(sp,350,300);
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Enter Details");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initOwner(Main.getPrimaryStage());
        stage.showAndWait();
    }

    public void loser() {
//    	this.getTabPane().getTabs().add(prizeTab);
    	prizeTab.setDisable(true);
    }

    public void setWinnerAlertBox(int star){
        this.alert = new Alert(Alert.AlertType.INFORMATION,
                String.format("CONGRATULATIONS\nYou Win a %d star prize.",star),ButtonType.OK);
        this.alert.showAndWait();
    }
    
    //------------------------------------
    //			ABSTRACT METHODS
    //------------------------------------

    public abstract void run(String s);

    public abstract void checkResult(int n);
}