package gsu.edu.cis2370.GUI;

import javafx.application.Application;

import javafx.scene.image.Image ;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.image.*;
import java.sql.SQLException;
import javafx.scene.image.ImageView;
import org.w3c.dom.Document;

public class SplashScreen extends Application {
	ProgressBar bar;
	Stage stage;

	
	
	Label userName = new Label("User Name: ");
	Label pw = new Label("Password: ");

	PasswordField pwBox = new PasswordField();
	TextField userTextField = new TextField();
	Text scenetitle = new Text("Adventure Awaits");
	public static final String SPLASH_IMAGE =
    		"https://static1.squarespace.com/static/56899343a2bab852737f4ba1/t/5ae20449352f537925be3c63/1524761678903/?format=300w";
	//[Imgur](https://i.imgur.com/jgea8s5.png)
	@Override
	public void start(Stage primaryStage) {
		 Group root = new Group();
		 Scene scene = new Scene(root, 600, 330, Color.CORNFLOWERBLUE);
		// create GridPane object
		GridPane grid = new GridPane();
		
		ImageView splash = new ImageView(new Image(SPLASH_IMAGE)); 
		
		grid.add(scenetitle, 0, 0);
		
		grid.add(userName, 0, 1);
		grid.add(userTextField, 1, 1);
		grid.add(splash, 0, 2);
		//grid.add(img1, 0, 2);
	
		
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.getChildren().add(new ImageView());
		
		final ImageView imv = new ImageView();
       
        //imv.setImage(img1);

        final HBox pictureRegion = new HBox();
        
        pictureRegion.getChildren().add(imv);
        grid.add(pictureRegion, 0, 2);
        root.getChildren().add(grid);        
     
		
		
		
		
		
		
		//Scene scene = new Scene(grid, 325, 275);
		primaryStage.setTitle("Login"); // set title
		primaryStage.setScene(scene);
		primaryStage.show();
	};
		
		
		
		
		
	public static void main(String [] args){
		
		Application.launch(args);
		
	/*
	Timeline timeline = new Timeline(new KeyFrame(
	        Duration.millis(2500),
	        
	        ae -> doSomething()));
	Login l = new Login();

			timeline.play(l.start());
	*/		
			
	}
}