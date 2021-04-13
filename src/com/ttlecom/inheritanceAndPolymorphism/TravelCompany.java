package com.ttlecom.inheritanceAndPolymorphism;

import java.util.ArrayList;

public class TravelCompany {
	private final ArrayList<UrbanTrip> urbanTripList;
	private final ArrayList<SuburbanTrip> suburbanTripList;

	public TravelCompany() {
		urbanTripList = new ArrayList<>();
		suburbanTripList = new ArrayList<>();
	}

	public void addUrbanTrip(UrbanTrip urbanTrip) {
		this.urbanTripList.add(urbanTrip);
	}

	public void addSuburbanTrip(SuburbanTrip suburbanTrip) {
		this.suburbanTripList.add(suburbanTrip);
	}

	public ArrayList<UrbanTrip> getUrbanTripList() {
		return urbanTripList;
	}

	public ArrayList<SuburbanTrip> getSuburbanTripList() {
		return suburbanTripList;
	}

	@Override
	public String toString() {
		float total;
		float subtotal1 = 0f;
		float subtotal2 = 0f;
		StringBuilder stringBuilder1 = new StringBuilder();
		StringBuilder stringBuilder2 = new StringBuilder();
		for(UrbanTrip urbanTrip: getUrbanTripList()) {
			subtotal1 = subtotal1 + urbanTrip.getRevenue();
			stringBuilder1.append(". ").append(urbanTrip);
		}
		for(SuburbanTrip suburbanTrip: getSuburbanTripList()) {
			subtotal2 = subtotal2 + suburbanTrip.getRevenue();
			stringBuilder2.append(". ").append(suburbanTrip);
		}
		total = subtotal1 + subtotal2;
		return String.format("The total revenue: %,.2f%n" +
						"urban trips:".toUpperCase() + "%n" +
						stringBuilder1 +
						". The subtotal revenue: %,.2f%n" +
						"suburban trips:".toUpperCase() + "%n" +
						stringBuilder2 +
						". The subtotal revenue: %,.2f%n", total, subtotal1, subtotal2);
	}
}
