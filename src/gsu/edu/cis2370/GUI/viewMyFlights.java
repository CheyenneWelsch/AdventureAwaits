package gsu.edu.cis2370.GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import gsu.edu.cis2370.RUNTIME.ValueObject;
import gsu.edu.cis2370.DATABASE.TESTCLASS;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class viewMyFlights extends Application {

	Label sceneTitle = new Label("My Flights");

	TextField fldDeleteFlight = new TextField();
	
	Button btnDelete = new Button("Delete Flight");
	Button btnBack = new Button("Main Menu");
	
	Label txtMyFlights = new Label("My Flights");
	Label txtDelete = new Label("Delete Flight:");
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
		ValueObject vo = new ValueObject();
		GridPane grid = new GridPane();
		
		
		TextArea textArea = new TextArea();
		
		try {

			ArrayList<String> myFlights = vo.getMyFlights(vo.showTempUserName());
		
			//creates a String arry from ArrayList using the size of the myFlights ArrayList
			//will be used to print the flights in a text area
			
			String[] myList = myFlights.toArray(new String[myFlights.size()]);
			
			System.out.println(vo.showTempUserName());
			//creates an int value to use to print a new line every 6 string objects
			int newLine = 0;
			for (int x = 0; x < myList.length; x++) {
				textArea.appendText(myList[x]);
				
				if (newLine != 0 && newLine % 6 == 0) {
					textArea.appendText("\n");
					//set to -1 so when this if statement ends, newLine int can go back to the original starting point of 0
					newLine = -1;
				}
				newLine++;
			}
			grid.add(txtMyFlights, 0, 0);
			grid.add(textArea, 0, 1, 4, 1);
			grid.add(txtDelete, 0, 2);
			grid.add(fldDeleteFlight, 1, 2);
			grid.add(btnDelete, 1,3);
			grid.add(btnBack, 0, 4);
		} catch (SQLException | ClassNotFoundException s) {
			System.out.println(s);
		}
		
		//Scene(object, horizontal, vertical)
		Scene scene = new Scene(grid, 625, 400);
		primaryStage.setTitle("My Flights"); //set title
		primaryStage.setScene(scene);
		primaryStage.show();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);

		
		//actions for delete button
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			ValueObject vo = new ValueObject();
			@Override
			public void handle(ActionEvent e) {
				try {
					int deletingNumber = Integer.parseInt(fldDeleteFlight.getText());
					vo.deleteUserFlight(deletingNumber, vo.showTempUserName());
					viewMyFlights vmf = new viewMyFlights();
					vmf.start(primaryStage);
					
				} catch (SQLException | ClassNotFoundException c) {
					System.out.println(c);
				}
			}
		});

	

		
		
		//actions for back button
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					if (vo.showTempUserAccess().equals("A")) {
						mainAdmin adminMenu = new mainAdmin();
						adminMenu.start(primaryStage);
					} else {
						mainCustomer customerMenu = new mainCustomer();
						customerMenu.start(primaryStage);
					}
				} catch (SQLException | ClassNotFoundException c) {
					System.out.println(c);
				}
			}
		});

	};

	public static void main(String[]args){
		Application.launch(args);
	}
	
}
