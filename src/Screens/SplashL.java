package Screens;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;

	
public class SplashL extends Application {
	public static final String APPLICATION_ICON = 
	    		"https://n6-img-fp.akamaized.net/free-vector/time-to-travel_23-2147514516.jpg?size=338&ext=jpg";
	public static final String SPLASH_IMAGE =
	    		"https://www.blabloom.com/images/products/overview/vliegtuig-janod-1.jpg";

	    private Pane splashLayout;
	    private ProgressBar loadProgress;
	    private Label progressText;
	    //private Stage mainStage;
	    private static final int SPLASH_WIDTH = 600; //Splash Screen conditional to image size
	    private static final int SPLASH_HEIGHT = 600; //Splash Screen conditional to image size

	 public static void main(String[] args) throws Exception {
	        launch(args);
	    }

	    @Override
	    //initialize 
	 public void init() { //design of splash
	        ImageView splash = new ImageView(new Image(SPLASH_IMAGE)); //creates new image view object using defined Splash_Image from
	        loadProgress = new ProgressBar();
	        loadProgress.setPrefWidth(SPLASH_WIDTH); //with
	        progressText = new Label("Finding your adventure . . .");
	        splashLayout = new VBox();
	        splashLayout.getChildren().addAll(splash, loadProgress, progressText);
	        progressText.setAlignment(Pos.CENTER);
	        splashLayout.setStyle(
	                "-fx-padding: 5; " +
	                "-fx-background-color: white;" +
	                "-fx-border-width:5; " +
	                "-fx-border-color: " +
	                    "linear-gradient(" +
	                        "to bottom, " +
	                        "indigo, " +
	                        "derive(indigo, 75%)" +
	                    ");"
	        );
	        splashLayout.setEffect(new DropShadow());
	    }

	    @Override
	    public void start(final Stage initStage) throws Exception {
	        final Task<ObservableList<String>> adventureTask = new Task<ObservableList<String>>() {
	            @Override
	            protected ObservableList<String> call() throws InterruptedException {
	                ObservableList<String> newAdventure =
	                        FXCollections.<String>observableArrayList();
	                ObservableList<String> availableAdventures =
	                        FXCollections.observableArrayList(
	                                "Denver, Colorado", "San Fransico, California", "Atlanta, Georgia", "Boulder, Colorado", "Chicago, Illinois",
	                                "Berlin, Germany", "Venice, Italy", "Little Rock, Arkansas", "LausAnne, Switzerland",
	                                "Frankfurt, Germany", "Paris, France", "Budapest, Hungary", "Tampa, Florida"
	                        );

	                updateMessage("Finding your adventure . . .");
	                for (int i = 0; i < availableAdventures.size(); i++) {
	                    Thread.sleep(400);
	                    updateProgress(i + 1, availableAdventures.size());
	                    String nextAdventure = availableAdventures.get(i);
	                    newAdventure.add(nextAdventure);
	                    updateMessage("Finding your adventure " + nextAdventure);
	                }
	                Thread.sleep(400);
	                updateMessage("Possible Adventures Found!");

	                return newAdventure;
	            }
	        };

	        showSplash(
	                initStage,
	                adventureTask,
	                () -> showMainStage(adventureTask.valueProperty())
	        );
	        new Thread(adventureTask).start(); //used to add text to splash screen & get it to fade out
	    }

	    private void showMainStage(
	            ReadOnlyObjectProperty<ObservableList<String>> adventure
	    ) {
	    	/*
	    	 * creates follow-up screen (mainStage) with a list of places.
	    	 * We can use this as a basis for the login screen
	        mainStage = new Stage(StageStyle.DECORATED);
	        mainStage.setTitle("My adventures");
	        mainStage.getIcons().add(new Image(
	                APPLICATION_ICON
	        ));

	        final ListView<String> adventureView = new ListView<>();
	        adventureView.itemsProperty().bind(adventure);

	        mainStage.setScene(new Scene(adventureView));
	        mainStage.show();
	        */
	    }

	    private void showSplash(
	            final Stage initStage,
	            Task<?> task,
	            InitCompletionHandler initCompletionHandler
	    ) {
	        progressText.textProperty().bind(task.messageProperty());
	        loadProgress.progressProperty().bind(task.progressProperty());
	        task.stateProperty().addListener((observableValue, oldState, newState) -> {
	            if (newState == Worker.State.SUCCEEDED) {
	                loadProgress.progressProperty().unbind();
	                loadProgress.setProgress(1);
	                initStage.toFront();
	                FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
	                fadeSplash.setFromValue(1.0);
	                fadeSplash.setToValue(0.0);
	                fadeSplash.setOnFinished(actionEvent -> initStage.hide());
	                fadeSplash.play();

	                initCompletionHandler.complete();
	            } 
	        });

	        Scene splashScene = new Scene(splashLayout, Color.TRANSPARENT);
	        final Rectangle2D bounds = Screen.getPrimary().getBounds();
	        initStage.setScene(splashScene);
	        //Does not effect adventure list
	        //initStage.setWidth(SPLASH_WIDTH + 500);
	        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
	        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
	        initStage.initStyle(StageStyle.TRANSPARENT);
	        initStage.setAlwaysOnTop(true);
	        initStage.show();
	    }

	    public interface InitCompletionHandler {
	        void complete();
	    }
}
