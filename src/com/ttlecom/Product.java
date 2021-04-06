package com.ttlecom;

public class Product {
	private int id;
	private String description;
	private double price;

	public Product(int id, String description, double price) {
		setId(id);
		setDescription(description);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		if (id <= 0) {
			this.id = 999999;
		} else {
			this.id = Math.min(999999, id);
		}
	}

	public void setDescription(String description) {
		if (description == null || description.isEmpty()) {
			this.description = "Not described yet";
		} else {
			this.description = description;
		}
	}

	public void setPrice(double price) {
		this.price = Math.max(0, price);
	}

	@Override
	public String toString() {
		return String.format("Product Id: %-20d Product description: %-30s Product price: %-16.2f", getId(), getDescription(), getPrice());
	}
}
