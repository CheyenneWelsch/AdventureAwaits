package gsu.edu.cis2370.RUNTIME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TESTCLASS {

	private Connection connection;

	// add a user to the database
	public Connection newUser(int ssn, String firstName, String lastName, String email, int phone, String username, String password, String street, String city,
			String state, int zip, String country, String securityQuestion, String securityAnswer) {
		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
			System.out.println("Database connected1111");
			
			
			String text2 = "INSERT INTO USER(`ssn`, `firstName`, `lastName`, `email`, `phone`, `username`, `password`, `street`, `city` , `state` , `zip` , `country` , `securityQuestion` , `securityAnswer` , `access`) "
					+ "VALUES('" + ssn + "`, `" + firstName + "`, `" + lastName + "`, `" + email + "`, `" + phone + "`, `" + username + "`, `" + password 
					+ "`, `" + street + "`, `" + city + "`, `" + state + "`, `" + zip + "`, `" + country + "`, `" + securityQuestion + "`, `" + securityAnswer + "`, `C` ) ";
			
			
			String text = "INSERT INTO USER(ssn, firstName, lastName, email, phone, username, password, street, city, state, zip, country, securityQuestion, securityAnswer, access) "
					+ "VALUES(" + ssn + ", '" + firstName + "', '" + lastName + "', '" + email + "', " + phone + ", '" + username + "', '" + password 
					+ "', '" + street + "', '" + city + "', '" + state + "', " + zip + ", '" + country + "', '" + securityQuestion + "', '" + securityAnswer + "', 'C' ) ";
			
			Statement stmt = connection.prepareStatement(text);
			// stmt.executeUpdate(text);
			stmt.execute(text);
			System.out.println("PUSHED");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	//check the username and password, return as false if there is not a match
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

	//prints out the user information. Can use this as a template to get individual results
	public boolean checkAccess(String user){
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
				String access = rs.getString("access");
				
				if(access.equals("A")){
					check = 1;
					break;
				}else{
					break;
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

	// boolean isAdmin = rs.getBoolean("is_admin");

	/*
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Load the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");

		// Establish a connection, enter personal user name and password for
		// connection
		// AdventureAwaits" , "username", "password");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "bismarck");
		System.out.println("Database connected");
		System.out.println("Get User:");
		getUserInfo();
		System.out.println("Get User Check");
		//System.out.println(getUser("mmax", "max"));
		//System.out.println(validateUser("mmax", "max"));

		// Statement statement = connection.prepareStatement(toBase());
		// statement.executeUpdate(toBase());

	}
*/
	public static String toBase(int ssn, String user, int phone) {
		return ("INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES ('" + ssn + "`, `" + user + "`, `"
				+ phone + "')");
		// return text;
	}

	/*
	 * public void statement() throws SQLException, ClassNotFoundException{
	 * ValueObject vo = new ValueObject();
	 * 
	 * 
	 * Connection connection =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
	 * "bismarck"); String text1 =
	 * "INSERT INTO `mydb`.`USER` (`ssn`, `firstName`, `phone`) VALUES ('" +
	 * vo.getSSN() + "`, `" + vo.getFirstName() + "`, `" + vo.getPhone() + "')";
	 * //String text = toBase(vo.getSSN(), vo.getFirstName(), vo.getPhone());
	 * Statement statement = connection.prepareStatement(text1);
	 * statement.executeUpdate(text1); }
	 */
}
