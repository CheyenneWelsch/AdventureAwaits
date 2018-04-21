package gsu.edu.cis2360.GUI;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class cancelFlight extends Application{

	

	Text txtHeading = new Text("Select a flight you wish to cancel:");
	Button btnCancel = new Button("Cancel a Flight");
	Button btnMenu = new Button("Main Menu");
	Button btnLogout = new Button("Log Out");
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(35, 35, 35, 35));
		grid.setHgap(10);
		grid.setVgap(10);
		
		
		grid.add(txtHeading, 0, 0);
	
		grid.add(btnCancel, 0, 2);
		grid.add(btnMenu,2 , 2);
		grid.add(btnLogout, 0, 4, 3 ,1);

		
		
		
		btnCancel.setMinWidth(200);
		btnMenu.setMinWidth(200);
		btnLogout.setMinWidth(200);
		
	
		
		btnMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				mainAdmin test = new mainAdmin();
				test.start(primaryStage);
		    }
		});
	
		// create a new scene and place it on stage
				Scene scene = new Scene(grid, 325, 400);
				primaryStage.setTitle("Flight Cancel"); //set title
				primaryStage.setScene(scene);
				primaryStage.show();
	}
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
}
