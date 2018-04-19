package gsu.edu.cis2370.DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
		
		
		   // Load the JDBC driver
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("Driver loaded");
		   
		// Establish a connection, enter personal user name and password for connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
		System.out.println("Database connected");
		
		
		
		// Create a statement
		Statement statement = connection.createStatement();
		
		// Execute a statement
		//ResultSet resultSet = statement.executeQuery;
		
		/*
		//USER TABLE 
		String user = ("CREATE TABLE USER" +
						"(ssn INTEGER not NULL ," +
						" firstName VARCHAR(225), " +
						" lastName VARCHAR(225), " +
						" email VARCHAR(225), " +
						" phone INTEGER not NULL, " +
						" username VARCHAR(225), " +
						" password VARCHAR(225), " +
						" street VARCHAR(225), " +
						" city VARCHAR(225), " +
						" state VARCHAR(225), " +
						" zip VARCHAR(225), " +
						" country VARCHAR(225), " +
						" securityQuestion VARCHAR(225), " +
						" securityAnswer VARCHAR(225), " +
						" access VARCHAR(225), " +
						" PRIMARY KEY (ssn))");
		
		statement.executeUpdate(user);
		*/
		
		
		
		
	
		String flight = ("CREATE TABLE FLIGHTS" +
				"(flightNumber INTEGER not NULL ," +
				" fromCity VARCHAR(225), " +
				" toCity VARCHAR(225), " +
				" fromAirport VARCHAR(225), " +
				" toAirport VARCHAR(225), " +
				" departDate VARCHAR(225), " +
				" arriveDate VARCHAR(225), " +
				" departTime VARCHAR(225), " +
				" arriveTime VARCHAR(225), " +
				"planeType VARCHAR(225) ,"+
				" PRIMARY KEY (flightNumber))");



String airport = ("CREATE TABLE AIRPORT" +
		"(airportCode VARCHAR(3) ," +
		" name VARCHAR(225), " +
		" street VARCHAR(225), " +
		" city VARCHAR(225), " +
		" state VARCHAR(225), " +
		" zip VARCHAR(225), " +
		" country VARCHAR(225), " +
		"checkSeat INTEGER not NULL ,"+
		" PRIMARY KEY (airportCode))");




String booking = ("CREATE TABLE BOOKING" +
		"(confirmationNumber INTEGER not NULL ," +
		" flightnumb INTEGER not NULL, " +
		" assignPassenger VARCHAR(225), " +
		" checkSeat VARCHAR(225), " +
		" searchFlights VARCHAR(225), " +
		" PRIMARY KEY (confirmationNumber))");



String plane = ("CREATE TABLE PLANE" +
		"(planeid INTEGER not NULL ," +
		" type VARCHAR(225), " +
		" maxsize INTEGER not NULL, " +
		" currentsize INTEGER, " +
		" status VARCHAR(225), " +
		" PRIMARY KEY (planeid))");

statement.executeUpdate(flight);
statement.executeUpdate(airport);
statement.executeUpdate(booking);
statement.executeUpdate(plane);





connection.close();



	}
}
