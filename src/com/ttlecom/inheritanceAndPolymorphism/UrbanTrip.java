package com.ttlecom.inheritanceAndPolymorphism;

public class UrbanTrip extends Trip {
	private int numberOfRoutes;
	private float distance;

	public UrbanTrip(int id, String driverName, String carNumber, int numberOfRoutes, float distance) {
		super(id, driverName, carNumber);
		this.numberOfRoutes = numberOfRoutes;
		this.distance = distance;
		calculateRevenue();
	}

	public int getNumberOfRoutes() {
		return numberOfRoutes;
	}

	public float getDistance() {
		return distance;
	}

	public void setNumberOfRoutes(int numberOfRoutes) {
		this.numberOfRoutes = numberOfRoutes;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return String.format("ID: %s | Driver name: %s | Distance: %,.2f | Revenue: %,.2f%n", getId(), getDriverName(), getDistance(), getRevenue());
	}

	public void calculateRevenue() {
		float revenue = getDistance() * 15000;
		super.setRevenue(revenue);
	}
}
