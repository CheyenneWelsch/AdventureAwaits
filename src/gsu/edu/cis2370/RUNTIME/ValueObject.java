package gsu.edu.cis2370.RUNTIME;

import gsu.edu.cis2370.DATABASE.TESTCLASS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.ParseException;

import gsu.edu.cis2370.DATABASE.*;
import gsu.edu.cis2370.GUI.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ValueObject {

	public ValueObject() {
	}

	// returns Temp User Access to use for moving through menus
	public String showTempUserAccess() throws SQLException, ClassNotFoundException {
		TESTCLASS tc = new TESTCLASS();
		String access = tc.tempUserAccess();
		return access;
	}

	// returns Temp UserName to use for adding and deleting
	public String showTempUserName() throws SQLException, ClassNotFoundException {
		TESTCLASS tc = new TESTCLASS();
		String access = tc.tempUserName();
		return access;
	}

	// use to create temp table
	public void createTempInfo(String user, String access) throws SQLException, ClassNotFoundException {
		User u1 = new User() {
		};
		u1.setUserName(user);
		u1.setAccess(access);
		TESTCLASS tc = new TESTCLASS();
		tc.createTempAccess(u1.getUserName(), u1.getAccess());
	}

	// use to delete temp table
	public void deleteTempTable() throws SQLException, ClassNotFoundException {
		TESTCLASS tc = new TESTCLASS();
		tc.deleteTempAccess();
		System.out.println("temporary user information deleted");
	}

	// registers a new User
	public void register(int ssn, String firstName, String lastName, String email, int phone, String username,
			String password, String street, String city, String state, int zip, String country, String securityQuestion,
			String securityAnswer) {
		// creates a user class to assign values to the attributes that were
		// just passed to this object

		User user = new User(ssn, firstName, lastName, email, phone, username, password, street, city, state, zip,
				country, securityQuestion, securityAnswer) {
		};
		TESTCLASS tc = new TESTCLASS();

		// System.out.println("user.getSSN: " + user.getSSN());

		tc.newUser(user.getSSN(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(),
				user.getUserName(), user.getPassword(), user.getStreet(), user.getCity(), user.getState(),
				user.getZip(), user.getCountry(), user.getSecurityQuestion(), user.getSecurityAnswer());
	}

	// registers a new Flight
	public void addFlight(int flightNumber, String fromAirport, String toAirport, String departDate, String arriveDate,
			String departTime, String arriveTime, int maxCapacity, int numberOfPassengers)
			throws SQLException, ClassNotFoundException {
		// creates a user class to assign values to the attributes that were
		// just passed to this object

		Flight f1 = new Flight(flightNumber, fromAirport, toAirport, departDate, arriveDate, departTime, arriveTime,
				maxCapacity, numberOfPassengers);
		TESTCLASS tc = new TESTCLASS();

		tc.newFlight(f1.getFlightNumber(), f1.getFromAirport(), f1.getToAirport(), f1.getDepartureDate(),
				f1.getArrivalDate(), f1.getDepartureTime(), f1.getArrivalTime(), f1.getMaxCapacity(),
				f1.getNumberOfPassengers());
	}

	// checks Login to see if it matches
	public boolean checkUser(String userName, String pass) {
		TESTCLASS tc = new TESTCLASS();
		if (tc.checkAccount(userName, pass) == true) {
			return true;
		} else {
			return false;
		}
	}

	// checks to see if username is valid for question & answer
	public boolean checkUserName(String userName) {
		TESTCLASS tc = new TESTCLASS();
		if (tc.checkUserName(userName) == true) {
			return true;
		} else {
			return false;
		}
	}

	// grabs security question
	public String getSecurityQuestion(String userName) {
		TESTCLASS tc = new TESTCLASS();
		return tc.getSecurityQuestion(userName);
	}

	// checks security answer
	public boolean checkSecurityAnswer(String userName, String answer) {
		TESTCLASS tc = new TESTCLASS();
		return tc.checkAnswer(userName, answer);
	}

	// gets password for correct answer display
	public String getPassword(String userName) {
		TESTCLASS tc = new TESTCLASS();
		return tc.getPass(userName);
	}

	// checks username access for login screen
	public boolean checkAccess(String userName) {
		TESTCLASS tc = new TESTCLASS();
		if (tc.checkAccess(userName) == true) {
			return true;
		} else {
			return false;
		}
	}

	// number of flights currently in the list
	public int flightList() {
		TESTCLASS tc = new TESTCLASS();
		int x = tc.numberOfFlights();
		return x;

	}

	// returns array list of flight objects from table
	public ArrayList<Flight> getFlights() throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		ArrayList<Flight> flights = tc.getAllFlight();
		return flights;
	}

	// returns string array list of flight info
	public ArrayList<String> getFlightTable() throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		ArrayList<String> flights = tc.getFlightTable();
		return flights;
	}

	// search flight list

	public ArrayList<String> searchFlights(int flightNum, String fromAir, String toAir, String departureDate,
			String arrivalDate, String departureTime, String arrivalTime) throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		Flight flight = new Flight(flightNum, fromAir, toAir, departureDate, arrivalDate, departureTime, arrivalTime);

		// ArrayList<String> flights = tc.searchFlights(flightNum, fromAir,
		// toAir, departureDate, arrivalDate, departureTime, arrivalTime);

		ArrayList<String> flights = tc.searchFlights(flight.getFlightNumber(), flight.getFromAirport(),
				flight.getToAirport(), flight.getDepartureDate(), flight.getArrivalDate(), flight.getDepartureTime(),
				flight.getArrivalTime());

		return flights;
	}

	// returns regular string array of flight info
	public String[] arrayListToString(ArrayList<String> aList) throws ClassNotFoundException, SQLException {
		String hold = "";
		String[] endResult = new String[flightList()];
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

	// return an array list of the user's flights
	public ArrayList<String> getMyFlights(String userName) throws ClassNotFoundException, SQLException {
		TESTCLASS tc = new TESTCLASS();
		ArrayList<String> flights = tc.viewMyFlights(userName);
		return flights;
	}

	// books a flight for a user
	public void bookFlight(int flightNumber, String userName) {
		// creates a user class to assign values to the attributes that were
		// just passed to this object
		TESTCLASS tc = new TESTCLASS();
		tc.bookFlight(flightNumber, userName);
		System.out.println("Flight successfully booked");
	}

	public boolean checkFlightAvailability(int flightNum, String userName) throws ClassNotFoundException, SQLException {
		// true available, false NOT available
		TESTCLASS tc = new TESTCLASS();
		boolean check = tc.checkFlightAvailability(flightNum, userName);
		if (check == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDates(int flightNum) {
		TESTCLASS tc = new TESTCLASS();
		int hold = 0;
		String dDate = tc.getDepartureDate(flightNum);
		String aDate = tc.getArrivalDate(flightNum);
		// Date Format object used to essentially translate a string of text
		// formatted this way into a date object
		DateFormat dateFormat = new SimpleDateFormat("YYYY-DD-MM", Locale.ENGLISH);
		try {
			// find if date comes after departure date and before arrival date
			Date departDate = dateFormat.parse(dDate);
			System.out.println("Depart: " + departDate);
			Date arriveDate = dateFormat.parse(aDate);
			System.out.println("Arrive: " + arriveDate);

			// find out what this results as
			// departDate.after(when)
			if (departDate.compareTo(arriveDate) > 0) {
				hold = 1;
			} else {
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (hold == 1) {
			return true;
		} else {
			return false;
		}
	}

	// delete a flight form a user's account
	public void deleteUserFlight(int flightNumber, String userName) {
		TESTCLASS tc = new TESTCLASS();
		tc.deleteUserFlight(flightNumber, userName);
	}

	public void deleteSystemFlight(int flightNumber) {
		TESTCLASS tc = new TESTCLASS();
		tc.deleteSystemFlight(flightNumber);
	}

	// -----------------EDIT FLIGHT INFORMATION-----------------\\

	// from Airport
	public void editFlightFromAir(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightFromAirport(flightNumber, fromAirport);
	}

	// to Airport
	public void editFlightToAir(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightToAirport(flightNumber, fromAirport);
	}

	// Depart Date
	public void editFlightDepartDate(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightDepartDate(flightNumber, fromAirport);
	}

	// ArrivalDate
	public void editFlightArriveDate(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightArriveDate(flightNumber, fromAirport);
	}

	// Depart Time
	public void editFlightDepartTime(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightDepartTime(flightNumber, fromAirport);
	}

	// Arrival Time
	public void editFlightArriveTime(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightArriveTime(flightNumber, fromAirport);
	}

	// Max Capacity
	public void editFlightMaxCapacity(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightMaxCapacity(flightNumber, fromAirport);
	}

	// Current Capacity
	public void editFlightCurrentCapacity(int flightNumber, String fromAirport) {
		TESTCLASS tc = new TESTCLASS();
		tc.editFlightCurrentCapacity(flightNumber, fromAirport);
	}

	// -----------------REGULAR EXPRESSIONS-----------------\\

	// checks username format
	public boolean testUser(String s1) {
		// if(s1.matches("[a-zA-Z0-9._-]{3,}")){
		if (s1.matches("[a-zA-Z0-9._-].{3,}")) {
			return true;
		} else {
			return false;
		}
	}

	// checks password format
	public boolean testPass(String s1) {
		if (s1.matches("(?=.*[0-9a-zA-Z@#$%^&+=]).{8,}")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testDateFormat(String s1) {
		if (s1.matches("^(\\d{2}/?\\d{2}/?\\d{4})$")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testTimeFormat(String s1) {
		if (s1.matches("[0-2][0-9]:[0-5][0-9]")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testAirport(String s1) {
		if (s1.matches("^[A-Z][A-Z][A-Z]$")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean testNumberFormat(String s1) {
		if (s1.matches("^[0-9]+$")) {
			return true;
		} else {
			return false;
		}
	}

}
