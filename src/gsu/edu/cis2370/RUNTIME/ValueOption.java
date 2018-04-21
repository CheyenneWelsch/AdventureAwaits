package gsu.edu.cis2370.RUNTIME;

import java.util.Date;
import gsu.edu.cis2360.GUI.*;
public class ValueOption{
	
	public SignUp signUp = new SignUp();
	
	//User Object
	public User user = new User(){
		
	};
	
	public void createAccount(User x){
		this.user.setName(signUp.firstNameBOX.toString(), signUp.lastNameBOX.toString());
		this.user.setSSN(signUp.ssnBOX.toString());
		
		
		this.user.setUserName(signUp.userTextField.toString());
		this.user.setPassword(signUp.pwBOX.toString());
		
		//since setAddress needs an int value, the next line converts the string to an int
		int zip =Integer.parseInt(signUp.zipBOX.toString());
		this.user.setAddress(signUp.addressBOX.toString(), signUp.stateBOX.toString(), zip);
		
		
	}
	
	
	
	
	
}
	
	
	
	
	
	
	/*
	class User {
		private String firstName;
		private String lastName;
		private String address;
		private int zip;
		private String state;
		private String userName;
		private String password;
		private String email;
		private String SSN;
		private String securityQuestion;
		private String securityAnswer;
		
	}
	
	
	
	class Flight {
		private String fromCity;
		private String fromAirport;
		private String toCity;
		private String toAirport;
		

		private Date departureDate;
		private Date arrivalDate;
		
		private Date departureTime;
		private Date arrivalTime;
		
		private int numberOfPassengers;

		private int flightNumber;
		
		private String planeType;
	}
	
	class Airport {
		private String airportCode;
		private String name;
		private String city;
		private String state;
		
	}
	
	
	
}









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

import gsu.edu.cis2360.GUI.Login;

public class ValueOption {

	static Login login = new Login();

	// FOR TESTING - display user name

	public Login textGrab(Login txt) {
		
		return txt;
	}

	public static TextField grabUser(TextField txt) {
		txt = login.userTextField;
		return txt;
	}

	public boolean testUser(String s1) {
		// if(s1.matches("[a-zA-Z0-9._-]{3,}")){
		if (s1.matches("[a-zA-Z0-9._-].{3,}")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean testPass(String s1) {
		if (s1.matches("(?=.*[0-9a-zA-Z@#$%^&+=]).{8,}")) {
			return true;
		} else {
			return false;
		}
	}

}
*/