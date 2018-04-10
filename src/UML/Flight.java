package UML;

import java.util.Date;

public class Flight {
	private String fromCity;
	private String fromAirport;
	private String toCity;
	private String toAirport;
	

	private Date departureDate;
	private Date arrivalDate;
	
	private Date departureTime;
	private Date arrivalTime;
	
	private int numberOfPassengers;

	private int flightNumber;
	
	private String planeType;
	
	
	Plane p1 = new Plane();
	
	//getting size of the plane
	private Passenger [] seats = new Passenger [p1.getSize()];
	
	
	
}
