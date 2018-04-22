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
	public void register (int ssn, String firstName, String lastName, int phone){
		//creates a user class to assign values to the attributes that were just passed to this object
		User user = new User(ssn, firstName, lastName, phone){};
		TESTCLASS tc = new TESTCLASS();

		System.out.println("user.getSSN: " + user.getSSN());
		
		//uses getSSN from the user class that was just created
		tc.newUser(user.getSSN(), user.getFirstName(), user.getLastName(), user.getPhone());
	}
	
	
	
	public boolean checkAccount(){
		return false;
	}
	
	public void testPrint(String txt){
		System.out.println(txt);
	}
	
	
}
	
	
	
	
	
