package gsu.edu.cis2370.DATABASE;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

import gsu.edu.cis2370.RUNTIME.TESTCLASS;

public class SQLTesting {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	
	//Generics shifts the issue from a runtime error to a compile time error
	//can only pass strings without casting
	
	ArrayList<SQLTesting> list = new ArrayList<SQLTesting>();
	
	//behind the scenes of a dynamic array: gives the best performance. 
	//When it fills, it doubles it, fills existing, and
	//provides you with the same amount of new spots
	
	TESTCLASSDOS abc = new TESTCLASSDOS ();
	abc.newFlight(11, "ATL", "DEN", "05/03/2018", "05/03/2018", "08:00", "12:00", 200, 100);
	System.out.println("Hello");
	
	abc.deleteFlight(8);
	
	
	TESTCLASSDOS abcd = new TESTCLASSDOS ();
	abcd.editFlightDepartTime(9,"06:00");
	
	}	
}
