package gsu.edu.cis2370.RUNTIME;

import java.util.Date;

public class ValueOption{
	
	//User
	public String User.getFirstName(){
		
	}
	
	
	//entity:
	public final class User {
		private final SSN ssn; //global identity
		FirstName firstName;
		LastName lastName;
		Address address;
	}
	
	new User(String ssn, String firstName, String, lastName, String address) {
		
	}
	
	class SSN {
		String value;
		public SSN(String value) {
			this.value = value.toString();
		}
	}
	
	class FirstName {
		String value;
	}
	
	class LastName {
		String value;
	}
	
	class Address {
		String address;
		String city;
		int zip;
		String country;
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