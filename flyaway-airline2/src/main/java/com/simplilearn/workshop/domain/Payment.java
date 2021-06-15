package com.simplilearn.workshop.domain;

public class Payment {

	private java.util.Date billDate;
	private String firstName;
	private String middleName;
	private String lastName;
	private String cardNumber;
	private String expirationDate;
	private String cvcCode;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private float amount;
	private int id;
	private String bookingNumber;
	
	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getBillDate() {
		return billDate;
	}

	public void setBillDate(java.util.Date billDate) {
		this.billDate = billDate;
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(String cvcCode) {
		this.cvcCode = cvcCode;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Payment(java.util.Date billDate, String firstName, String middleName, String lastName, String cardNumber,
			String expirationDate, String cvcCode, String street, String city, String state, String country, String zipCode,
			float amount, String bookingNumber) {
		super();
		this.billDate = billDate;
		this.firstName = firstName.toUpperCase();
		this.middleName = middleName.toUpperCase();
		this.lastName = lastName.toUpperCase();
		this.cardNumber = cardNumber.toUpperCase();
		this.expirationDate = expirationDate;
		this.cvcCode = cvcCode;
		this.street = street.toUpperCase();
		this.city = city.toUpperCase();
		this.state = state.toUpperCase();
		this.country = country.toUpperCase();
		this.zipCode = zipCode.toUpperCase();
		this.amount = amount;
		this.bookingNumber = bookingNumber;
	}

	@Override
	public String toString() {
		return "Payment Domain [id=" + id + ",bookingNumber=" + bookingNumber + ",billDate=" + billDate + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", cardNumber=" + cardNumber + ", expirationDate=" + expirationDate
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + ", amount=" + amount + "]";
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
