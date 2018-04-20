package gsu.edu.cis2370.DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {
	
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
		
		
		   // Load the JDBC driver
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("Driver loaded");
		   
		// Establish a connection, enter personal user name and password for connection
		//AdventureAwaits" , "username", "password");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
		System.out.println("Database connected");
	
	
	
		/*String user = ("CREATE TABLE USER" +
				"(ssn INTEGER not NULL ," +
				" firstName VARCHAR(20), " +
				" lastName VARCHAR(30), " +
				" email VARCHAR(100), " +
				" phone INTEGER not NULL, " +
				" username VARCHAR(20), " +
				" password VARCHAR(25), " +
				" street VARCHAR(100), " +
				" city VARCHAR(50), " +
				" state VARCHAR(50), " +
				" zip VARCHAR(5), " +
				" country VARCHAR(50), " +
				" securityQuestion VARCHAR(500), " +
				" securityAnswer VARCHAR(200), " +
				" access VARCHAR(8), " +
				" PRIMARY KEY (ssn))");*/








		String flight = ("CREATE TABLE FLIGHT" +
				"(flightNumber INTEGER not NULL ," +
				" fromAirport VARCHAR(50), " +
				" toAirport VARCHAR(50), " +
				" departDate VARCHAR (50), " +
				" arriveDate VARCHAR(50), " +
				" departTime VARCHAR(50), " +
				" arriveTime VARCHAR(50), " +
				"maxCapacity INTEGER not NULL ,"+
				"numberOfPassengers INTEGER not NULL ," +
				" PRIMARY KEY (flightNumber))");



		String airport = ("CREATE TABLE AIRPORT" +
				"(airportCode VARCHAR(3) ," +
				" name VARCHAR(225), " +
				" cityAirport VARCHAR(200) , " +
				" stateAirport VARCHAR(225), " +
				" PRIMARY KEY (airportCode))");




		String booking = ("CREATE TABLE BOOKING" +
				"(confirmationNumber INTEGER not NULL ," +
				" PRIMARY KEY (confirmationNumber))");
		
		/*String bookingForeign = ("ALTER TABLE BOOKING" +
	    "ADD [CONSTRAINT [symbol]] FOREIGN KEY" +
	    "[index_name] (index_col_name, ...)"+
	    "REFERENCES tbl_name (index_col_name,...)" +
	    "[ON DELETE reference_option]" +
	    "[ON UPDATE reference_option]" ); */






//Statement statement = connection.prepareStatement(user);
//Statement statement = connection.prepareStatement(flight);
//Statement statement = connection.prepareStatement(airport);
//Statement statement = connection.prepareStatement(booking);

//statement.executeUpdate(user);
//statement.executeUpdate(flight);
statement.executeUpdate(airport);
//statement.executeUpdate(booking);


	
	
	
}
}