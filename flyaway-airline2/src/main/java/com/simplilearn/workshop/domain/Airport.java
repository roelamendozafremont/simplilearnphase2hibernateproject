package com.simplilearn.workshop.domain;

public class Airport {

	private String code;
	private String name;	
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private int id;
	
	public int getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Airport(String code, String name, String street, String city, String state, String country, String zipCode) {
		super();
		this.code = code.toUpperCase();
		this.name = name.toUpperCase();
		this.street = street.toUpperCase();
		this.city = city.toUpperCase();
		this.state = state.toUpperCase();
		this.country = country.toUpperCase();
		this.zipCode = zipCode.toUpperCase();
	}

	@Override
	public String toString() {
		return "Airport Domain [id=" + id + ",code=" + code + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + "]";
	}

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
