package gsu.edu.cis2370.GUI;

import java.sql.SQLException;
import java.util.ArrayList;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;

public class flightListCustomer extends Application{

	Label flightNum = new Label("Flight #");
	Label fromAir = new Label("From Airport");
	Label toAir = new Label("To Airport");
	Label departDate = new Label("Departure Date");
	Label departTime = new Label("Departure Time");
	Label arriveDate = new Label("Arrival Date");
	Label arriveTime= new Label("Arrival Time");
	Label currentCapacity = new Label("Current Capacity");
	Label maxCapacity = new Label("Max Capacity");
	
	Label sceneTitle = new Label("Search Results");
	Button btnBook = new Button("Book a Flight");
	Button btnCancel = new Button("Cancel a Flight");
	Button btnSearch = new Button("Search Flights");
	Button btnMyFlights= new Button("View My Flights");
	Button btnLogout = new Button("Log Out");
	

		@Override
		public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
			
			GridPane grid = new GridPane();
			grid.add(sceneTitle, 0, 0);
			grid.add(flightNum, 0, 1);
			grid.add(fromAir, 1, 1);
			grid.add(toAir, 2, 1);
			grid.add(departDate, 3, 1);
			grid.add(departTime, 4, 1);
			grid.add(arriveDate, 5, 1);
			grid.add(arriveTime, 6, 1);
			grid.add(currentCapacity, 7, 1);
			grid.add(maxCapacity, 8, 1);
			
			grid.setAlignment(Pos.CENTER);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(10);
			grid.setVgap(10);
			
			ValueObject vo = new ValueObject();
			ArrayList<String> s1 = vo.getFlightTable();
			TextArea textArea = new TextArea();
			String [] hold = vo.arrayListToString(s1);
			int count = 0;
			
			//for loop that prints text in a text box
			for(int x = 0; x< vo.flightList(); x++){
				textArea.appendText(hold[x] + "\n");
			}
		

				
			grid.setAlignment(Pos.CENTER);
			
			VBox vbox = new VBox(20);
			Scene sceneText = new Scene(vbox, 600, 700);
			vbox.getChildren().addAll(grid, textArea);
			vbox.setAlignment(Pos.CENTER);
			primaryStage.setTitle("Flight List"); //set title
			primaryStage.setScene(sceneText);
			primaryStage.show();

			
	
		
		
		
		
		
		// create a new scene and place it on stage
		
	}
	
	
	
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
	
}
