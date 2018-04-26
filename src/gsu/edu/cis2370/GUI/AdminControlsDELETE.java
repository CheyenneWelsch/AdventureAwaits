package gsu.edu.cis2370.GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.Dialog;
import gsu.edu.cis2370.RUNTIME.ValueObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

public class AdminControlsDELETE extends Application{
	
	Label sceneTitle = new Label("Delete Flights");
	Label flightNum = new Label("Flight#");
	Label fromAir = new Label("F.Air");
	Label toAir = new Label("T.Air");
	Label departDate = new Label("D.Date");
	Label departTime = new Label("D.Time");
	Label arriveDate = new Label("A.Date");
	Label arriveTime= new Label("A.Time");
	Label currentCapacity = new Label("CurrentSeat");
	Label maxCapacity = new Label("MaxSeat");
	Label txtAddFlight = new Label("Enter the flight number you wish to remove from the system:");

	//Bottom Row
	Label txtFlightNum = new Label("Flight Number");
	Label txtFrom = new Label("From Airport");
	Label txtTo = new Label("To Airport");
	Label txtDepartDate = new Label("Departure Date");
	Label txtArrivalDate = new Label("Arrival Date");
	Label txtDepartTime = new Label("Departure Time");
	Label txtArriveTime = new Label("Arrival Time");
	Label txtCurrentCapacity = new Label("Current Capacity");
	Label txtMaxCapacity = new Label("Max Capacity");
	
	
	Button btnAddFlight = new Button("Add Flight");
	Button btnDeleteFlight = new Button("Delete Flight");
	Button btnEditFlight = new Button("Edit Flight");
	Button btnBack = new Button("Main Menu");

	
	TextField flightNumBOX = new TextField();
	TextField fromBOX = new TextField();
	TextField toBOX = new TextField();
	TextField departDateBOX = new TextField("00/00/0000");
	TextField arrivalDateBOX = new TextField("00/00/0000");
	TextField fromTime = new TextField("00:00");
	TextField toTime = new TextField("00:00");
	TextField fldCurrentCapacity = new TextField();
	TextField fldMaxCapacity = new TextField();
	
		@Override
		public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
			
			HBox hBoxTitle = new HBox(20);
			hBoxTitle.getChildren().addAll(sceneTitle);
			hBoxTitle.setAlignment(Pos.CENTER);
			
			GridPane grid = new GridPane();
			grid.add(flightNum, 0, 1);
			grid.add(fromAir, 1, 1);
			grid.add(toAir, 2, 1);
			grid.add(departDate, 3, 1);
			grid.add(arriveDate, 4, 1);
			grid.add(departTime, 5, 1);
			grid.add(arriveTime, 6, 1);
			grid.add(currentCapacity, 7, 1);
			grid.add(maxCapacity, 8, 1);
			
			ValueObject vo = new ValueObject();
			ArrayList<String> s1 = vo.getFlightTable();
			
			TextArea textArea = new TextArea();
			String [] hold = vo.arrayListToString(s1);
			int count = 0;
			//String heading = "Flt   fAir      toAir  aDate  aTime  dDate  dTime  CurentrSeats  MaxSeats\n";
			//textArea.appendText(heading);
			//for loop that prints text in a text box
			for(int x = 0; x< vo.flightList(); x++){
				textArea.appendText(hold[x] + "\n");
				//textArea.appendText(s1.toString());
				//vo.getFlightTable().get(x);
			}
			
			textArea.setMinWidth(475);
			grid.setAlignment(Pos.CENTER);
			grid.add(textArea, 0, 2, 9, 1);
			grid.add(txtAddFlight, 0, 3);
			grid.setHgap(15);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			
			GridPane gridBtm = new GridPane();
			gridBtm.setHgap(10);
			gridBtm.setVgap(10);
			gridBtm.setPadding(new Insets(25, 25, 25, 25));
			
			
			gridBtm.add(txtAddFlight, 0, 0, 3, 1);
			gridBtm.add(txtFlightNum, 0, 1);
			gridBtm.add(flightNumBOX, 1, 1, 3, 1);
			gridBtm.add(btnDeleteFlight, 0, 6, 4, 1);
			btnDeleteFlight.setMinWidth(330);
			
			gridBtm.add(btnBack, 0, 8);
			btnBack.setMinWidth(100);
			gridBtm.add(btnEditFlight, 1, 8);
			btnEditFlight.setMinWidth(100);
			gridBtm.add(btnAddFlight, 2, 8);
			btnAddFlight.setMinWidth(100);
			
			gridBtm.setAlignment(Pos.CENTER);
			gridBtm.setPadding(new Insets(25, 25, 25, 25));
			gridBtm.setHgap(10);
			gridBtm.setVgap(10);
			
			VBox vbox = new VBox(20);
			Scene sceneText = new Scene(vbox, 700, 700);
			vbox.getChildren().addAll(hBoxTitle,grid, gridBtm);
			vbox.setAlignment(Pos.CENTER);
			primaryStage.setTitle("Delete Flights"); //set title
			primaryStage.setScene(sceneText);
			primaryStage.show();
			
			//deletes a flight from the system based on the flight number
			btnDeleteFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					ValueObject vc = new ValueObject();
					
					
					try{
						int flight = Integer.parseInt(flightNumBOX.getText());
					vc.deleteSystemFlight(flight);
					AdminControlsDELETE acd = new AdminControlsDELETE();
					acd.start(primaryStage);
					
					}catch(SQLException | ClassNotFoundException n){
						System.out.println(n);
					}
				}
			});
			
			
			
			
			btnAddFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					try {
						AdminControlsADD aca = new AdminControlsADD();
						aca.start(primaryStage);
					} catch (SQLException | ClassNotFoundException n) {
						System.out.println(n);
					}
				}
			});

			btnEditFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					try {
						AdminControlsEDIT ace = new AdminControlsEDIT();
						ace.start(primaryStage);
					} catch (SQLException | ClassNotFoundException n) {
						System.out.println(n);
					}
				}
			});
			
			
			

			// go back to main menu and use temp access table to determine which menu to load
			btnBack.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					try{
					if(vo.showTempUserAccess().equals("A")){
						mainAdmin adminMenu = new mainAdmin();
						adminMenu.start(primaryStage);
					}else{
						mainCustomer customerMenu = new mainCustomer();
						customerMenu.start(primaryStage);
					}
					}catch(SQLException | ClassNotFoundException c){
						System.out.println(c);
					}
					
				}
			});
		
		
		
		
		
		// create a new scene and place it on stage
		
	}
	
	
	
	
	public static void main(String[]args){
		Application.launch(args);
	}
	
	
}
