package com.ttlecom.inheritanceAndPolymorphism;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TextBook extends Book{
	private boolean newState;

	public TextBook(int id, String importDate, float unitPrice, int quantity, String publisher, boolean newState) {
		super(id, convertStringToDate(importDate), unitPrice, quantity, publisher);
		this.newState = newState;
	}

	public float getPrice() {
		if (isNewState()) {
			return getQuantity() * getUnitPrice();
		} else {
			return (float) (getQuantity() * getUnitPrice() * 0.5);
		}
	}

	public boolean isNewState() {
		return newState;
	}

	public void setNewState(boolean newState) {
		this.newState = newState;
	}

	private static LocalDate convertStringToDate(String strDate) {
		return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public String toString() {
		String condition;
		if(isNewState()) {
			condition = "New";
		} else {
			condition = "Old";
		}
		return String.format("Id: %d | Q'ty: %d | Unit price: %,.2f VND | Price: %,.2f VND | Condition: %s | Publisher: %s%n", getId(), getQuantity(), getUnitPrice(), getPrice(), condition, getPublisher());
	}
}
