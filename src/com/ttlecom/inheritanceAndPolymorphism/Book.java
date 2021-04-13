package com.ttlecom.inheritanceAndPolymorphism;

import java.time.LocalDate;

public class Book {
	private int id;
	private LocalDate importDate;
	private float unitPrice;
	private int quantity;
	private String publisher;

	public Book(int id, LocalDate importDate, float unitPrice, int quantity, String publisher) {
		this.id = id;
		this.importDate = importDate;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public LocalDate getImportDate() {
		return importDate;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setImportDate(LocalDate importDate) {
		this.importDate = importDate;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
