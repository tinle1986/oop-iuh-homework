package com.ttlecom.inheritanceAndPolymorphism;

public class Bus extends Vehicle {
	private int numberOfSeats;
	private float ticketPrice;

	public Bus(int routeId, String carNumber, String driverName, int numberOfSeats, float ticketPrice) {
		super(routeId, carNumber, driverName);
		setNumberOfSeats(numberOfSeats);
		setTicketPrice(ticketPrice);
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public float getTicketPrice() {
		return ticketPrice;
	}

	//	12 <= seats <= 50
	public void setNumberOfSeats(int numberOfSeats) {
		if (numberOfSeats < 12) this.numberOfSeats = 12;
		else this.numberOfSeats = Math.min(numberOfSeats, 50);
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = Math.max(10000, ticketPrice);
	}

	@Override
	public float getRevenue() {
		return getNumberOfSeats() * getTicketPrice();
	}

	@Override
	public String toString() {
		return String.format("Route Id: %d | Driver name: %s | Ticket price: %,.2f VND | No. of seats: %d | Revenue: %,.2f VND%n", getRouteId(), getDriverName() , getTicketPrice(), getNumberOfSeats(), getRevenue());
	}
}
