package gsu.edu.cis2370.DATABASE;

import gsu.edu.cis2370.RUNTIME.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class TESTCLASS {

	private static Connection connection;

	// creates temp access table to store
	public Connection createTempAccess(String userName, String access) throws SQLException, ClassNotFoundException {

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
		System.out.println("Database connected");

		String tempUser = ("CREATE TABLE TEMPUSER" + "(username VARCHAR(20), " + " access VARCHAR(1), "
				+ " PRIMARY KEY (username))");

		Statement statement = connection.prepareStatement(tempUser);
		statement.executeUpdate(tempUser);

		String text = "INSERT INTO TEMPUSER(username, access) " + "VALUES('" + userName + "', '" + access + "' ) ";
		Statement stmt = connection.prepareStatement(text);
		// stmt.executeUpdate(text);
		stmt.execute(text);
		System.out.println("TEMP CREATE");
		return connection;

	}

	// delete temporary access table upon logout
	public Connection deleteTempAccess() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

		String tempUser = ("DROP TABLE TEMPUSER");

		Statement statement = connection.prepareStatement(tempUser);
		statement.executeUpdate(tempUser);
		return connection;
	}

	// returns access of user from temp table
	public String tempUserAccess() throws SQLException, ClassNotFoundException {
		connection = null;
		int check = 0;
		String a1 = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT access FROM TEMPUSER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				a1 = rs.getString("access");

			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return a1;
	}

	// returns access of user from temp table
	public String tempUserName() throws SQLException, ClassNotFoundException {
		connection = null;
		int check = 0;
		String a1 = "";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT userName FROM TEMPUSER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				a1 = rs.getString("userName");

			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return a1;
	}

	// add a user to the database
	public Connection newUser(int ssn, String firstName, String lastName, String email, int phone, String username,
			String password, String street, String city, String state, int zip, String country, String securityQuestion,
			String securityAnswer) {

		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String text = "INSERT INTO USER(ssn, firstName, lastName, email, phone, username, password, street, city, state, zip, country, securityQuestion, securityAnswer, access) "
					+ "VALUES(" + ssn + ", '" + firstName + "', '" + lastName + "', '" + email + "', " + phone + ", '"
					+ username + "', '" + password + "', '" + street + "', '" + city + "', '" + state + "', " + zip
					+ ", '" + country + "', '" + securityQuestion + "', '" + securityAnswer + "', 'C' ) ";

			Statement stmt = connection.prepareStatement(text);
			// stmt.executeUpdate(text);
			stmt.execute(text);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// prints out the user information. Can use this as a template to get
	// individual results
	public void getUserInfo() {
		connection = null;
		try {

			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits",
			// "root", "ch3y3nn3");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM USER";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database
				int ssn = rs.getInt("ssn");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				int phone = rs.getInt("phone");
				String username = rs.getString("userName");
				String password = rs.getString("password");
				String street = rs.getString("street");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				String country = rs.getString("country");
				String securityQuestion = rs.getString("securityQuestion");
				String securityAnswer = rs.getString("securityAnswer");
				String access = rs.getString("access");

				System.out.println(ssn + " " + firstName + " " + lastName + " " + email + " " + phone);
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// add a new FLIGHT to the database
	public Connection newFlight(int flightNumber, String fromAirport, String toAirport, String departDate,
			String arriveDate, String departTime, String arriveTime, int maxCapacity, int numberOfPassengers)
			throws SQLException, ClassNotFoundException {
		connection = null;

		try {
			// Set up a connection with database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
			System.out.println("Database connected");

			String text = "INSERT INTO flight (flightNumber , fromAirport , toAirport , departDate , arriveDate , departTime , arriveTime , maxCapacity, numberOfPassengers )"
					+ "VALUES (" + (numberOfFlights()+1) + ",'" + fromAirport + "','" + toAirport + "','" + departDate + "','"
					+ arriveDate + "','" + departTime + "','" + arriveTime + "'," + maxCapacity + ","
					+ numberOfPassengers + ")";

			Statement stmt = connection.prepareStatement(text);
			// stmt.executeUpdate(text);
			stmt.execute(text);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// check the username and password, return as false if there is not a match
	public boolean checkAccount(String user, String pass) {
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM USER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database
				String username = rs.getString("userName");
				String password = rs.getString("password");

				System.out.println(username + " " + password);
				if (user.equals(username) && pass.equals(password)) {
					check = 1;
					break;
				} else {
					check = 0;
				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		if (check == 1) {
			return true;
		} else {
			return false;
		}
	}

	// check UserName to see if it exists in the database
	public boolean checkUserName(String user) {
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM USER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database
				String username = rs.getString("userName");

				System.out.println(username);
				if (user.equals(username)) {
					check = 1;
					break;
				} else {
					check = 0;
				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		if (check == 1) {
			return true;
		} else {
			return false;
		}
	}

	// get security Question for Password Recovery
	public String getSecurityQuestion(String user) {
		String questionLine = "";
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT username, securityQuestion FROM USER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database

				String username = rs.getString("userName");
				if (user.equals(username)) {
					questionLine = rs.getString("securityQuestion");
				}

			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return questionLine;
	}

	// checks for security answer validity
	public boolean checkAnswer(String userName, String answer) {
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT userName, securityAnswer FROM USER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database
				String username = rs.getString("userName");

				String Ans = rs.getString("securityAnswer");
				if (answer.equals(Ans)) {
					check = 1;
					break;
				} else {
					check = 0;
				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		if (check == 1) {
			return true;
		} else {
			return false;
		}
	}

	// displays password for correct answer
	public String getPass(String user) {
		String passwordString = "";
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT userName, password FROM USER";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database

				String username = rs.getString("username");
				if (user.equals(username)) {
					passwordString = rs.getString("password");
				}

			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return passwordString;
	}

	// Checks user access (return true is admin, false if customer)
	public boolean checkAccess(String user) {
		connection = null;
		int check = 0;
		try {
			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits",
			// "root", "ch3y3nn3");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT username, access FROM USER";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database
				String userName = rs.getString("username");
				String access = rs.getString("access");

				if (userName.equals(user) && access.equals("A")) {
					check = 1;
					break;
				} else {
					break;
				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		if (check == 1) {
			// true means admin
			return true;
		} else {
			// false means customer
			return false;
		}

	}

	// counts number of flights in system
	public int numberOfFlights() {
		int maxCapacity = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
					"bismarck");

			String query = "SELECT COUNT(*) FROM FLIGHT";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				maxCapacity = rs.getInt("COUNT(*)");
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return maxCapacity;
	}

	public ArrayList<String> getFlightTable() {
		// define a multidimensional string to hold the flight data from the
		// table
		ArrayList<String> flights = new ArrayList<String>();
		connection = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
					"bismarck");

			String query = "SELECT * FROM FLIGHT";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			ResultSetMetaData rsmd = rs.getMetaData();
			int columncount = rsmd.getColumnCount();

			while (rs.next()) {

				int flightNumber = rs.getInt("flightNumber");
				// convert the int to string
				String stringFlightNumber = Integer.toString(flightNumber);
				flights.add(stringFlightNumber + "     ");

				String fromAirport = rs.getString("fromAirport");
				flights.add(fromAirport + "      ");

				String toAirport = rs.getString("toAirport");
				flights.add(toAirport + "      ");

				String departDate = rs.getString("departDate");
				flights.add(departDate + "      ");

				String arriveDate = rs.getString("arriveDate");
				flights.add(arriveDate + "      ");

				String departTime = rs.getString("departTime");
				flights.add(departTime + "      ");

				String arriveTime = rs.getString("arriveTime");
				flights.add(arriveTime + "      ");

				int maxCapacity = rs.getInt("maxCapacity");
				String stringMaxCapacity = Integer.toString(maxCapacity);
				flights.add(stringMaxCapacity + "   ");

				int numberOfPassengers = rs.getInt("numberOfPassengers");
				String stringNumberOfPassengers = Integer.toString(numberOfPassengers);
				flights.add(stringNumberOfPassengers + "   ");

			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return flights;
	}

	public ArrayList<Flight> getAllFlight() throws ClassNotFoundException, SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
				"bismarck");
		Statement stmt = con.createStatement();
		String sql = "Select * from FLIGHT";
		ResultSet rst;
		rst = stmt.executeQuery(sql);
		ArrayList<Flight> flightlist = new ArrayList<>();
		while (rst.next()) {
			Flight flight = new Flight(rst.getInt("flightNumber"), rst.getString("fromAirport"),
					rst.getString("toAirport"), rst.getString("departDate"), rst.getString("arriveDate"),
					rst.getString("departTime"), rst.getString("arriveTime"), rst.getInt("maxCapacity"),
					rst.getInt("numberOfPassengers"));
		}
		return flightlist;
	}

	// TEST
	public ArrayList<Flight> getFlightList() throws ClassNotFoundException, SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
				"bismarck");
		Statement stmt = con.createStatement();
		String sql = "Select * from FLIGHT";
		ResultSet rst;
		rst = stmt.executeQuery(sql);
		String list;
		ArrayList<Flight> flightlist = new ArrayList<>();
		while (rst.next()) {
			// list.concat(rst.toString());
		}
		return flightlist;
	}

	// return an ArrayList filled with string objects that represent the flight
	// search results
	public ArrayList<String> searchFlights(int flightNum, String fromAir, String toAir, String departureDate,
			String arrivalDate, String departureTime, String arrivalTime) throws ClassNotFoundException, SQLException {
		String passwordString = "";

		ArrayList<String> flights = new ArrayList<String>();
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT flightNumber, fromAirport, toAirport, departDate, arriveDate, departTime, arriveTime FROM FLIGHT";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				if (flightNum == rs.getInt("flightNumber") || fromAir == rs.getString("fromAirport")
						|| toAir == rs.getString("toAirport") || departureDate == rs.getString("departDate")
						|| arrivalDate == rs.getString("arriveDate") || departureTime == rs.getString("departTime")
						|| arrivalTime == rs.getString("arriveTime")) {

					int flightNumber = rs.getInt("flightNumber");
					// convert the int to string
					String stringFlightNumber = Integer.toString(flightNumber);
					flights.add(stringFlightNumber + "     ");

					String fromAirport = rs.getString("fromAirport");
					flights.add(fromAirport + "      ");

					String toAirport = rs.getString("toAirport");
					flights.add(toAirport + "      ");

					String departDate = rs.getString("departDate");
					flights.add(departDate + "      ");

					String arriveDate = rs.getString("arriveDate");
					flights.add(arriveDate + "      ");

					String departTime = rs.getString("departTime");
					flights.add(departTime + "      ");

					String arriveTime = rs.getString("arriveTime");
					flights.add(arriveTime + "      ");

				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return flights;
	}

	// Return a single flight with the same flight number
	public ArrayList<String> searchFlightsWithNumber(int flightNum) throws ClassNotFoundException, SQLException {
		String passwordString = "";

		ArrayList<String> flights = new ArrayList<String>();
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM FLIGHT";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				if (flightNum == rs.getInt("flightNumber")) {

					int flightNumber = rs.getInt("flightNumber");
					// convert the int to string
					String stringFlightNumber = Integer.toString(flightNumber);
					flights.add(stringFlightNumber + "     ");

					String fromAirport = rs.getString("fromAirport");
					flights.add(fromAirport + "      ");

					String toAirport = rs.getString("toAirport");
					flights.add(toAirport + "      ");

					String departDate = rs.getString("departDate");
					flights.add(departDate + "      ");

					String arriveDate = rs.getString("arriveDate");
					flights.add(arriveDate + "      ");

					String departTime = rs.getString("departTime");
					flights.add(departTime + "      ");

					String arriveTime = rs.getString("arriveTime");
					flights.add(arriveTime + "      ");

				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return flights;
	}

	// return an ArrayList filled with string objects that represent the flight
	// search results
	public ArrayList<String> viewMyFlights(String username) {
		String passwordString = "";
		TESTCLASS tc = new TESTCLASS();
		ArrayList<String> myFlights = new ArrayList<String>();

		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM BOOKING";

			Statement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			int flightNumHold = 0;
			while (rs.next()) {
				// if statement to be used to search booking table to find the
				// flight info for selected user
				if (username.equals(rs.getString("username"))) {
					// creates a second query to be used to get flight
					// information from flight table
					flightNumHold = rs.getInt("flightNumber");
					myFlights.addAll(tc.searchFlightsWithNumber(flightNumHold));

				}
			}
			stmt.close();

		} catch (

		Exception e) {
			System.out.println(e);
		}
		return myFlights;
	}

	// book a flight for a user
	public Connection bookFlight(int flightNum, String userName) {

		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT confirmationNumber FROM BOOKING";
			Statement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			int findConfirmationNumber = 0;
			while (rs.next()) {
				findConfirmationNumber = rs.getInt("confirmationNumber");
			}

			String text = "INSERT INTO BOOKING(confirmationNumber, flightNumber, userName) " + "VALUES("
					+ (findConfirmationNumber + 1) + ", " + flightNum + ", '" + userName + "') ";

			stmt = connection.prepareStatement(text);
			// stmt.executeUpdate(text);
			stmt.execute(text);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public String getDepartureDate(int flightNum) {
		connection = null;
		String dDate = "";
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM TESTFLIGHT";
			Statement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {
				if (rs.getInt("flightNumber") == flightNum)
					dDate = rs.getString("departDate");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dDate;
	}

	public String getArrivalDate(int flightNum) {
		connection = null;
		String dDate = "";
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT * FROM TESTFLIGHT";
			Statement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {
				if (rs.getInt("flightNumber") == flightNum)
					dDate = rs.getString("arriveDate");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dDate;
	}

	public Connection deleteUserFlight(int flightNum, String userName) {
		connection = null;
		String dDate = "";
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String deleteFlight = "DELETE FROM TABLE booking WHERE flightNumber = ? AND userName = ?";
			Statement stmt = connection.prepareStatement(deleteFlight);
			
			//
			PreparedStatement st = connection.prepareStatement("DELETE FROM booking WHERE flightNumber = ? AND userName = ?");
			
			//sets the two arguments that are passed to this method when called to the index of the '?'s in the prepared statement
			st.setInt(1, flightNum);
			st.setString(2,userName);
			st.executeUpdate();
		 
			
			//stmt.execute(deleteFlight);
			System.out.println("FLIGHT DELETED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	
	
	public Connection deleteSystemFlight(int flightNum) {
		connection = null;
		String dDate = "";
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			//String deleteFlight = "DELETE FROM TABLE booking WHERE flightNumber = ?";
			//Statement stmt = connection.prepareStatement(deleteFlight);
			
			//
			PreparedStatement st = connection.prepareStatement("DELETE FROM flight WHERE flightNumber = ?");
			
			//sets the two arguments that are passed to this method when called to the index of the '?'s in the prepared statement
			st.setInt(1, flightNum);
			st.executeUpdate();
		 
			
			//stmt.execute(deleteFlight);
			System.out.println("FLIGHT DELETED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	
	

	// --------------------ADMIN CONTROLS--------------------

	// Update toAirport
	public Connection editFlightToAirport(int flightNumber, String toAirport) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String updateFlight = ("UPDATE flight SET toAirport = '" + toAirport + "' WHERE flightNumber = "
					+ flightNumber + "");

			Connection con;
			Statement stmt = connection.prepareStatement(updateFlight);
			// stmt.executeUpdate(text);
			stmt.execute(updateFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// update fromAirport
	public Connection editFlightFromAirport(int flightNumber, String fromAirport) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String updateFlight = ("UPDATE flight SET fromAirport = '" + fromAirport + "' WHERE flightNumber = "
					+ flightNumber + "");

			Connection con;
			Statement stmt = connection.prepareStatement(updateFlight);
			// stmt.executeUpdate(text);
			stmt.execute(updateFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// update departDate
	public Connection editFlightDepartDate(int flightNumber, String departDate) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String updateFlight = ("UPDATE flight SET departDate = '" + departDate + "' WHERE flightNumber = "
					+ flightNumber + "");

			Connection con;
			Statement stmt = connection.prepareStatement(updateFlight);
			// stmt.executeUpdate(text);
			stmt.execute(updateFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// update arriveDate
	public Connection editFlightArriveDate(int flightNumber, String arriveDate) {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String updateFlight = ("UPDATE flight SET arriveDate = '" + arriveDate + "' WHERE flightNumber = "
					+ flightNumber + "");

			Connection con;
			Statement stmt = connection.prepareStatement(updateFlight);
			// stmt.executeUpdate(text);
			stmt.execute(updateFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// update departTime
	public Connection editFlightDepartTime(int flightNumber, String departTime) {
		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String updateFlight = ("UPDATE flight SET departTime = '" + departTime + "' WHERE flightNumber = "
					+ flightNumber + "");

			Connection con;
			Statement stmt = connection.prepareStatement(updateFlight);
			// stmt.executeUpdate(text);
			stmt.execute(updateFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// update arriveTime
	public Connection editFlightArriveTime(int flightNumber, String arriveTime) {
		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String updateFlight = ("UPDATE flight SET arriveTime = '" + arriveTime + "' WHERE flightNumber = "
					+ flightNumber + "");

			Connection con;
			Statement stmt = connection.prepareStatement(updateFlight);
			// stmt.executeUpdate(text);
			stmt.execute(updateFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// DELETE A FLIGHT
	// for new and delete, leave out parenthesis
	public Connection deleteFlight(int flightNumber) {

		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String deleteFlight = "DELETE FROM flight WHERE flightNumber = " + flightNumber + "";

			Statement stmt = connection.prepareStatement(deleteFlight);
			// stmt.executeUpdate(text);
			stmt.execute(deleteFlight);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	// check user flights to make sure they are not booking the same one
	public boolean checkFlightAvailability(int flightNum, String user) {
		connection = null;
		// used to hold true or false value. 1 = not available, 0 = available
		int check = 2;
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");

			String query = "SELECT flightNumber, userName FROM BOOKING";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				String userName = rs.getString("username");
				int flightNumber = rs.getInt("flightNumber");

				if ((flightNum == flightNumber) && (user.equals(userName))) {
					check = 1;
					// if both on there, this should not pass so set to 1
					break;
				} else {
					check = 0;
					break;
				}
			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		if (check == 0) {
			// true means available
			return true;
		} else {
			// false means flight already booked
			return false;
		}

	}

}
