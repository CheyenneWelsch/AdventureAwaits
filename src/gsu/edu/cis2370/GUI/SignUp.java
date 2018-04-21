package gsu.edu.cis2370.GUI;


import gsu.edu.cis2370.RUNTIME.*;
import java.awt.Color;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SignUp extends Application {
		
	//ValueOption vo = new ValueOption();
	//TESTCLASS tc = new TESTCLASS();


	
	// creates a specialized password input box that hides the password
	// input
	
	

	Label userName = new Label("User Name: ");
	Label pw = new Label("Password: ");
	Label pw2 = new Label("Re-enter your password: ");
	Label firstName = new Label("First Name: ");
	Label lastName = new Label("Last Name: ");
	Label ssn = new Label("SSN: ");
	Label address = new Label("Address: ");
	Label city = new Label("City: ");
	Label state = new Label("State: ");
	Label zip = new Label("Zip: ");
	Label country = new Label("Country: ");
	Label securityQ = new Label("Security Question: ");
	Label securityA = new Label("Security Answer: ");
	Label email = new Label("Email: ");
	Label phone = new Label("Phone: ");
	
	Text scenetitle = new Text("ACCOUNT CREATION");
	
	public TextField userTextField = new TextField();
	TextField userNameBOX = new TextField();
	public TextField firstNameBOX = new TextField();
	public TextField lastNameBOX = new TextField();
	public TextField ssnBOX = new TextField();
	public TextField addressBOX = new TextField();
	public TextField cityBOX = new TextField();
	public TextField stateBOX = new TextField();
	public TextField zipBOX = new TextField();
	public TextField countryBOX = new TextField();
	public TextField securityQBOX = new TextField();
	public TextField securityABOX = new TextField();
	public TextField emailBOX = new TextField();
	public TextField phoneBOX = new TextField();
	public PasswordField pwBOX = new PasswordField();
	
	PasswordField pw2BOX = new PasswordField();

	
	
	
	//creates a login button
	Button btnBack = new Button("Go Back");
	Button btnCreate = new Button("Create Account");
	final Text actiontarget = new Text();
	
	@Override
		public void start(Stage primaryStage) {
		
		//ValueObject vo = new ValueObject();	
		
			// create GridPane object
			GridPane grid = new GridPane();
			grid.add(scenetitle, 0, 0);
		
			//grid.add(name, columnIndex, rowIndex, colSpan, rowSpan)
			grid.add(firstName, 0, 1);
			grid.add(firstNameBOX, 1, 1, 3, 1);
			grid.add(lastName, 0, 2);
			grid.add(lastNameBOX, 1, 2, 3, 1);
			grid.add(ssn, 0, 3);
			grid.add(ssnBOX, 1, 3, 3, 1);
			grid.add(address, 0, 4);
			grid.add(addressBOX, 1, 4, 3, 1);
			grid.add(city, 0, 5);
			grid.add(cityBOX, 1, 5, 3, 1);
			grid.add(state, 0, 6);
			grid.add(stateBOX, 1, 6);
			grid.add(zip, 2, 6);
			grid.add(zipBOX, 3, 6);
			grid.add(securityQ, 0, 7);
			grid.add(securityQBOX, 1, 7, 3, 1);
			grid.add(securityA, 0, 8);
			grid.add(securityABOX, 1, 8, 3, 1);
			
			grid.add(email, 0, 10);
			grid.add(emailBOX, 1, 10, 3, 1);
			grid.add(phone, 0, 11);
			grid.add(phoneBOX, 1, 11, 3, 1);
			grid.add(userName, 0, 12);
			grid.add(userTextField, 1, 12, 3, 1);
			grid.add(pw, 0, 13);
			grid.add(pwBOX, 1, 13, 3, 1);
			grid.add(pw2, 0, 14);
			grid.add(pw2BOX, 1, 14, 3, 1);
			grid.add(actiontarget, 1, 16, 3, 1);
			
			
			grid.setAlignment(Pos.CENTER);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(10);
			grid.setVgap(10);
			

			//HBox creates items in a horizontal row
			HBox hbBtn = new HBox(20);
			hbBtn.getChildren().addAll(btnBack, btnCreate);
			grid.add(hbBtn, 0, 14);
			grid.add(btnCreate, 1,14);
			btnCreate.setMinWidth(300);
			
			//use to do action when button pressed
			//include all actions within the setOnAction method
			
			btnCreate.setOnAction(new EventHandler<ActionEvent>() {
			
				@Override
			    public void handle(ActionEvent e) {
					actiontarget.setText("Create button pressed");
					
			        //use value object object
			       
					ValueObject vo = new ValueObject();
					vo.register();
					
			        String text = firstNameBOX.getText();
			        System.out.println(text);
			        
			       
			        //createAccount(textGrab(userTextField.getText(), pwBOX.getText());
			    }
			});
			
			btnBack.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent e) {
			       Login login = new Login();
			       login.start(primaryStage);
			    }
			});
			
			
			
			// create a new scene and place it on stage
			Scene scene = new Scene(grid, 750, 550);
			primaryStage.setTitle("Login"); //set title
			primaryStage.setScene(scene);
			primaryStage.show();
		
			
			//btn.setOnAction(e -> textGrab(userTextField.getText(), pwBox.getText()) );
		
			
			String uPass = pwBOX.getText();
			
		
			// adds location for text to appear if login fails
			final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);

		}
		
	/*
		private void textGrab(String user, String pass){
			System.out.println("Username: " + user + "\nPassword: " + pass);
		}
		*/
		
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("Driver loaded");
		   
		// Establish a connection, enter personal user name and password for connection
		//AdventureAwaits" , "username", "password");
		
		Application.launch(args);
	}
	
	
}