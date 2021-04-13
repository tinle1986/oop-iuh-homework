package com.ttlecom.inheritanceAndPolymorphism;

public class SuburbanTrip extends Trip {
	private String destination;
	private int numberOfDays;

	public SuburbanTrip(int id, String driverName, String carNumber, String destination, int numberOfDays) {
		super(id, driverName, carNumber);
		this.destination = destination;
		this.numberOfDays = numberOfDays;
		calculateRevenue();
	}

	public String getDestination() {
		return destination;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	@Override
	public String toString() {
		return String.format("ID: %s | Driver name: %s | Destination: %s | Revenue: %,.2f%n", getId(), getDriverName(), getDestination(), getRevenue());
	}

	public void calculateRevenue() {
		float revenue = (float) (getNumberOfDays() * 1200000 * 1.1);
		super.setRevenue(revenue);
	}
}
