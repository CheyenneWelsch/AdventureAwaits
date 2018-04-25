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

public class flightListAdd extends Application{

	Label flightNum = new Label("Flight#");
	Label fromAir = new Label("F.Air");
	Label toAir = new Label("T.Air");
	Label departDate = new Label("D.Date");
	Label departTime = new Label("D.Time");
	Label arriveDate = new Label("A.Date");
	Label arriveTime= new Label("A.Time");
	Label currentCapacity = new Label("CurrentSeat");
	Label maxCapacity = new Label("MaxSeat");
	
	
	/*
	 * Label flightNum = new Label("Flight #");
	Label fromAir = new Label("From Airport");
	Label toAir = new Label("To Airport");
	Label departDate = new Label("Departure Date");
	Label departTime = new Label("Departure Time");
	Label arriveDate = new Label("Arrival Date");
	Label arriveTime= new Label("Arrival Time");
	Label currentCapacity = new Label("Current Capacity");
	Label maxCapacity = new Label("Max Capacity");
	 */
	
	
	Label sceneTitle = new Label("Search Results");
	
	TextField txtAddFlight = new TextField("Type Flight Number you wish to add");
	Button addFlight = new Button("Add Flight");
	Button btnBack = new Button("Main Menu");

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
			
			
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setAlignment(Pos.CENTER);
			
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
		
			
			
			HBox hBoxControls = new HBox(20);
			hBoxControls.getChildren().addAll(txtAddFlight, addFlight);
			hBoxControls.setPadding(new Insets(25, 25, 25, 25));
			txtAddFlight.minWidth(100);
			
			HBox hBoxText = new HBox(20);
			hBoxText.getChildren().addAll(textArea);
			hBoxText.setPadding(new Insets(25, 25, 25, 25));
			
			
			HBox hbox = new HBox(20);
			hbox.getChildren().addAll(btnBack);
			hbox.setPadding(new Insets(25, 25, 25, 25));
			
			VBox vbox = new VBox(20);
			Scene sceneText = new Scene(vbox, 600, 700);
			vbox.getChildren().addAll(hBoxTitle,grid,hBoxText, hBoxControls, hbox);
			vbox.setAlignment(Pos.CENTER);
			primaryStage.setTitle("Flight List"); //set title
			primaryStage.setScene(sceneText);
			primaryStage.show();

			//adds flight to User account
			addFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					ValueObject vc = new ValueObject();
					
					try{
					String uName = vo.showTempUserName();
					int flightNumber = Integer.parseInt(txtAddFlight.getText());
					vo.bookFlight(flightNumber, uName);
					
					
					
					}catch(SQLException | ClassNotFoundException n){
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
