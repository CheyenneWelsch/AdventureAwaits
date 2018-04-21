package gsu.edu.cis2360.GUI;
import java.util.Date;

import java.time.LocalDate;
import java.time.LocalTime;

import gsu.edu.cis2370.RUNTIME.Flight;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class flightListAdmin extends Application {

	/*
	LocalDate a1 = LocalDate.of(2019, 02, 20);
	LocalDate a2 = LocalDate.of(2019, 02, 21);
	LocalDate b1 = LocalDate.of(2019, 04, 20);
	LocalDate b2 = LocalDate.of(2019, 04, 21);
	LocalDate c1 = LocalDate.of(2018, 10, 01);
	LocalDate c2 = LocalDate.of(2018, 10, 01);
	
	LocalTime ta1 = LocalTime.of(6, 30);
	LocalTime ta2 = LocalTime.of(8, 30);
	LocalTime tb1 = LocalTime.of(10, 00);
	LocalTime tb2 = LocalTime.of(11, 30);
	LocalTime tc1 = LocalTime.of(1, 00);
	LocalTime tc2 = LocalTime.of(5, 30);
	 */
	

	//private Flight (int flightID, String fromAirport, String departureDate, int departureTime, String arrivalDate, int arrivalTime){
	//Defining Table Data
	final ObservableList<Flight> data = FXCollections.observableArrayList(
			new Flight(001, "ATL", "01/01/2018", 1000, "01/02/2018", 0130),
			new Flight(002, "NYC", "02/01/2018", 1000, "02/02/2018", 0130),
			new Flight(003, "LAX", "03/01/2018", 1000, "03/02/2018", 0130)
		);
	
	Flight f1 = new Flight();
	
	
	private TableView table = new TableView();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new Group());
		stage.setTitle("List of Flights");
		stage.setWidth(500);
		stage.setHeight(700);
		
		final Label label = new Label("Flights");
		label.setFont(new Font("Arial", 20));
		
		
		table.setEditable(true);
		
		TableColumn flightID = new TableColumn("Flight ID");
		flightID.setMinWidth(100);

		
		TableColumn airport = new TableColumn("Airport");
		airport.setMinWidth(100);
		airport.setCellValueFactory(
                new PropertyValueFactory<Flight, String>("Airport"));
		
		
		TableColumn departure = new TableColumn("Departures");
		TableColumn firstDepartureCol = new TableColumn ("Date");
		TableColumn secondDepartureCol = new TableColumn ("Time");
		TableColumn arrival = new TableColumn("Arrivals");
		TableColumn firstArrivalCol = new TableColumn ("Date");
		TableColumn secondArrivalCol = new TableColumn ("Time");
		
		//create a table of all of the TableColumn objects
		table.setItems(data);
		table.getColumns().addAll(flightID, airport, departure, arrival);
	
		//creates a nested column in the selected TableColumn objects
		departure.getColumns().addAll(firstDepartureCol, secondDepartureCol);
		arrival.getColumns().addAll(firstArrivalCol, secondArrivalCol);
		
		
		
		
		
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);
		
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		
		stage.setScene(scene);
		stage.show();
	
	}

}