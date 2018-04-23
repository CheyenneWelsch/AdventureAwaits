package gsu.edu.cis2370.RUNTIME;

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

	
	
	// check the username and password, return as false if there is not a match
	public boolean checkAccount(String user, String pass) {
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
					"bismarck");

			String query = "SELECT * FROM USER";

			Statement stmt = con.createStatement();
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

	
	
	// Checks user access (return true is admin, false if customer)
	public boolean checkAccess(String user) {
		connection = null;
		int check = 0;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
					"bismarck");

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

	// prints out the user information. Can use this as a template to get
	// individual results
	public void getUserInfo() {
		connection = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
					"bismarck");

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

	/*
	public ArrayList<String> getFlightInfo() {
		connection = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
					"bismarck");

			String query = "SELECT * FROM FLIGHT";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through java result set
			while (rs.next()) {

				// name of variable you want to assign the info to, then the
				// word in "" is the column name in the database
				int flightNumber = rs.getInt("slightNumber");
				String fromAirport = rs.getString("fromAirport");
				String toAirport = rs.getString("toAirport");
				String departDate = rs.getString("departDate");
				String arriveDate = rs.getString("arriveDate");
				String departTime = rs.getString("departTime");
				String arriveTime = rs.getString("arriveTime");
				int maxCapacity = rs.getInt("maxCapacity");
				int numberOfPassengers = rs.getInt("numberOfPassengers");

			}
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	*/
	
	
	//counts number of flights in system
	public int numberOfFlights(){
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
	
	
	
	
	
	public ArrayList<String> getFlightTable(){
		//define a multidimensional string to hold the flight data from the table
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
			
			/*
			//get column title???
			for (int x = 0; x < columncount; x++ ) {
				flights.add(rsmd.getColumnName(x+1));
				
				}
			
			*/
			while (rs.next()) {

				int flightNumber = rs.getInt("flightNumber");
				//convert the int to string
				String stringFlightNumber = Integer.toString(flightNumber);
				flights.add(stringFlightNumber + "   ");
				
				String fromAirport = rs.getString("fromAirport");
				flights.add(fromAirport+ "   ");
				
				String toAirport = rs.getString("toAirport");
				flights.add(toAirport+ "   ");
				
				String departDate = rs.getString("departDate");
				flights.add(departDate+ "   ");
				
				String arriveDate = rs.getString("arriveDate");
				flights.add(arriveDate+ "   ");
				
				String departTime = rs.getString("departTime");
				flights.add(departTime+ "   ");
				
				String arriveTime = rs.getString("arriveTime");
				flights.add(arriveTime+ "   ");
				
				int maxCapacity = rs.getInt("maxCapacity");
				String stringMaxCapacity = Integer.toString(maxCapacity);
				flights.add(stringMaxCapacity+ "   ");
				
				int numberOfPassengers = rs.getInt("numberOfPassengers");
				String stringNumberOfPassengers = Integer.toString(numberOfPassengers);
				flights.add(stringNumberOfPassengers+ "   ");

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
		while(rst.next()){
			Flight flight = new Flight(rst.getInt("flightNumber"), rst.getString("fromAirport"), rst.getString("toAirport"), rst.getString("departDate"),
					rst.getString("arriveDate"), rst.getString("departTime"), rst.getString("arriveTime"), rst.getInt("maxCapacity"), rst.getInt("numberOfPassengers"));
		}
		return flightlist;
	}
		
	//TEST
	public ArrayList<Flight> getFlightList() throws ClassNotFoundException, SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root",
				"bismarck");
		Statement stmt = con.createStatement();
		String sql = "Select * from FLIGHT";
		ResultSet rst;
		rst = stmt.executeQuery(sql);
		String list;
		ArrayList<Flight> flightlist = new ArrayList<>();
		while(rst.next()){
		//	list.concat(rst.toString());
		}
		return flightlist;
	}
	
}
