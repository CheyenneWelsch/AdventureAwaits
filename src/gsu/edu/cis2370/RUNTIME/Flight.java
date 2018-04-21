package gsu.edu.cis2370.RUNTIME;

import java.util.Date;

public class Flight{
	
	private int flightID;
	private String fromCity;
	private String fromAirport;
	private String toCity;
	private String toAirport;
	
	
	private String departureDate;
	private String arrivalDate;
	private int departureTime;
	private int arrivalTime;
	
	private int numberOfPassengers;
	private int maxCapacity;
	private int flightNumber;
	
	
	
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
	
	
	public Flight (int flightID, String fromAirport, String departureDate, int departureTime, String arrivalDate, int arrivalTime){
		this.flightID = flightID;
		this.fromAirport = fromAirport;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}
	
	
	public int getFlightID(){
		return flightID;
	}
	public void setFlightID(int flightID){
		this.flightID = flightID;
	}
	
	
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getFromAirport() {
		return fromAirport;
	}
	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
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


	public int getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}


	public int getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	
	
	//getting size of the plane
	//private User [] seats = new User [p1.getSize()];
	
	
	
}
