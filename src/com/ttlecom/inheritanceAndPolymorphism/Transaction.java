package com.ttlecom.inheritanceAndPolymorphism;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Transaction {
	private int id;
	private LocalDate date;
	private double unitPrice;
	private long quantity;

	public Transaction(int id, String date, long quantity) {
		setId(id);
		setDate(date);
		setQuantity(quantity);
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date);
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setId(int id) {
		if (id < 0) this.id = 999999;
		else this.id = Math.min(id, 999999);
	}

	public void setDate(String date) {
		this.date = convertStringToDate(date);
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = Math.max(0, unitPrice);
	}

	public void setQuantity(long quantity) {
		this.quantity = Math.max(0, quantity);
	}

	public LocalDate convertStringToDate(String strDate) {
		return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public abstract double getPrice();
}
