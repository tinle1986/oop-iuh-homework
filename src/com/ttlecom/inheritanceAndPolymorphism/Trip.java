package com.ttlecom.inheritanceAndPolymorphism;

class Trip {
	private int id;
	private String driverName;
	private String carNumber;
	private float revenue;

	public Trip() {
	}

	public Trip(int id, String driverName, String carNumber) {
		this.id = id;
		this.driverName = driverName;
		this.carNumber = carNumber;
	}

	public int getId() {
		return id;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
}
