package com.ttlecom.inheritanceAndPolymorphism;

public class Truck extends Vehicle {
	private float unitPrice;
	private float weight;
	private TruckType truckType;

	public Truck(int routeId, String carNumber, String driverName, float unitPrice, float weight, TruckType truckType) {
		super(routeId, carNumber, driverName);
		setUnitPrice(unitPrice);
		setTruckType(truckType);
		setWeight(weight);

	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public float getWeight() {
		return weight;
	}

	public TruckType getTruckType() {
		return truckType;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = Math.max(0, unitPrice);
	}

	public void setWeight(float weight) {
		switch (getTruckType()) {
			case EIGHTTON -> {
				if (weight < 0) this.weight = 0;
				else this.weight = Math.min(weight, 8);
			}
			case SIXTEENTON -> {
				if (weight < 0) this.weight = 0;
				else this.weight = Math.min(weight, 16);
			}
			default -> this.weight = 0;
		}
	}

	public void setTruckType(TruckType truckType) {
		this.truckType = truckType;
	}

	@Override
	public float getRevenue() {
		switch (getTruckType()) {
			case EIGHTTON -> {
				return getUnitPrice() * getWeight();
			}
			case SIXTEENTON -> {
				return getUnitPrice() * getWeight() - 30000;
			}
			default -> {
				return 0;
			}
		}
	}

	@Override
	public String toString() {
		String truckType;
		switch (getTruckType()) {
			case EIGHTTON -> truckType = "8 tons";
			case SIXTEENTON -> truckType = "16 tons";
			default -> truckType = "Others";
		}
		return String.format("Route Id: %d | Driver name: %s | Unit price: %,.2f VND | No. of tons: %.2f | Truck type: %s | Revenue: %,.2f VND%n", getRouteId(), getDriverName() , getUnitPrice(), getWeight(), truckType, getRevenue());
	}
}
