package gsu.edu.cis2370.GUI;
import java.util.Date;

import java.time.LocalDate;
import java.time.LocalTime;

import gsu.edu.cis2370.RUNTIME.Flight;
import gsu.edu.cis2370.GUI.mainAdmin;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;



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
			new Flight(002, "NYC", "02/01/2018", 1000, "02/02/2018", 130),
			new Flight(003, "LAX", "03/01/2018", 1000, "03/02/2018", 1000)
		);
	
	Flight f1 = new Flight();
	
	
	private TableView table = new TableView();

	public static void main(String[] args) {
		launch(args);
	}

	final HBox hb = new HBox();
	
	final HBox backBox = new HBox();
	
	@Override
	public void start(Stage stage) throws Exception {
		
		
		
		Scene scene = new Scene(new Group());
		stage.setTitle("List of Flights");
		stage.setWidth(550);
		stage.setHeight(700);
		
		
		
		
		final Label label = new Label("Flights");
		label.setFont(new Font("Arial", 20));
		
		
		table.setEditable(true);
		
		TableColumn flightID = new TableColumn("Flight ID");
		flightID.setMinWidth(100);
		flightID.setCellValueFactory(
                new PropertyValueFactory<>("flightID"));
		
		
		TableColumn airport = new TableColumn("Airport");
		airport.setMinWidth(100);
		airport.setCellValueFactory(
                new PropertyValueFactory<>("fromAirport"));
		airport.setCellFactory(TextFieldTableCell.forTableColumn());
		airport.setOnEditCommit(
				new EventHandler<CellEditEvent<Flight, String>>(){
					@Override
					public void handle(CellEditEvent<Flight, String> t) {
						((Flight) t.getTableView().getItems().get(
								t.getTablePosition().getRow())
								).setFromAirport(t.getNewValue());
					}
				}
	);
					
				
		
		
		TableColumn departure = new TableColumn("Departures");
		TableColumn firstDepartureCol = new TableColumn ("Date");
		firstDepartureCol.setMinWidth(50);
		firstDepartureCol.setCellValueFactory(
                new PropertyValueFactory<>("departureDate"));
		
		
		TableColumn secondDepartureCol = new TableColumn ("Time");
		secondDepartureCol.setMinWidth(50);
		secondDepartureCol.setCellValueFactory(
                new PropertyValueFactory<>("departureTime"));
		
		TableColumn arrival = new TableColumn("Arrivals");
		TableColumn firstArrivalCol = new TableColumn ("Date");
		firstArrivalCol.setMinWidth(50);
		firstArrivalCol.setCellValueFactory(
                new PropertyValueFactory<>("arrivalDate"));
		
		TableColumn secondArrivalCol = new TableColumn ("Time");
		secondArrivalCol.setMinWidth(50);
		secondArrivalCol.setCellValueFactory(
                new PropertyValueFactory<>("arrivalTime"));
		
		//creates a nested column in the selected TableColumn objects
		departure.getColumns().addAll(firstDepartureCol, secondDepartureCol);
		arrival.getColumns().addAll(firstArrivalCol, secondArrivalCol);
		
		
		
		
		
		//create a table of all of the TableColumn objects
		table.setItems(data);
		table.getColumns().addAll(flightID, airport, departure, arrival);
	
	
		final TextField addflightID = new TextField();
		addflightID.setPromptText("Flight ID");
		addflightID.setMaxWidth(flightID.getPrefWidth());

		final TextField addAirport = new TextField();
		addAirport.setMaxWidth(airport.getPrefWidth());
		addAirport.setPromptText("Airport");

		final TextField addDepartTime = new TextField();
		addDepartTime.setMaxWidth(firstDepartureCol.getPrefWidth());
		addDepartTime.setPromptText("Depart Time");
		
		final TextField addDepartDate = new TextField();
		addDepartDate.setMaxWidth(secondDepartureCol.getPrefWidth());
		addDepartDate.setPromptText("Depart Date");
		
		final TextField addArriveTime = new TextField();
		addArriveTime.setMaxWidth(firstArrivalCol.getPrefWidth());
		addArriveTime.setPromptText("Arrive Time");
		
		final TextField addArriveDate = new TextField();
		addArriveDate.setMaxWidth(secondArrivalCol.getPrefWidth());
		addArriveDate.setPromptText("Arrive Date");
		 
		final Button addButton = new Button("Add");
		addButton.setOnAction((ActionEvent e) -> {
			
			
			data.add(new Flight(
		        Integer.parseInt(addflightID.getText()),
		        addAirport.getText(),
		        addDepartDate.getText(),
		        Integer.parseInt(addDepartTime.getText()),
		        addArriveDate.getText(),
		        Integer.parseInt(addArriveTime.getText())
		    ));
		    addflightID.clear();
	        addAirport.clear();
	        addDepartDate.clear();
	        addDepartTime.clear();
	        addArriveDate.clear();
	        addArriveTime.clear();
		});
		
		//assigns the text fields and button to the horizontal box
				hb.getChildren().addAll(addflightID, addAirport, addDepartDate, addDepartTime, addArriveDate, addArriveTime, addButton);
				hb.setSpacing(3);
				
		
		Button backButton = new Button("Back");
		backButton.setOnAction((ActionEvent e) -> {
			mainAdmin main = new mainAdmin();
			main.start(stage);
		});
		
	
		
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction((ActionEvent e) -> {
			Flight selectedItem = (Flight) table.getSelectionModel().getSelectedItem();
			table.getItems().remove(selectedItem);
			
		});
		
		backBox.getChildren().addAll(backButton, deleteButton);
		backBox.setSpacing(3);
		
		VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		//tells vertial box to add the label, then the table, then the horizontal box
		vbox.getChildren().addAll(label, table, hb, backBox);
		
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		
		stage.setScene(scene);
		stage.show();
	
	}

}