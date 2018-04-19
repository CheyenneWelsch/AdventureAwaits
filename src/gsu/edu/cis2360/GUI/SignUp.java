package gsu.edu.cis2360.GUI;

import java.awt.Color;

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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;


public class SignUp extends Application {
		
	
	

	
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
	
	TextField userTextField = new TextField();
	Text scenetitle = new Text("ACCOUNT CREATION");
	
	TextField userNameBox = new TextField();
	TextField firstNameBOX = new TextField();
	TextField lastNameBOX = new TextField();
	TextField ssnBOX = new TextField();
	TextField addressBOX = new TextField();
	TextField cityBOX = new TextField();
	TextField stateBOX = new TextField();
	TextField zipBOX = new TextField();
	TextField countryBOX = new TextField();
	TextField securityQBOX = new TextField();
	TextField securityABOX = new TextField();
	
	PasswordField pwBOX = new PasswordField();
	PasswordField pw2BOX = new PasswordField();

	
	
	
	//creates a login button
	Button btn = new Button("Go Back");
	Button btnCreate = new Button("Create Account");
	final Text actiontarget = new Text();
	
	@Override
		public void start(Stage primaryStage) {

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
			grid.add(country, 0, 7);
			grid.add(countryBOX, 1, 7, 3, 1);
			grid.add(securityQ, 0, 8);
			grid.add(securityQBOX, 1, 8, 3, 1);
			grid.add(securityA, 0, 9);
			grid.add(securityABOX, 1, 9, 3, 1);
		
			grid.add(userName, 0, 11);
			grid.add(userTextField, 1, 11, 3, 1);
			grid.add(pw, 0, 12);
			grid.add(pwBOX, 1, 12, 3, 1);
			grid.add(pw2, 0, 13);
			grid.add(pw2BOX, 1, 13, 3, 1);
			grid.add(actiontarget, 1, 15, 3, 1);
			
			
			grid.setAlignment(Pos.CENTER);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setHgap(10);
			grid.setVgap(10);
			

			//HBox creates items in a horizontal row
			HBox hbBtn = new HBox(20);
			hbBtn.getChildren().addAll(btn, btnCreate);
			grid.add(hbBtn, 0, 14);
			grid.add(btnCreate, 1,14);
			btnCreate.setMinWidth(300);
			
			//use to do action when button pressed
			//include all actions within the setOnAction method
			btnCreate.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent e) {
			        actiontarget.setText("Sign in button pressed");
			        if(testUser(userTextField.getText()) == true &&
			        		testPass(pwBox.getText()) == true){
			        	  textGrab(userTextField.getText(), pwBox.getText());
			        	 
			        	  
			        }else{
			        	actiontarget.setText("ERROR, BAD ENTRY");
			        }

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
		
		private void textGrab(String user, String pass){
			System.out.println("Username: " + user + "\nPassword: " + pass);
		}
		
		private boolean testUser(String s1){
			//if(s1.matches("[a-zA-Z0-9._-]{3,}")){
			if(s1.matches("[a-zA-Z0-9._-].{3,}")){
				return true;
			}else{
				return false;
			}
		}
		
		private boolean testPass(String s1){
			if(s1.matches("(?=.*[0-9a-zA-Z@#$%^&+=]).{8,}")){
				return true;
			}else{
				return false;
			}
		}
	
}
