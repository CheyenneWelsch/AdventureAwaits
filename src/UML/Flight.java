package UML;

import java.util.Date;

public class Flight {
	private String destinationCity;
	private String destinationAirport;
	private String arrivalCity;
	private String arrivalAirport;
	
	//LocalDate.of(2018, 08, 21) or LocalDate.parse("2018-08-21") represents a specific day, month, year
	//LocalTime.of(6, 30) or LocalTime.parse("6:30") specific time
	private Date departureDate;
	private Date arrivalDate;
	private Date departureTime;
	private Date arrivalTime;
	
	private int numberOfPassengers;
	private int maxNumberOfPassengers;
	
	
	
	
}
