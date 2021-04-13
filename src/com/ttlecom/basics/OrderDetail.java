package com.ttlecom.basics;

public class OrderDetail {
	private int quantity;
	private Product product;

	public OrderDetail(Product product, int quantity) {
		setProduct(product);
		setQuantity(quantity);
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = Math.max(0, quantity);
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double calculateTotalPrice() {
		return getQuantity() * getProduct().getPrice();
	}

	@Override
	public String toString() {
		return String.format("Product name: %-30s Product quantity: %-10d", getProduct().getDescription(), getQuantity());
	}
}
