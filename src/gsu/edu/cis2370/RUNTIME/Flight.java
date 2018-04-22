package gsu.edu.cis2370.RUNTIME;

import java.util.Date;

public class Flight{
	
	private int flightNumber;
	private String fromAirport;
	private String toAirport;
	private String departureDate;
	private String arrivalDate;
	private String departureTime;
	private String arrivalTime;
	private int numberOfPassengers;
	private int maxCapacity;
	
	
	
	
	/*
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	
	
	Flight (int flightID, String fromAirport, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime){
		this.flightID = flightID;
		this.fromAirport = fromAirport;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}
	*/
	public Flight(){
		
	}
	
	public Flight (int flightNumber, String fromAirport, String toAirport, String departureDate, String arrivalDate, String departureTime,  String arrivalTime, int maxCapacity, int numberOfPassengers){
		this.flightNumber = flightNumber;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.maxCapacity = maxCapacity;
		this.numberOfPassengers = numberOfPassengers;
	}
	
	

	public String getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}

	public String getToAirport() {
		return toAirport;
	}
	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}




	
	
	//getting size of the plane
	//private User [] seats = new User [p1.getSize()];
	
	
	
}
