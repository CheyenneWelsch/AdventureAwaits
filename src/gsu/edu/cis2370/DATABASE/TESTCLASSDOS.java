package gsu.edu.cis2370.DATABASE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import gsu.edu.cis2370.RUNTIME.*;


public class TESTCLASSDOS {

private static Connection connection;

		
		//addd a user to the database.
		public Connection newUser(int ssn, String firstName, String lastName, String email, int phone, String username,
				String password, String street, String city, String state, int zip, String country, String securityQuestion,
				String securityAnswer) {
			
			connection = null;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
				
				String text = "INSERT INTO user(ssn, firstName, lastName, email, phone, username, password, street, city, state, zip, country, securityQuestion, securityAnswer, access) "
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

		
		// add a new FLIGHT to the database
		public Connection newFlight(int flightNumber, String fromAirport, String toAirport, String departDate,
				String arriveDate, String departTime, String arriveTime, int maxCapacity, int numberOfPassengers) throws SQLException, ClassNotFoundException {
			connection = null;
			 
			try {   
				// Set up a connection with database
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
				System.out.println("Database connected");
				
				String text = "INSERT INTO flight (flightNumber , fromAirport , toAirport , departDate , arriveDate , departTime , arriveTime , maxCapacity, numberOfPassengers )" +
						"VALUES (" + flightNumber + ",'"+ fromAirport +"','"+ toAirport +"','" + departDate + "','" + arriveDate +"','" 
						+ departTime +"','"+ arriveTime +"',"+ maxCapacity +","+ numberOfPassengers +")";
				

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
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");

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

		
		
		// Checks user access (return true is admin, false if customer)
		public boolean checkAccess(String user) {
			connection = null;
			int check = 0;
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");

				String query = "SELECT username, access FROM USER";
				
				Statement stmt = con.prepareStatement(query);
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

				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
	

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

		
		public int numberOfFlights(){
			int maxCapacity = 0;
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");

				String query = "SELECT COUNT(*) FROM FLIGHT";
				
				Statement stmt = connection.prepareStatement(query);
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
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");

				String query = "SELECT * FROM FLIGHT";

				Statement stmt = connection.prepareStatement(query);
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
			String sql = "Select * from FLIGHT";
			Statement stmt = connection.prepareStatement(sql);
			ResultSet rst;
			rst = stmt.executeQuery(sql);
			ArrayList<Flight> flightlist = new ArrayList<>();
			while(rst.next()){
				Flight flight = new Flight(rst.getInt("flightNumber"), rst.getString("fromAirport"), rst.getString("toAirport"), rst.getString("departDate"),
						rst.getString("arriveDate"), rst.getString("departTime"), rst.getString("arriveTime"), rst.getInt("maxCapacity"), rst.getInt("numberOfPassengers"));
			}
			return flightlist;
		}
			
		//Selects all flights from list of arrays
		public ArrayList<Flight> getFlightList() throws ClassNotFoundException, SQLException {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
			String sql = "Select * from FLIGHT";
			Statement stmt = connection.prepareStatement(sql);
			ResultSet rst;
			rst = stmt.executeQuery(sql);
			String list;
			ArrayList<Flight> flightlist = new ArrayList<>();
			while(rst.next()){
			//	list.concat(rst.toString());
			}
			return flightlist;
		}
		

	
		
		
		
		
		
		//joining tables
		//("SELECT flightNumber FROM flight JOIN user WHERE ssn = '"+getSSN+"');
		
		
		
		
		
		
		
		
		
		
		
//FLIGHT UPDATES			
			
			//Update toAirport
			public Connection editFlightToAirport(int flightNumber, String toAirport) {	
					try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
				String updateFlight = ("UPDATE flight SET toAirport = '"+toAirport+"' WHERE flightNumber = "+flightNumber+"");
				
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
				
		
			
			//update fromAirport	
			public Connection editFlightFromAirport(int flightNumber, String fromAirport) {	
					try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
				String updateFlight = ("UPDATE flight SET fromAirport = '"+fromAirport+"' WHERE flightNumber = "+flightNumber+"");
				
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
			
			
			//update departDate	
			public Connection editFlightDepartDate(int flightNumber, String departDate) {	
					try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
				String updateFlight = ("UPDATE flight SET departDate = '"+departDate+"' WHERE flightNumber = "+flightNumber+"");
				
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
			
			
			//update arriveDate	
			public Connection editFlightArriveDate(int flightNumber, String arriveDate) {	
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
				String updateFlight = ("UPDATE flight SET arriveDate = '"+arriveDate+"' WHERE flightNumber = "+flightNumber+"");
				
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
			
			
			
			
			//update departTime	
			public Connection editFlightDepartTime(int flightNumber, String departTime) {	
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
				String updateFlight = ("UPDATE flight SET departTime = '"+departTime+"' WHERE flightNumber = "+flightNumber+"");
				
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
			
			
			
			
			//update arriveTime	
			public Connection editFlightArriveTime(int flightNumber, String arriveTime) {
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
				String updateFlight = ("UPDATE flight SET arriveTime = '"+arriveTime+"' WHERE flightNumber = "+flightNumber+"");
				
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
			
			
			//for new and delete, leave out parenthesis 
			public Connection deleteFlight(int flightNumber) {
				
				connection = null;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
					
					String deleteFlight = "DELETE FROM flight WHERE flightNumber = "+flightNumber+"";
					
					Statement stmt = connection.prepareStatement(deleteFlight);
					// stmt.executeUpdate(text);
					stmt.execute(deleteFlight);
					System.out.println("PUSHED");

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				return connection;
			}
	
			
			
			
			
			
			
				
	}

			
