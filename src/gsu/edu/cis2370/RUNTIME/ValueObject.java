package gsu.edu.cis2370.RUNTIME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import gsu.edu.cis2360.GUI.*;
import gsu.edu.cis2370.DATABASE.*;


public class ValueObject{
	
	public SignUp signUp = new SignUp();
	
	//User Object
	User user = new User(getSSN(), getFirstName(), getLastName(), getPhone()){};
	
	public ValueObject(){	
	}
	
	
	

	
	public void register ()throws NumberFormatException{
		TESTCLASS tc = new TESTCLASS();
		int ssn = Integer.parseInt(signUp.ssnBOX.getText());
		int phone = Integer.parseInt(signUp.phoneBOX.getText());
	
		System.out.println("user.getSSN: " + user.getSSN());
		//tc.newUser(user.getSSN(), "Max", "Xam", user.getPhone());
		tc.newUser(user.getSSN(), user.getFirstName(), user.getLastName(), user.getPhone());
	}
	
	
	public int getSSN(){
		String text = signUp.ssnBOX.getText();
		int ssn = Integer.parseInt(text);
		return ssn;
	}
	
	public String getFirstName(){
		String text = signUp.firstNameBOX.getText();
		return text; 
	}
	
	
	public String getLastName(){
		String text = signUp.lastNameBOX.getText();
		return text; 
	}
	
	public int getPhone(){
		String text = signUp.phoneBOX.getText();
		int phone = Integer.parseInt(text);
		return phone;
	}
	
	
	public boolean duplicateCheck(String x, String y){
		if(x.equals(y)){
			return false;
		}else{
			return true;
		}
	}
	
	
	/*
	public void createAccount(){
		User user = new User(){
			};
		TESTCLASS tc = new TESTCLASS();
		int ssn = Integer.parseInt(signUp.ssnBOX.toString());
		user.setSSN(ssn);
		user.setName(signUp.firstNameBOX.toString(), signUp.lastNameBOX.toString());
		int phone = Integer.parseInt(signUp.phoneBOX.toString());
		user.setPhone(phone);
		tc.toBase(user.getSSN(), user.getFirstName(), user.getPhone());
	}
	
	
	public void createAccount(){
		
		//duplicateCheck(this.user.setSSN(signUp.ssnBOX.toString()),  pull SSN somehow);
		//if yes, continue, if false, return text from button press
		this.user.setName(signUp.firstNameBOX.toString(), signUp.lastNameBOX.toString());
		
		this.user.setUserName(signUp.userTextField.toString());
		this.user.setPassword(signUp.pwBOX.toString());
		
		//since setAddress needs an int value, the next line converts the string to an int
		int zip =Integer.parseInt(signUp.zipBOX.toString());
		this.user.setAddress(signUp.addressBOX.toString(), signUp.stateBOX.toString(), zip);
		this.user.setSecurityQuestion(signUp.securityQBOX.toString());
		this.user.setSecurityAnswer(signUp.securityQBOX.toString());
		this.user.setEmail(signUp.emailBOX.toString());
		
	}
	*/
	
	
	
	
	public boolean checkAccount(){
		return false;
	}
	
	public void testPrint(String txt){
		System.out.println(txt);
	}
	
	
}
	
	
	
	
	
