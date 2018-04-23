package gsu.edu.cis2370.DATABASE;

import Application.DataTypes.Customer;

public class MySqlMethods {

	//1.USERS
	//2.AIRPORT
	//3.FLIGHT
	//4.BOOKING
	
	
	//1.USERS
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
	
	String insertUser = ("INSERT INTO user (ssn , firstName , lastName , email, phoneNumber , username, password, street, city, state, zip, country, securityQuestion, securityAnswer , access) " +
						"Values (" + ssn + "' , '" + firstName + "' , '" + lastName + "' , '" + email + "','" + phoneNumber + "','" 
				+ username + "','" + password + "','" + street + "','" + city + "','" + state + "','" + zip + "','" + country + "','" 
						+ securityQuestion + "','" + securityAnswer + "','" + access + "','"); 
	
	String selectUser = ("INSERT INTO user (ssn , firstName , lastName , email, phoneNumber , username, password, street, city, state, zip, country, securityQuestion, securityAnswer , access)" +
			 "SELECT ( . . . )" +
			 "FROM ( . . . ) " +
			 "WHERE (. . . )");
	
	String updateUser = ("UPDATE user SET firstName = ('Test') WHERE ssn = 567530900 ");
	     
	String deleteUser = ("DELETE FROM user +"
			+ "WHERE firstName = 'Test' ");	
	
	
	 public static void insertUser(User User)
	    {
	        try{
	            statement.executeUpdate("INSERT INTO user VALUE(default, '" + user.getSSN() + "', '" + customer.getLast_name() + "', "
	                    + customer.getAge() + ", '" + customer.getPassport_number() + "', '" + customer.getPhone_nr() + "');");
	            customers.add(customer);
	            customer.setCustomer_id(customers.indexOf(customer) + 1);
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	
	
	
	
}
