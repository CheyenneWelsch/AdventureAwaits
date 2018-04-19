package gsu.edu.cis2370.DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class User {
	private String firstName;
	private String lastName;
	private String address;
	private int zip;
	private String state;
	private String userName;
	private String password;
	private String email;

	private String SSN;
	// after implementing text boxes, maybe look for a way to have dashes to get
	// rid of need for string to int

	private String securityQuestion;
	private String securityAnswer;
	
	
	// do not want a getSSN method because there is no instance where the system
	// should return that number
	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getFirstName() {
		return firstName;
		String firstName = (INSERT )
	}

	public String getLastName() {
		return firstName;
	}

	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//do not want get Password for security reasons
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress(){
		return address;
	}

	public String getState(){
		return state;
	}
	
	public int getZip(){
		return zip;
	}
	
	public void setAddress(String address, String state, int zip){
		this.address = address;
		this.state = state;
		this.zip = zip;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
}
