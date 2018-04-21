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


public class mainAdmin extends Application {

	
	Button btnBook = new Button("Book a Flight");
	Button btnCancel = new Button("Cancel a Flight");
	Button btnSearch = new Button("Search Flights");
	Button btnMyFlights= new Button("View My Flights");
	Button btnAddFlight = new Button("Add Flights");
	Button btnDeleteFlight = new Button("Delete Flights");
	Button btnEditFlight = new Button("Edit Flights");
	Text txtAdmin = new Text("Admin Tools");
	
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
		grid.add(txtAdmin, 0, 6);
		grid.add(btnAddFlight, 0, 7);
		grid.add(btnEditFlight, 0, 8);
		grid.add(btnDeleteFlight, 0, 9);
		grid.add(btnLogout, 0, 11);
		
		
		
		btnMyFlights.setMinWidth(200);
		btnSearch.setMinWidth(200);
		btnBook.setMinWidth(200);
		btnCancel.setMinWidth(200);
		btnAddFlight.setMinWidth(200);
		btnDeleteFlight.setMinWidth(200);
		btnLogout.setMinWidth(200);
		btnEditFlight.setMinWidth(200);
	
		/*
		btnMyFlights.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				listTEST list = new listTEST();
				list.start(primaryStage);
		    }
		});
		*/
		
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				Search test = new Search();
				test.start(primaryStage);
		    }
		});
	
		
		btnLogout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				Login test = new Login();
				test.start(primaryStage);
		    }
		});
		
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent e) {
				Login test = new Login();
				test.start(primaryStage);
		    }
		});
		
		
		/*	class not made yet
		 * btnBook.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent e) {
					bookingTEST book = new bookingTEST();
					book.start(primaryStage);
			    }
			});
			*/
		
		
		/*	class not made yet
		 * btnCencel.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent e) {
					cancelFlightTEST cancel = new cancelFlightTEST();
					cancel.start(primaryStage);
			    }
			});
			*/
		
		
		
		
		// create a new scene and place it on stage
		Scene scene = new Scene(grid, 325, 400);
		primaryStage.setTitle("Main Menu"); //set title
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
}
