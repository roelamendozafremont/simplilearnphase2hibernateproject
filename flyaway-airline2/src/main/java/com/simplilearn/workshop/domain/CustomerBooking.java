package com.simplilearn.workshop.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class CustomerBooking {


	private String bookingNumber;
	private int id;
	private java.util.Date flightDate;
	private String origin;
	private String destination;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private String emailId;
	private int age;
	private String sex;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String flightCode;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public CustomerBooking(java.util.Date flightDate, String origin, String destination, String firstName, String middleName, String lastName,
			String phoneNumber, String emailId, int age, String sex, String street,
			String city, String state, String country, String zipCode, String flightCode) {
		super();
		this.flightDate = flightDate;
		this.origin = origin.toUpperCase();
		this.destination = destination.toUpperCase();
		this.firstName = firstName.toUpperCase();
		this.middleName = middleName.toUpperCase();
		this.lastName = lastName.toUpperCase();
		this.phoneNumber = phoneNumber.toUpperCase();
		this.emailId = emailId.toUpperCase();
		this.age = age;
		this.sex = sex.toUpperCase();
		this.street = street.toUpperCase();
		this.city = city.toUpperCase();
		this.state = state.toUpperCase();
		this.country = country.toUpperCase();
		this.zipCode = zipCode.toUpperCase();
		this.flightCode = flightCode.toUpperCase();
		this.bookingNumber = this.generateBookingNumber();
	}

	@Override
	public String toString() {
		return "CustomerBooking Domain [id=" + id + ",flightDate =" + flightDate.toString() 
				+ ", origin=" + origin + ", destination=" + destination + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ",  age=" + age + ", sex=" + sex + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode + ", flightCode=" + flightCode
				+  ", bookingNumber=" + bookingNumber + "]";
	}
	
	public String generateBookingNumber() {

		int length = 8;
		String digits = "0123456789";
		String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + digits ;
		Random rnd = new Random();
		List<String> result = new ArrayList<>();
		Consumer<String> appendChar = s -> result.add("" + s.charAt(rnd.nextInt(s.length())));
		appendChar.accept(digits);
		while (result.size() < length)
			appendChar.accept(all);
		Collections.shuffle(result, rnd);
		String str = String.join("", result);
		return str;

	}

	public CustomerBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
