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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;

public class Search extends Application {

	Label flightNum = new Label("Flight Number");
	Label from = new Label("From Airport");
	Label to = new Label("To Airport");
	// Label fromCity = new Label("Departure City");
	Label departDate = new Label("Departure Date");
	Label arrivalDate = new Label("Arrival Date");
	Label departTime = new Label("Departure Time");
	Label arriveTime = new Label("Arrival Time");

	TextField flightNumBOX = new TextField();
	TextField fromBOX = new TextField();
	TextField toBOX = new TextField();
	// TextField fromCityBOX = new TextField();
	TextField departDateBOX = new TextField("00/00/0000");
	TextField arrivalDateBOX = new TextField("00/00/0000");
	TextField fromTime = new TextField("00:00");
	TextField toTime = new TextField("00:00");

	Button btnSearch = new Button("Search");
	Button btnBack = new Button("Go Back");
	Text scenetitle = new Text("Search for a Flight");
	Text title = new Text("Search Flights");

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		// create GridPane object
		GridPane grid = new GridPane();
		grid.add(scenetitle, 0, 0);

		// grid.add(name, columnIndex, rowIndex, colSpan, rowSpan)
		grid.add(flightNum, 0, 1);
		grid.add(flightNumBOX, 1, 1, 3, 1);
		grid.add(from, 0, 2);
		grid.add(fromBOX, 1, 2);
		grid.add(to, 2, 2);
		grid.add(toBOX, 3, 2);
		grid.add(departDate, 0, 3);
		grid.add(departDateBOX, 1, 3);
		grid.add(arrivalDate, 2, 3);
		grid.add(arrivalDateBOX, 3, 3);

		grid.add(departTime, 0, 4);
		grid.add(fromTime, 1, 4);
		grid.add(arriveTime, 2, 4);
		grid.add(toTime, 3, 4);

		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setHgap(10);
		grid.setVgap(10);

		// HBox creates items in a horizontal row
		HBox hbBtn = new HBox(20);
		hbBtn.getChildren().addAll(btnBack, btnSearch);
		grid.add(btnBack, 0, 6);
		grid.add(btnSearch, 1, 6, 3, 1);
		btnBack.setMinWidth(100);
		btnSearch.setMinWidth(300);

		ValueObject vo = new ValueObject();

		// creates a text box to print flight list
		TextArea textArea = new TextArea();

		// create a new scene and place it on stage
		Scene scene = new Scene(grid, 750, 550);
		primaryStage.setTitle("Search"); // set title
		primaryStage.setScene(scene);
		primaryStage.show();

	
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

		// btn.setOnAction(e -> textGrab(userTextField.getText(),
		// pwBox.getText()) );
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				if (vo.testAirport(fromBOX.getText()) != true && vo.testAirport(toBOX.getText()) != true) {
					Label actiontarget = new Label("INVALID AIRPORT. Enter as Airport code (ex. ATL, NYC, etc)");
					grid.add(actiontarget, 1, 7, 3, 1);

				} else if (vo.testDateFormat(departDateBOX.getText()) != true
						&& vo.testDateFormat(arrivalDateBOX.getText()) != true) {
					Label actiontarget = new Label(
							"INVALID DATE. Enter as MM/DD/YYYY (ex. 12/25/2018, 08/21/2018, etc)");
					grid.add(actiontarget, 1, 7, 3, 1);

				} else if (vo.testTimeFormat(fromTime.getText()) != true
						&& vo.testTimeFormat(toTime.getText()) != true) {
					Label actiontarget = new Label("INVALID TIME. Enter as HH:MM (ex. 12:56, 16:32, etc)");
					grid.add(actiontarget, 1, 7, 3, 1);
				} else {
				

				int fnum = Integer.parseInt(flightNumBOX.getText());
				try {
					ArrayList<String> f1 = vo.searchFlights(fnum, fromBOX.getText(), toBOX.getText(),
							departDateBOX.getText(), arrivalDateBOX.getText(), fromTime.getText(), toTime.getText());

					// converts array list of flights (f1) to a string array to
					// be used to print
					String[] flightResults = f1.toArray(new String[f1.size()]);

					for (int x = 0; x < flightResults.length; x++) {
						textArea.appendText(flightResults[x] + " ");
						if (x != 0 && x % 8 == 0) {
							textArea.appendText("\n");
						}
					}
					grid.add(textArea, 0, 5, 4, 1);

				} catch (SQLException | ClassNotFoundException s) {

				}

			}
			}
		});

	}

	private void textGrab(String user, String pass) {
		System.out.println("Username: " + user + "\nPassword: " + pass);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
