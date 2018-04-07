package UML;

public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private int zip;
	private String state;
	private String userName;
	private String password;

	
	private String SSN;
	// after implementing text boxes, maybe look for a way to have dashes to get
	// rid of need for string to int
	
	private String securityQuestion;
	private String securityAnswer;

	public String getName() {
		return lastName + "," + firstName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
}
