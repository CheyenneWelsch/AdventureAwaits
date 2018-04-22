package gsu.edu.cis2370.RUNTIME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class User {
	private String firstName;
	private String lastName;
	private String street;
	private int zip;
	private String state;
	private String userName;
	private String password;
	private String email;
	private String city;
	private int phone;
	private String country;

	private int SSN;
	// after implementing text boxes, maybe look for a way to have dashes to get
	// rid of need for string to int

	private String securityQuestion;
	private String securityAnswer;

	
	public User(int ssn, String firstName, String lastName, String email, int phone, String userName, String password, 
			String street, String city, String state, int zip, String country, String securityQuestion, String securityAnswer){
		this.SSN = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	
	//default constructor
	public User() {
		this(999999, "First", "Last","emailaddress@email.email", 555 ,"user", "password", 
				"000 Fake Street", "Atlanta", "GA", 00000, "USA", "Is this a question?", "Yes");
		}
	
	
	public User(int ssn, String firstName, String lastName, int phone){
		this.SSN = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		System.out.println("User created2");
		
	}
	//TEST
	public User(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("User created");
		
	}
	
	public int getSSN(){
		return SSN;
	}
	
	public void setSSN(int SSN) {
		this.SSN = SSN;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = firstName;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getStreet(){
		return street;
	}

	public String getState(){
		return state;
	}
	
	public int getZip(){
		return zip;
	}
	public String getCity(){
		return city;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	
	public int getPhone(){
		return phone;
	}
	
	public void setPhone(int phone){
		this.phone = phone;
	}

	
	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	
	public String getSecurityAnswer(){
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
