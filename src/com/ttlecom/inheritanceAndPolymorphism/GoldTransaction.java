package com.ttlecom.inheritanceAndPolymorphism;

public class GoldTransaction extends Transaction {
	private GoldType goldType;

	public GoldTransaction(int id, String date, DollarType unitPrice, int quantity, GoldType goldType) {
		super(id, date, unitPrice, quantity);
		this.goldType = goldType;
	}

	public GoldType getGoldType() {
		return goldType;
	}

	public void setGoldType(GoldType goldType) {
		this.goldType = goldType;
	}

//	@Override
//	public DollarType getUnitPrice() {
//		switch (getGoldType()) {
//			case K24 -> {
//				return 4000000;
//			}
//			case K18 -> {
//				return 38000000;
//			}
//			default -> {
//				return 50000000;
//			}
//		}
//	}
//
//	public float getPrice() {
//		return getUnitPrice() * getQuantity();
//	}
}
