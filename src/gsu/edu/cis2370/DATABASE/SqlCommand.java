package gsu.edu.cis2370.DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlCommand {
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
		
		
		   // Load the JDBC driver
		   Class.forName("com.mysql.jdbc.Driver");
		   System.out.println("Driver loaded");
		   
		// Establish a connection, enter personal user name and password for connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AdventureAwaits", "root", "ch3y3nn3");
		System.out.println("Database connected");
		
		
		// INSERT into USER Attributes: ssn, FirstName, LastName, email, phone#, 
		//username, password, street, city, state, zip, country, security question, security answer
		//access = auto as customer
		//manually create admin account
		
		String ssn;
		String firstName;
		String lastName;
		String email;
		String phoneNumber;
		String username; 
		String password;
		String street;
		String city;
		String state;
		String zip;
		String country;
		String securityQuestion;
		String securityAnswer;
		String access;
		
		String user = ("INSERT into USER (ssn , firstName , lastName , email, phoneNumber , username, password, street, city, state, zip, country, securityQuestion, securityAnswer , access) " +
							"Values (" + ssn + "' , '" + firstName + "' , '" + lastName + "' , '" + email + "','" + phoneNumber + "','" 
					+ username + "','" + password + "','" + street + "','" + city + "','" + state + "','" + zip + "','" + country + "','" 
							+ securityQuestion + "','" + securityAnswer + "','" + access + "','"); 
							 
		
							
		// INSERT into PLANE Attributes: planeId , type , maxSize , currentSize, status
			
			
		String planeId;
		String type;
		String maxSize;
		String currentSize;
		String status;
			
			
		String plane = ("INSERT into PLANE (planeId , type , maxSize , currentSize , status )" +
							"Values (" + planeId + "' , '" + type + "','" + maxSize + "','"+ currentSize + "','"+ status + "','"); 						
							
							
		// INSERT into FLIGHTS Attributes: flightNumber , fromCity , toCity , fromAirport, toAirport
		//departDate , arriveDate , departTime , arriveTime , planeType
		
		String flightNumber;
		String fromCity;
		String toCity; 
		String fromAirport;
		String toAirport;
		String departDate; 
		String arriveDate;
		String departTime; 
		String arriveTime;
		String planeType;
		
			
			
		String flights = ("INSERT into PLANE (flightNumber , fromCity , toCity , fromAirport , toAirport , departDate , ariveDate , departTime , arriveTime , planeType )" +
							"Values (" + flightNumber + "' , '" + fromCity + "','" + toCity + "','"+ fromAirport + "','"+ toAirport + "','" + departDate + "','" + arriveDate + "','" + departTime + "','"+ arriveTime + "','"+ planeType + "','"); 	
		
	
		// INSERT into AIRPORT Attributes: airportCode , name , street , city , state , zip , country , checkSeat
				
		String airportCode;
		String name;
		String street; 
		String city;
		String state;
		String zip;
		String country;
		String checkSeat;
				
					
					
		String airport = ("INSERT into BOOKING (airportCode , name , street , checkSeat , searchFlights )" +
									"Values (" + airportCode + "' , '" + name + "','" + assignPassenger + "','"+ checkSeat + "','"+ searchFlights + "','"); 
		/*
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('SFO', 'San Francisco International Airport', 'San Francisco', 'CA');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('DEN', 'Denver International Airport', 'Denver', 'CO');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('LAS', 'McCarran International Airport', 'Las Vegas', 'NV');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('LGA', 'La Guardia Airport', 'New York', 'NY');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('IAH', 'George Bush Intercontinental Airport', 'Houston', 'TX');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('LAX', 'Los Angeles International Airport', 'Los Angeles', 'CA');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('JNU', 'Juneau International Airport', 'Juneau', 'AK');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('PHX', 'Phoenix Sky Harbor International Airport', 'Phoenix', 'AZ');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('IAD', 'Dulles International Airport', 'Washington', 'DC');
		INSERT INTO `AdventureAwaits`.`AIRPORT` (`airportCode`, `name`, `cityAirport`, `stateAirport`) VALUES ('MIA', 'Miami International Airport', 'Miami', 'FL');
		*/




	
	}
}
