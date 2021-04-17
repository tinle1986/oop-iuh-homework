package com.ttlecom.inheritanceAndPolymorphism;

public class DollarTransaction extends Transaction {
	private DollarType dollarType;
	private float exchangeRate;

	public DollarTransaction(int id, String date, long quantity, float unitPrice, DollarType dollarType) {
		super(id, date, quantity);
		setDollarType(dollarType);
		setUnitPrice(unitPrice);
	}

	public DollarType getDollarType() {
		return dollarType;
	}

	public float getExchangeRate() {
		return exchangeRate;
	}

	public void setDollarType(DollarType dollarType) {
		this.dollarType = dollarType;
		switch (getDollarType()) {
			case USD -> setExchangeRate(23500);
			case EURO -> setExchangeRate(27600);
			default -> setExchangeRate(1);
		}
	}

	private void setExchangeRate(float exchangeRate) {
		this.exchangeRate = Math.max(0, exchangeRate);
	}

	@Override
	public double getPrice() {
		return getUnitPrice() * getQuantity() * getExchangeRate();
	}

	@Override
	public String toString() {
		String dollarType;
		switch (getDollarType()) {
			case EURO -> dollarType = "EUR";
			case USD -> dollarType = "USD";
			default -> dollarType = "VND";
		}
		return String.format("Id: %d | Date: %s | Unit price: %,.2f VND | Q'ty: %,d | Ex'rate: %,.2f VND | Dollar type: %s | Amount: %,.2f VND%n", getId(), getDate(), getUnitPrice(), getQuantity(), getExchangeRate(), dollarType, getPrice());
	}
}
