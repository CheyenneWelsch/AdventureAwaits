package gsu.edu.cis2370.GUI;

import java.sql.SQLException;

import gsu.edu.cis2370.RUNTIME.ValueObject;
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
import javafx.scene.paint.Paint;


public class mainCustomer extends Application{

	
	Button btnBook = new Button("Book a Flight");
	Button btnCancel = new Button("Cancel a Flight");
	Button btnSearch = new Button("Search Flights");
	Button btnMyFlights= new Button("View My Flights");
	Button btnLogout = new Button("Log Out");
	
	
	@Override
	public void start(Stage primaryStage) {
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(35, 35, 35, 35));
		grid.setHgap(10);
		grid.setVgap(10);
		
		
		
		grid.add(btnMyFlights, 0, 1);
		grid.add(btnSearch, 0, 2);
		grid.add(btnBook, 0, 3);
		grid.add(btnCancel, 0 ,4);
		grid.add(btnLogout, 0, 6);
		
		
		
		btnMyFlights.setMinWidth(200);
		btnSearch.setMinWidth(200);
		btnBook.setMinWidth(200);
		btnCancel.setMinWidth(200);
		btnLogout.setMinWidth(200);
	

		btnLogout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				ValueObject vc = new ValueObject();
				try{
				vc.deleteTempTable();
				}catch(SQLException | ClassNotFoundException l) {
					System.out.println(l);
				}
				Login test = new Login();
				test.start(primaryStage);
		    }
		});
		
		
		
		
		// create a new scene and place it on stage
		Scene scene = new Scene(grid, 325, 300);
		primaryStage.setTitle("Main Menu"); //set title
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
}
