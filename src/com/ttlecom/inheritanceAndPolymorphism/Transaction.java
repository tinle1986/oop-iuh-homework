package com.ttlecom.inheritanceAndPolymorphism;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private int id;
	private LocalDate date;
	private DollarType unitPrice;
	private int quantity;

	public Transaction(int id, String date, DollarType unitPrice, int quantity) {
		this.id = id;
		this.date = convertStringToDate(date);
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public DollarType getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(DollarType unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate convertStringToDate(String strDate) {
		return LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
