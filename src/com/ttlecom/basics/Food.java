package com.ttlecom.basics;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Food {
	private static int size = 0;
	private int code;
	private String name;
	private double price;
	private LocalDate manufactureDate;
	private LocalDate expirationDate;

	public Food() {
		setCode();
		setName(null);
		setPrice(-1);
		setManufactureDate(LocalDate.now());
		setExpirationDate(LocalDate.now());
	}

	public Food(String name, int price, LocalDate manufactureDate, LocalDate expirationDate) {
		setCode();
		setName(name);
		setPrice(price);
		setManufactureDate(manufactureDate);
		setExpirationDate(expirationDate);
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	private void setCode() {
		size++;
		this.code = size;
	}

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = "xxx";
		}
	}

	public void setPrice(int price) {
		this.price = Math.max(price, 0);
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		if (!manufactureDate.isBefore(LocalDate.now())) {
			this.manufactureDate = LocalDate.now();
		} else {
			this.manufactureDate = manufactureDate;
		}
	}

	public void setExpirationDate(LocalDate expirationDate) {
		if (!expirationDate.isAfter(this.manufactureDate)) {
			this.expirationDate = this.manufactureDate;
		} else {
			this.expirationDate = expirationDate;
		}
	}

	public boolean isExpiry() {
		return LocalDate.now().isAfter(getExpirationDate());
	}

	@Override
	public String toString() {
		String remark;
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String price = df.format(getPrice()) + " VND";

		if (isExpiry()) {
			remark = "Expired";
		} else {
			remark = "";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String mfd = dtf.format(getManufactureDate());
		String exd = dtf.format(getExpirationDate());
//		return String.format(" %03d   %-30s %,25.2f %-20s %-20s %-16s", getCode(), getName(), getPrice(), mfd, exd, remark);
		return String.format(" %03d   %-30s %25s %20s %20s %16s", getCode(), getName(), price, mfd, exd, remark);
	}
}