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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;


public class Search extends Application {

	Label airport = new Label("Airport");
	Label from = new Label("From City");
	Label to = new Label("To City");
	//Label fromCity = new Label("Departure City");
	Label departDate = new Label("Departure Date");
	Label arrivalDate = new Label("Arrival Date");
	
	
	TextField airportBOX = new TextField();
	TextField fromBOX = new TextField();
	TextField toBOX = new TextField();
	//TextField fromCityBOX = new TextField();
	TextField departDateBOX = new TextField();
	TextField arrivalDateBOX = new TextField();

	Button btnSearch = new Button("Search");
	Button btnBack = new Button("Go Back");
	Text scenetitle = new Text ("Search for a Flight");
	Text title = new Text ("Search Flights");
	@Override
	public void start(Stage primaryStage) {

		// create GridPane object
		GridPane grid = new GridPane();
		grid.add(scenetitle, 0, 0);
	
		//grid.add(name, columnIndex, rowIndex, colSpan, rowSpan)
		
		grid.add(airport, 0, 1);
		grid.add(airportBOX, 1, 1, 3, 1);
		grid.add(from, 0, 2);
		grid.add(fromBOX, 1, 2);
		grid.add(to, 2, 2);
		grid.add(toBOX, 3, 2);
		grid.add(departDate, 0, 3);
		grid.add(departDateBOX, 1, 3);
		grid.add(arrivalDate, 2, 3);
		grid.add(arrivalDateBOX, 3, 3);
		
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);
		

		//HBox creates items in a horizontal row
		HBox hbBtn = new HBox(20);
		hbBtn.getChildren().addAll(btnBack, btnSearch);
		grid.add(btnBack, 0, 5);
		grid.add(btnSearch, 1,5, 3, 1);
		btnBack.setMinWidth(100);
		btnSearch.setMinWidth(550);
		
		
		
		
		// create a new scene and place it on stage
		Scene scene = new Scene(grid, 750, 550);
		primaryStage.setTitle("Login"); //set title
		primaryStage.setScene(scene);
		primaryStage.show();
	
		
		//btn.setOnAction(e -> textGrab(userTextField.getText(), pwBox.getText()) );
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				mainAdmin adminMenu = new mainAdmin();
		       adminMenu.start(primaryStage);
		    }
		});
		
		
		
	
		// adds location for text to appear if login fails
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

	}
	
	private void textGrab(String user, String pass){
		System.out.println("Username: " + user + "\nPassword: " + pass);
	}
	
public static void main(String[]args){
	Application.launch(args);
}


}
