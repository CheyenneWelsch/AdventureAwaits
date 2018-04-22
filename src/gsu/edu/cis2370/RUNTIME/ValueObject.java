package gsu.edu.cis2370.RUNTIME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import gsu.edu.cis2370.DATABASE.*;
import gsu.edu.cis2370.GUI.*;


public class ValueObject{
	
	public ValueObject(){	
	}
	
	
	

	//registers a new User
	public void register (int ssn, String firstName, String lastName, String email, int phone, String username, String password, String street, String city,
			String state, int zip, String country, String securityQuestion, String securityAnswer){
		//creates a user class to assign values to the attributes that were just passed to this object
		
		
		User user = new User(ssn, firstName, lastName, email, phone, username, password, street, city, state, zip, country, securityQuestion, securityAnswer){};
		TESTCLASS tc = new TESTCLASS();

		System.out.println("user.getSSN: " + user.getSSN());
		
		
		tc.newUser(user.getSSN(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getUserName(), user.getPassword(), user.getStreet(),
				user.getCity(), user.getState(), user.getZip(), user.getCountry(), user.getSecurityQuestion(), user.getSecurityAnswer());
	}
	
	//checks username format
	public boolean testUser(String s1){
		//if(s1.matches("[a-zA-Z0-9._-]{3,}")){
		if(s1.matches("[a-zA-Z0-9._-].{3,}")){
			return true;
		}else{
			return false;
		}
	}	
		
	//checks password format	
	public boolean testPass(String s1){
		if(s1.matches("(?=.*[0-9a-zA-Z@#$%^&+=]).{8,}")){
			return true;
		}else{
			return false;
		}
	}
	
	//checks Login to see if it matches
	public boolean checkUser(String userName, String pass){
		TESTCLASS tc = new TESTCLASS();
		if(tc.checkAccount(userName, pass) == true){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkAccess(String userName){
		TESTCLASS tc = new TESTCLASS();
		if(tc.checkAccess(userName) == true){
			return true;
		}else{
			return false;
		}
	}
		

	
	public boolean checkAccount(){
		return false;
	}
	
	public void testPrint(String txt){
		System.out.println(txt);
	}
	
	
}
	
	
	
	
	
