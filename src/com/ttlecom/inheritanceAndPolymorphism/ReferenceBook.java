package com.ttlecom.inheritanceAndPolymorphism;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReferenceBook extends Book {
	private float tax;

	public ReferenceBook(int id, String importDate, float unitPrice, int quantity, String publisher, float tax) {
		super(id, convertStringToDate(importDate), unitPrice, quantity, publisher);
		this.tax = tax;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getPrice() {
		return getQuantity() * getUnitPrice() + ((getTax() / 100f) * getQuantity() * getUnitPrice());
	}

	private static LocalDate convertStringToDate(String strDate) {
		return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public String toString() {
		return String.format("Id: %d | Q'ty: %d | Unit price: %,.2f VND | Tax: %,.2f%% | Price: %,.2f VND | Publisher: %s%n", getId(), getQuantity(), getUnitPrice(), getTax(), getPrice(), getPublisher());
	}
}
