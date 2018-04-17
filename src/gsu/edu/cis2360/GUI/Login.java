package gsu.edu.cis2360.GUI;

import java.awt.Color;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;


public class Login extends Application {
		@Override
		public void start(Stage primaryStage) {

			// create GridPane object
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(10);
			grid.setVgap(10);
			// forces the login & password box to stay centered
			Scene scene = new Scene(grid, 325, 275);
			primaryStage.setScene(scene);
			primaryStage.show();

			Text scenetitle = new Text("Welcome");
			scenetitle.setFont(Font.font(10));

			Label userName = new Label("User Name: ");
			grid.add(userName, 0, 1);

			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);

			Label pw = new Label("Password: ");
			grid.add(pw, 0, 2);

			// creates a specialized password input box that hides the password
			// input
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);

			Button btn = new Button("Login");
			HBox hbBtn = new HBox(10);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);

			// adds location for text to appear if login fails
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);

		}
		
		
		
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
}