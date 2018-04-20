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
		
			String sql = ("INSERT into USER (ssn , firstName , lastName , email, phoneNumber , username, password, "
					+ "street, city, state, zip, country, securityQuestion, securityAnswer , access) " 
							"Values (" + ssn + "' , '" + firstName + "' , '" + lastName + "' , '" + email + "','" + phoneNumber + "','" 
					+ username + "','" + password + "','" + street + "','" + city + "','" + state + "','" + zip + "','" + country + "','" 
							+ securityQuestion + "','" + securityAnswer + "','" + access + "','"); 
							 
		
							
							
							
							
		//Prepare a statement
		Statement statement = connection.prepareStatement(sql);
							
		
							
		
		// Execute a statement
		//ResultSet resultSet = statement.executeQuery;
		
		
	
	





connection.close();



	}

	private static String getText(Object userNameBox) {
		// TODO Auto-generated method stub
		return null;
	}
}
