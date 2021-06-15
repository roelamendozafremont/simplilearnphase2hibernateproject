package com.simplilearn.workshop.domain;

public class Iterenary {

	private java.util.Date flightDate;
	private String origin;
	private String destination;
	private int seatsAvailable;
	private String airline;
	private float fare;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Iterenary(java.util.Date flightDate, String origin, String destination, Integer seatsAvailable, String airline,
			Float fare) {
		super();
		this.flightDate = flightDate;
		this.origin = origin.toUpperCase();
		this.destination = destination.toUpperCase();
		this.seatsAvailable = seatsAvailable;
		this.airline = airline.toUpperCase();
		this.fare = fare;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public java.util.Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(java.util.Date flightDate) {
		this.flightDate = flightDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Iterenary Domain [id=" + id + ",flightDate=" + flightDate + ", origin=" + origin
				+ ", destination=" + destination+ ", seatsAvailable=" + seatsAvailable + ", flightCode="
				+ airline + ", fare=" + fare + "]";
	}

	public Iterenary() {
		super();
		// TODO Auto-generated constructor stub
	}

}
