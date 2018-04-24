package gsu.edu.cis2370.RUNTIME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import gsu.edu.cis2370.DATABASE.*;
import gsu.edu.cis2370.GUI.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ValueObject{
	
	public ValueObject(){	
	}
	
	//returns Temp User Access to use for moving through menus
	public String showTempUserAccess()throws SQLException, ClassNotFoundException{
		TESTCLASS tc = new TESTCLASS();
		String access = tc.tempUserAccess();
		return access;
	}
	
	//returns Temp UserName to use for adding and deleting
	public String showTempUserName()throws SQLException, ClassNotFoundException{
		TESTCLASS tc = new TESTCLASS();
		String access = tc.tempUserName();
		return access;
	} 
	
	//use to create temp table
	public void createTempInfo(String user, String access) throws SQLException, ClassNotFoundException{
		User u1 = new User(){};
		u1.setUserName(user);
		u1.setAccess(access);
		TESTCLASS tc = new TESTCLASS();
		tc.createTempAccess(u1.getUserName(), u1.getAccess());
	}
	
	//use to delete temp table
	public void deleteTempTable()throws SQLException, ClassNotFoundException{
		TESTCLASS tc = new TESTCLASS();
		tc.deleteTempAccess();
		System.out.println("temporary user information deleted");
	}
	
	
	
	
	//registers a new User
	public void register (int ssn, String firstName, String lastName, String email, int phone, String username, String password, String street, String city,
			String state, int zip, String country, String securityQuestion, String securityAnswer){
		//creates a user class to assign values to the attributes that were just passed to this object
		
		
		User user = new User(ssn, firstName, lastName, email, phone, username, password, street, city, state, zip, country, securityQuestion, securityAnswer){};
		TESTCLASS tc = new TESTCLASS();

		System.out.println("user.getSSN: " + user.getSSN());
		
		
		tc.newUser(user.getSSN(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getUserName(), user.getPassword(), user.getStreet(),
				user.getCity(), user.getState(), user.getZip(), user.getCountry(), user.getSecurityQuestion(), user.getSecurityAnswer());
	}
	
	
	//checks Login to see if it matches
	public boolean checkUser(String userName, String pass){
		TESTCLASS tc = new TESTCLASS();
		if(tc.checkAccount(userName, pass) == true){
			return true;
		}else{
			return false;
		}
	}
	
	//checks to see if username is valid for question & answer
	public boolean checkUserName(String userName){
		TESTCLASS tc = new TESTCLASS();
		if(tc.checkUserName(userName) == true){
			return true;
		}else{
			return false;
		}
	}
	//grabs security question
	public String getSecurityQuestion(String userName){
		TESTCLASS tc = new TESTCLASS();
		return tc.getSecurityQuestion(userName);
	}
	//checks security answer
	public boolean checkSecurityAnswer(String userName, String answer){
		TESTCLASS tc = new TESTCLASS();
		return tc.checkAnswer(userName, answer);
	}
	
	//gets password for correct answer display
	public String getPassword(String userName){
		TESTCLASS tc = new TESTCLASS();
		return tc.getPass(userName);
	}
	
	//checks username access for login screen
	public boolean checkAccess(String userName){
		TESTCLASS tc = new TESTCLASS();
		if(tc.checkAccess(userName) == true){
			return true;
		}else{
			return false;
		}
	}
	
	//number of flights currently in the list
	public int flightList(){
		TESTCLASS tc = new TESTCLASS();
		int x = tc.numberOfFlights();
		return x;
		
	}
	
	
		
	//returns array list of flight objects from table
	public ArrayList<Flight> getFlights() throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		ArrayList<Flight> flights = tc.getAllFlight();
		return flights;
	}
	
	//returns string array list of flight info
	public ArrayList<String> getFlightTable() throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		ArrayList<String> flights = tc.getFlightTable();
		return flights;
	}
	

	public ArrayList<String> searchFlights(int flightNum, String fromAir, String toAir, String departureDate, String arrivalDate,
			String departureTime, String arrivalTime) throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		Flight flight = new Flight(flightNum, fromAir, toAir, departureDate, arrivalDate, departureTime, arrivalTime);
		
		//ArrayList<String> flights = tc.searchFlights(flightNum, fromAir, toAir, departureDate, arrivalDate, departureTime, arrivalTime);
		
		ArrayList<String> flights = tc.searchFlights(flight.getFlightNumber(), flight.getFromAirport(), flight.getToAirport(), flight.getDepartureDate(),
				flight.getArrivalDate(), flight.getDepartureTime(), flight.getArrivalTime());
		
		
		return flights;
	}
	
	//returns regular string array of flight info
	public String [] arrayListToString(ArrayList<String> aList) throws ClassNotFoundException, SQLException{
		String hold = "";
		String [] endResult = new String [flightList()];
		int count = 0;
		ArrayList<String> flights = aList;
		for (int x = 0; x < flights.size(); x++) {
			hold += (flights.get(x) + " ");
			if ((x + 1) % 9 == 0) {
				hold.concat("\n");
				
				endResult[count++] = hold;
				hold = "";
			}
		}
		return endResult;
	}
	
	
	
	//books a flight for a user
	public void bookFlight(int flightNumber, String userName){
		//creates a user class to assign values to the attributes that were just passed to this object
		TESTCLASS tc = new TESTCLASS();
		tc.bookFlight(flightNumber, userName);
		System.out.println("Flight successfully booked");
	}
	
	
	public boolean checkDates(int flightNum){
		TESTCLASS tc = new TESTCLASS();
		
		String dDate = tc.getDepartureDate(flightNum);
		String aDate = tc.getArrivalDate(flightNum);
		
		
		
		return true;
	}
	
	
	//-----------------REGULAR EXPRESSIONS-----------------\\
	
		//checks username format
		public boolean testUser(String s1){
			//if(s1.matches("[a-zA-Z0-9._-]{3,}")){
			if(s1.matches("[a-zA-Z0-9._-].{3,}")){
				return true;
			}else{
				return false;
			}
		}	
			
		//checks password format	
		public boolean testPass(String s1){
			if(s1.matches("(?=.*[0-9a-zA-Z@#$%^&+=]).{8,}")){
				return true;
			}else{
				return false;
			}
		}
		
		
		public boolean testDateFormat(String s1){
			if(s1.matches("^(\\d{2}/?\\d{2}/?\\d{4})$")){
				return true;
			}else{
				return false;
			}
		}
		
		public boolean testTimeFormat(String s1){
			if(s1.matches("[0-2][0-9]:[0-5][0-9]")){
				return true;
			}else{
				return false;
			}
		}
	
	
		public boolean testAirport(String s1){
			if(s1.matches("^[A-Z][A-Z][A-Z]$")){
				return true;
			}else{
				return false;
			}
		}
		
	}
	
	
	/*
	public Flight [] flightCreation(){
		ArrayList<String> list = gatherFlights();
		TESTCLASS tc = new TESTCLASS();
		ArrayList<String> groupOfFlights = new ArrayList<String>();
		Flight [] flightObjects = new Flight [tc.numberOfFlights()];
		for(int x = 0; x <tc.numberOfFlights(); x ++){
			//for loop that runs via the amount of flights there are
			//it will assign a new flight object the different variables from the arraylist string
			//since there are a set number of columns in the table, adding 9 to the arraylist index shifts the flight up to the next one
			
			int increase = 0;
			flightObjects[x].setFlightNumber(Integer.parseInt(groupOfFlights.get(0 + increase)));
			flightObjects[x].setFromAirport(groupOfFlights.get(1 + increase));
			flightObjects[x].setToAirport(groupOfFlights.get(2 + increase));
			flightObjects[x].setDepartureDate(groupOfFlights.get(3 + increase));
			flightObjects[x].setArrivalDate(groupOfFlights.get(4 + increase));
			flightObjects[x].setDepartureTime(groupOfFlights.get(5 + increase));
			flightObjects[x].setArrivalTime(groupOfFlights.get(6 + increase));
			flightObjects[x].setMaxCapacity(Integer.parseInt(groupOfFlights.get(7 + increase)));
			flightObjects[x].setNumberOfPassengers(Integer.parseInt(groupOfFlights.get(8 + increase)));
			increase += 9;
		}
		return flightObjects;
	}
	*/

	
	
	
	
	
