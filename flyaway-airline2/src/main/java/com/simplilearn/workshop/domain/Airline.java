package com.simplilearn.workshop.domain;

public class Airline {

	private String code;
	private String name;
	private String planeType;
	private int seatCapacity;
	private int id;
	
	public int getId() {
		return id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public Airline(String code, String name, String planeType, int seatCapacity) {
		super();
		this.code = code.toUpperCase();
		this.name = name.toUpperCase();
		this.planeType = planeType.toUpperCase();
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Airline Domain [id=" + id + ",code=" + code + ", name=" + name + ", planeType=" + planeType + ", seatCapacity="
				+ seatCapacity + "]";
	}

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}

}
