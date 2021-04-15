package com.ttlecom.inheritanceAndPolymorphism;

public abstract class Vehicle {
	private int routeId;
	private String carNumber;
	private String driverName;

	public Vehicle(int routeId, String carNumber, String driverName) {
		setRouteId(routeId);
		setCarNumber(carNumber);
		setDriverName(driverName);
	}

	public int getRouteId() {
		return routeId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setRouteId(int routeId) {
		if (routeId <= 0) {
			this.routeId = 99999;
		} else {
			this.routeId = Math.min(routeId, 99999);
		}
	}

	public void setCarNumber(String carNumber) {
		if (carNumber == null || carNumber.isBlank()) {
			this.carNumber = "[EMPTY NUMBER]";
		} else {
			this.carNumber = carNumber;
		}
	}

	public void setDriverName(String driverName) {
		if (driverName == null || driverName.isBlank()) {
			this.driverName = "[EMPTY NAME]";
		} else {
			this.driverName = driverName;
		}
	}

	public abstract float getRevenue();
}
