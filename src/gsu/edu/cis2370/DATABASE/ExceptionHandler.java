package gsu.edu.cis2370.DATABASE;

import java.sql.SQLException;
import java.util.ArrayList;

import gsu.edu.cis2370.DATABASE.TESTCLASS;
import gsu.edu.cis2370.RUNTIME.ValueObject;

public class ExceptionHandler {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		TESTCLASS tc = new TESTCLASS();
		ValueObject vo = new ValueObject();
		
		ArrayList<String> myF = tc.viewMyFlights("Mmeinhardt");
		System.out.println("Flights: " + myF.toString());
		System.out.println(tc.getDepartureDate(1));
		System.out.println("Success");
		boolean half = vo.checkDates(1);
		System.out.println(half);
	
		boolean check = tc.checkFlightAvailability(2, "Mmeinhardt");
		System.out.println("FLight Check: " + check);
		
		
		tc.deleteUserFlight(1, "Mmeinhardt");
		System.out.println("D E L E TE");
		/*
		 * Calendar c1 = Calendar.getInstance(); Calendar c2 =
		 * Calendar.getInstance(); c1.compareTo(c2); Returns:
		 * 
		 * the value 0 if the time represented by the argument is equal to the
		 * time represented by this Calendar; a value less than 0 if the time of
		 * this Calendar is before the time represented by the argument; and a
		 * value greater than 0 if the time of this Calendar is after the time
		 * represented by the argument.
		 */
	}
}
