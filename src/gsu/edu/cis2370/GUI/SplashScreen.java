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
		
	
	
		
		Text scenetitle = new Text("Adventure Awaits");
		Label applicationSlogan = new Label("Changing the way you fly!");
		
public void start(Stage primaryStage) {

	// create GridPane object
	GridPane grid = new GridPane();
	grid.add(scenetitle, 0, 0);

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