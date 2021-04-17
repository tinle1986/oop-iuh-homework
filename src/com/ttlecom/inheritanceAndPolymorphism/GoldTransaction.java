package com.ttlecom.inheritanceAndPolymorphism;

public class GoldTransaction extends Transaction {
	private GoldType goldType;

	public GoldTransaction(int id, String date, long quantity, GoldType goldType) {
		super(id, date, quantity);
		setGoldType(goldType);
	}

	public GoldType getGoldType() {
		return goldType;
	}

	public void setGoldType(GoldType goldType) {
		this.goldType = goldType;
		switch (getGoldType()) {
			case K24 -> setUnitPrice(52000000);
			case K18 -> setUnitPrice(48500000);
			default -> setUnitPrice(55000000);
		}
	}

	public void setUnitPrice(float unitPrice) {
		super.setUnitPrice(unitPrice);
	}

	@Override
	public double getPrice() {
		return getUnitPrice() * getQuantity();
	}

	@Override
	public String toString() {
		String goldType;
		switch (getGoldType()) {
			case K24 -> goldType = "24K";
			case K18 -> goldType = "18K";
			default -> goldType = "9999";
		}
		return String.format("Id: %d | Date: %s | Unit price: %,.2f VND | Q'ty: %,d | Gold type: %s | Amount: %,.2f VND%n", getId(), getDate(), getUnitPrice(), getQuantity(), goldType, getPrice());
	}
}
