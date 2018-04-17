package gsu.edu.cis2370.RUNTIME;



public class textInput {
	

	/*
	 * Regrex Expressions
	 * 
^                 # start-of-string
(?=.*[0-9])       # a digit must occur at least once
(?=.*[a-z])       # a lower case letter must occur at least once
(?=.*[A-Z])       # an upper case letter must occur at least once
(?=.*[@#$%^&+=])  # a special character must occur at least once
(?=\S+$)          # no whitespace allowed in the entire string
.{8,}             # anything, at least eight places though
$                 # end-of-string
	 * 
	 * 
	 * 
	 *Email: [a-z0-9._]+@[a-z.-]+\.[a-z]{2,6}
	 *Pattern.compile([A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}, Pattern.CASE_INSENSITIVE);
	 *First name: [a-z]
	 *Last name: [a-z]
	 *Phone Number: [0-9]{3}+-+[0-9]{3}+-+[0-9]{4}
	 *SSN: [0-9]{3}+-+[0-9]{2}+-+[0-9]{4}
	 *User Name: [a-zA-Z0-9._]
	 *Password: (?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^<>!+-_&])(?=\S+$).{12,20}
	 *Address: .*[0-9a-z.]
	 *Zip: [0-9]{5}
	 *State: [A-Za-z]{2}
	 *Country: [USAusa]{3} //ONLY COUNTRY CODES
	 *
	 */
	
	


}
