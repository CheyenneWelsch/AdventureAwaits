package gsu.edu.cis2370.RUNTIME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TESTCLASS {

	private Connection connection;

	public Connection newUser(int ssn, String firstName, String lastName, int phone){
		connection = null;
		try{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
		System.out.println("Database connected1111");
		
		
		//String text = "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES(?,?,?,?)";
		// ('" + ssn + "`, `" + firstName + "`,`" + lastName + "``" + phone + "')");
		//PreparedStatement preState = connection.prepareStatement(text);
		//preState.setString(1, ssn);
		
		//String text = "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES('" + ssn + "` , `" + firstName + "` , `" + lastName + "` , `" + phone + "')";
		String text = "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, 'lastName', `phone`) VALUES('" + 000000004 + "` , `" + firstName + "` , `" + lastName + "` , `" + 404 + "')";
		Statement stmt = connection.prepareStatement(text);
		//stmt.executeUpdate(text);
		stmt.execute(text);
		System.out.println("PUSHED");
		
		
		
		
		
		
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public Connection getUser(){
		connection = null;
		try{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
		System.out.println("Database connected1111");
		
		
		//String text = "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES(?,?,?,?)";
		// ('" + ssn + "`, `" + firstName + "`,`" + lastName + "``" + phone + "')");
		//PreparedStatement preState = connection.prepareStatement(text);
		//preState.setString(1, ssn);
		
		//String text = "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES('" + ssn + "` , `" + firstName + "` , `" + lastName + "` , `" + phone + "')";
		String text = "SELECT * FROM Users WHERE CustomerName='Max';)";
		Statement stmt = connection.prepareStatement(text);
		
		
		stmt.executeUpdate(text);
		System.out.println("PUSHED");
		
		
		
		
		
		
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException {
	 // Load the JDBC driver
		
	   Class.forName("com.mysql.jdbc.Driver");
	   System.out.println("Driver loaded");
	   
	// Establish a connection, enter personal user name and password for connection
	//AdventureAwaits" , "username", "password");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
	System.out.println("Database connected");

	
	//Statement statement = connection.prepareStatement(toBase());
	//statement.executeUpdate(toBase());
	
	
	}
	
	public static String toBase(int ssn, String user, int phone){
		return ("INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES ('" + ssn + "`, `" + user + "`, `" + phone + "')");
		//return text;
	}
	
	
	
	/*
	public void statement() throws SQLException, ClassNotFoundException{
		ValueObject vo = new ValueObject();
		

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
		String text1 = "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES ('" + vo.getSSN() + "`, `" + vo.getFirstName() + "`, `" + vo.getPhone() + "')";
		//String text = toBase(vo.getSSN(), vo.getFirstName(), vo.getPhone());
		Statement statement = connection.prepareStatement(text1);
		statement.executeUpdate(text1);
	}
	*/
}
