package gsu.edu.cis2370.GUI;

import java.awt.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;

public class SplashScreen extends Application {
		
		
		
		Label userName = new Label("User Name: ");
		Label pw = new Label("Password: ");
		TextField userTextField = new TextField();
		PasswordField pwBox = new PasswordField();
		Text scenetitle = new Text("Adventure Awaitsssss");
		
		
public void start(Stage primaryStage) {

	// create GridPane object
	GridPane grid = new GridPane();
	grid.add(scenetitle, 0, 0);
	
	grid.add(userName, 0, 1);
	grid.add(userTextField, 1, 1);
	grid.add(pw, 0, 2);
	grid.add(pwBox, 1, 2);
	
	
	grid.setAlignment(Pos.CENTER);
	grid.setPadding(new Insets(25, 25, 25, 25));
	grid.setHgap(10);
	grid.setVgap(10);
	

	
	// create a new scene and place it on stage
				Scene scene = new Scene(grid, 325, 275);
				primaryStage.setTitle("Login"); //set title
				primaryStage.setScene(scene);
				primaryStage.show();

			
				
	}

}