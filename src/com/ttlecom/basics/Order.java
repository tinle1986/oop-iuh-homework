package com.ttlecom.basics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Order {
	private static int orderCount = 0;
	private int orderId;
	private LocalDate orderDate;
	private int itemCount = 0;
	private final ArrayList<OrderDetail> lineItems;

	public Order() {
		setOrderId();
		setOrderDate(null);
		lineItems = new ArrayList<>();
	}

	public int getOrderId() {
		return orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public int getItemCount() {
		return itemCount;
	}

	public ArrayList<OrderDetail> getLineItems() {
		return lineItems;
	}

	public void setOrderId() {
		orderCount++;
		this.orderId = orderCount;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = Objects.requireNonNullElseGet(orderDate, LocalDate::now);
	}

	public void setItemCount() {
		this.itemCount++;
	}

	public void addLineItem(OrderDetail orderDetail) {
		this.lineItems.add(orderDetail);
		setItemCount();
	}

	public double calculateTotalCharge() {
		double total = 0;
		for (OrderDetail order : getLineItems()) {
			double subTotal = order.getQuantity() * order.getProduct().getPrice();
			total += subTotal;
		}
		return total;
	}

	@Override
	public String toString() {
		int count = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String orderDate = dtf.format(getOrderDate());

		String header = String.format("Order Id: %06d%n" + "Order date: %s%n" + "%-6s | %-10s | %-30s | %-16s | %-10s | %-16s%n",
						getOrderId(), orderDate, "#", "Product Id", "Description", "Unit price", "Quantity", "Subtotal");
		String footer = String.format("Item total: %,d%n" + "Charge total: %,.2f VND%n", getItemCount(), calculateTotalCharge());
		StringBuilder itemDetails = new StringBuilder();
		for (OrderDetail item : getLineItems()) {
			count++;
			itemDetails.append(String.format("%06d | %010d | %-30s | %12.2f VND | %10d | %,12.2f VND%n",
							count, item.getProduct().getId(), item.getProduct().getDescription(), item.getProduct().getPrice(), item.getQuantity(), item.calculateTotalPrice()));
		}

		return header + itemDetails + footer;
	}
}
